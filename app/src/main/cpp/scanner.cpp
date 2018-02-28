//
// Created by Liang on 2017/3/22.
//

#include <android/log.h>
#include <string>
#include <bits/stdc++.h>
#include <opencv2/imgproc/types_c.h>
#include <opencv2/imgproc.hpp>
#include <jni.h>

#define  LOG_TAG    "JNI_PART"
#define LOGI(...)  __android_log_print(ANDROID_LOG_INFO,LOG_TAG, __VA_ARGS__)
#define LOGD(...)  __android_log_print(ANDROID_LOG_DEBUG,LOG_TAG, __VA_ARGS__)
#define LOGW(...)  __android_log_print(ANDROID_LOG_WARN,LOG_TAG, __VA_ARGS__)
#define LOGE(...)  __android_log_print(ANDROID_LOG_ERROR,LOG_TAG, __VA_ARGS__)
#define LOGF(...)  __android_log_print(ANDROID_LOG_FATAL,LOG_TAG, __VA_ARGS__)
using namespace cv;
using namespace std;

/**
 * Get edges of an image               获取图片边界
 * @param gray - grayscale input image 图片灰度图
 * @param canny - output edge image    输出边界
 * 直接灰度处理后用canny算子检测边缘
 */
void getCanny(Mat gray, Mat &canny) {
    Mat thres;
    double high_thres = threshold(gray, thres, 0, 255,
                                  CV_THRESH_BINARY | CV_THRESH_OTSU), low_thres = high_thres * 0.5;
    Canny(gray, canny, low_thres, high_thres);
}

struct Line {
    cv::Point _p1;
    cv::Point _p2;
    cv::Point _center;

    //Line的构造函数
    Line(cv::Point p1, cv::Point p2) {
        _p1 = p1;
        _p2 = p2;
        _center = cv::Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
    }
};

bool cmp_y(const Line &p1, const Line &p2) {
    return p1._center.y < p2._center.y;
}

bool cmp_x(const Line &p1, const Line &p2) {
    return p1._center.x < p2._center.x;
}

/**
 * Compute intersect point of two lines l1 and l2  获取两条线条的交点
 * @param l1
 * @param l2
 * @return Intersect Point                         返回交叉点
 */
Point2f computeIntersect(Line l1, Line l2) {
    int x1 = l1._p1.x, x2 = l1._p2.x, y1 = l1._p1.y, y2 = l1._p2.y;
    int x3 = l2._p1.x, x4 = l2._p2.x, y3 = l2._p1.y, y4 = l2._p2.y;
    if (float d = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4)) {
        Point2f pt;
        pt.x = ((x1 * y2 - y1 * x2) * (x3 - x4) - (x1 - x2) * (x3 * y4 - y3 * x4)) / d;
        pt.y = ((x1 * y2 - y1 * x2) * (y3 - y4) - (y1 - y2) * (x3 * y4 - y3 * x4)) / d;
        return pt;
    }
    return Point2f(-1, -1);
}

//开始四边形检测

void RectDetect(Mat *img, Mat *dst) {

    // resize input image to img_proc to reduce computation
    Mat img_proc;
    int w = (*img).size().width, h = (*img).size().height, min_w = 200;
    double scale = min(10.0, w * 1.0 / min_w);
    int w_proc = w * 1.0 / scale, h_proc = h * 1.0 / scale;
    resize(*img, img_proc, cv::Size(w_proc, h_proc));
    Mat img_dis = img_proc.clone();

    /* 直接灰度处理后用canny算子检测边缘
    *  get four outline edges of the document
    */
    // get edges of the image
    Mat gray, canny;
    cvtColor(img_proc, gray, CV_BGR2GRAY);
    getCanny(gray, canny);

/* 直线检测
  直线检测就是利用概率霍夫变换累加求出图像中的直线。这里我们可以对后面的参数做
  些微调，在我们的参数里，假设了纸张的宽度和高度都接近边缘，并且各自至少大于画
  面宽高的一半，那么过短的线就可以直接抛弃了。
  w_proc 就是缩小后的画面宽度，20是把间距20以内的线段延长拼接为一条直线
 */
/*
  lines，就是我们得到的所有线的集合，每条线包含点的偏移和向量。
  如何判断其中哪些是有效的多边形，或者说我们要的多边形，对我来说蛮纠结的。
  有的 例子 里直接HoughLinesP跑完就有了，我测试的图基本都不行。
  这里 的方法是把所有横向的线中取最上和最下两条，纵向线中取最左和最右两条。
  这里是基于纸张正放的假设，如果侧放就不行了
 */
// extract lines from the edge image
    vector<Vec4i> lines;
    vector<Line> horizontals, verticals;
    HoughLinesP(canny, lines, 1, CV_PI / 180, w_proc / 3, w_proc / 3, 20);
    for (size_t i = 0; i < lines.size(); i++) {
        Vec4i v = lines[i];
        double delta_x = v[0] - v[2], delta_y = v[1] - v[3];
        Line l(cv::Point(v[0], v[1]), cv::Point(v[2], v[3]));
        // get horizontal lines and vertical lines respectively
        if (fabs(delta_x) > fabs(delta_y)) {
            horizontals.push_back(l);
        } else {
            verticals.push_back(l);
        }
    }

    // 丢掉长度不足20的线
    if (horizontals.size() < 2) {
        if (horizontals.size() == 0 || horizontals[0]._center.y > h_proc / 2) {
            horizontals.push_back(Line(cv::Point(0, 0), cv::Point(w_proc - 1, 0)));
        }
        if (horizontals.size() == 0 || horizontals[0]._center.y <= h_proc / 2) {
            horizontals.push_back(
                    Line(cv::Point(0, h_proc - 1), cv::Point(w_proc - 1, h_proc - 1)));
        }
    }
    if (verticals.size() < 2) {
        if (verticals.size() == 0 || verticals[0]._center.x > w_proc / 2) {
            verticals.push_back(Line(cv::Point(0, 0), cv::Point(0, h_proc - 1)));
        }
        if (verticals.size() == 0 || verticals[0]._center.x <= w_proc / 2) {
            verticals.push_back(Line(cv::Point(w_proc - 1, 0), cv::Point(w_proc - 1, h_proc - 1)));
        }
    }


    //根据线条重点判断最上一条、最下一条，最左一条、最右一条； sort lines according to their center point
    sort(horizontals.begin(), horizontals.end(), cmp_y);
    sort(verticals.begin(), verticals.end(), cmp_x);

    /** 透视变换 用getPerspectiveTransform 计算转化矩阵，再用warpPerspective 调用转化矩阵进行拉伸。*/
    // 边缘检测计算得到的四边形边缘 交点
    Point2f tlA, trB, blC, brD;
    tlA = computeIntersect(horizontals[0], verticals[0]);
    trB = computeIntersect(horizontals[0], verticals[verticals.size() - 1]);
    blC = computeIntersect(horizontals[horizontals.size() - 1], verticals[0]);
    brD = computeIntersect(horizontals[horizontals.size() - 1], verticals[verticals.size() - 1]);
    //NSLog(@"四个交点:tlA(%.2f,%.2f)\ntrB(%.2f,%.2f)\nblC(%.2f,%.2f)\nbrD(%.2f,%.2f)",tlA.x,tlA.y,trB.x,trB.y,blC.x,blC.y,brD.x,brD.y);




/* 透视变换 perspective transformation
   用getPerspectiveTransform 计算转化矩阵，再用warpPerspective 调用转化矩阵进行拉伸。
 */
// define the destination image size: A4 - 200 PPI
    int w_a4 = 1654, h_a4 = 2339;
    //int w_a4 = 595, h_a4 = 842;
    *dst = Mat::zeros(h_a4, w_a4, CV_8UC3);

    //图片的边角
    // corners of destination image with the sequence [tl, tr, bl, br]
    vector<Point2f> dst_pts, img_pts;
    dst_pts.push_back(cv::Point(0, 0));              //A
    dst_pts.push_back(cv::Point(w_a4 - 1, 0));       //B
    dst_pts.push_back(cv::Point(0, h_a4 - 1));       //C
    dst_pts.push_back(cv::Point(w_a4 - 1, h_a4 - 1));//D

    // corners of source image with the sequence [tl, tr, bl, br]
    img_pts.push_back(computeIntersect(horizontals[0], verticals[0]));
    img_pts.push_back(computeIntersect(horizontals[0], verticals[verticals.size() - 1]));
    img_pts.push_back(computeIntersect(horizontals[horizontals.size() - 1], verticals[0]));
    img_pts.push_back(
            computeIntersect(horizontals[horizontals.size() - 1], verticals[verticals.size() - 1]));


//尺寸变换
// convert to original image scale
    for (size_t i = 0; i < img_pts.size(); i++) {
// for visualization only
//if (debug) {
        circle(img_proc, img_pts[i], 10, Scalar(255, 255, 0), 3);
//}
        img_pts[i].x *= scale;
        img_pts[i].y *= scale;
    }

//获取变换矩阵
// get transformation matrix
    Mat transmtx = getPerspectiveTransform(img_pts, dst_pts);

// apply perspective transformation
    warpPerspective(*img, *dst, transmtx, (*dst).size());
}

/**
 * 获取自动识别出的的四个点坐标
 * 0*********1
 * *         *
 * *         *
 * *         *
 * 2*********3
 * img：原始mat对象
 * sropArray：坐标数组
 * */
void ScannerCrop(Mat *img, jint *sropArray) {
    // resize input image to img_proc to reduce computation
    Mat img_proc;
    int w = (*img).size().width, h = (*img).size().height, min_w = 200;
    double scale = min(10.0, w * 1.0 / min_w);
    int w_proc = w * 1.0 / scale, h_proc = h * 1.0 / scale;
    resize(*img, img_proc, cv::Size(w_proc, h_proc));
    Mat img_dis = img_proc.clone();

    /* 直接灰度处理后用canny算子检测边缘
    *  get four outline edges of the document
    */
    // get edges of the image
    Mat gray, canny;
    cvtColor(img_proc, gray, CV_BGR2GRAY);
    getCanny(gray, canny);

/* 直线检测
  直线检测就是利用概率霍夫变换累加求出图像中的直线。这里我们可以对后面的参数做
  些微调，在我们的参数里，假设了纸张的宽度和高度都接近边缘，并且各自至少大于画
  面宽高的一半，那么过短的线就可以直接抛弃了。
  w_proc 就是缩小后的画面宽度，20是把间距20以内的线段延长拼接为一条直线
 */
/*
  lines，就是我们得到的所有线的集合，每条线包含点的偏移和向量。
  如何判断其中哪些是有效的多边形，或者说我们要的多边形，对我来说蛮纠结的。
  有的 例子 里直接HoughLinesP跑完就有了，我测试的图基本都不行。
  这里 的方法是把所有横向的线中取最上和最下两条，纵向线中取最左和最右两条。
  这里是基于纸张正放的假设，如果侧放就不行了
 */
// extract lines from the edge image
    vector<Vec4i> lines;
    vector<Line> horizontals, verticals;
    HoughLinesP(canny, lines, 1, CV_PI / 180, w_proc / 3, w_proc / 3, 20);
    for (size_t i = 0; i < lines.size(); i++) {
        Vec4i v = lines[i];
        double delta_x = v[0] - v[2], delta_y = v[1] - v[3];
        Line l(cv::Point(v[0], v[1]), cv::Point(v[2], v[3]));
        // get horizontal lines and vertical lines respectively
        if (fabs(delta_x) > fabs(delta_y)) {
            horizontals.push_back(l);
        } else {
            verticals.push_back(l);
        }
    }

    // 丢掉长度不足20的线
    if (horizontals.size() < 2) {
        if (horizontals.size() == 0 || horizontals[0]._center.y > h_proc / 2) {
            horizontals.push_back(Line(cv::Point(0, 0), cv::Point(w_proc - 1, 0)));
        }
        if (horizontals.size() == 0 || horizontals[0]._center.y <= h_proc / 2) {
            horizontals.push_back(
                    Line(cv::Point(0, h_proc - 1), cv::Point(w_proc - 1, h_proc - 1)));
        }
    }
    if (verticals.size() < 2) {
        if (verticals.size() == 0 || verticals[0]._center.x > w_proc / 2) {
            verticals.push_back(Line(cv::Point(0, 0), cv::Point(0, h_proc - 1)));
        }
        if (verticals.size() == 0 || verticals[0]._center.x <= w_proc / 2) {
            verticals.push_back(Line(cv::Point(w_proc - 1, 0), cv::Point(w_proc - 1, h_proc - 1)));
        }
    }


    //根据线条重点判断最上一条、最下一条，最左一条、最右一条； sort lines according to their center point
    sort(horizontals.begin(), horizontals.end(), cmp_y);
    sort(verticals.begin(), verticals.end(), cmp_x);

    /** 透视变换 用getPerspectiveTransform 计算转化矩阵，再用warpPerspective 调用转化矩阵进行拉伸。*/
    // 边缘检测计算得到的四边形边缘 交点
    Point2f tlA, trB, blC, brD;
    tlA = computeIntersect(horizontals[0], verticals[0]);
    trB = computeIntersect(horizontals[0], verticals[verticals.size() - 1]);
    blC = computeIntersect(horizontals[horizontals.size() - 1], verticals[0]);
    brD = computeIntersect(horizontals[horizontals.size() - 1], verticals[verticals.size() - 1]);

    // 初始化透视转换后的四个边角 、初始化透射变换后的图片矩阵、初始化投射变换前后的交点向量
    // corners of destination image with the sequence [tlA, trB, blC, brD]
    vector<Point2f> img_pts;
    img_pts.push_back(tlA);
    img_pts.push_back(trB);
    img_pts.push_back(blC);
    img_pts.push_back(brD);

    /**给数组坐标赋值*/
    sropArray[0] = (int) (tlA.x * scale);
    sropArray[1] = (int) (tlA.y * scale);
    sropArray[2] = (int) (trB.x * scale);
    sropArray[3] = (int) (trB.y * scale);
    sropArray[4] = (int) (blC.x * scale);
    sropArray[5] = (int) (blC.y * scale);
    sropArray[6] = (int) (brD.x * scale);
    sropArray[7] = (int) (brD.y * scale);

    LOGE("OpenCV 视图比例 = %d", (int) scale);
}

/**
 * 获取自动识别出的的四个点坐标
 * img：原始mat对象
 * sropArray：坐标数组
 * dst：裁剪后的mat对象
 * */
void ScannerCut(Mat *img, jint *sropArray, Mat *dst) {

    int x1 = sropArray[0];
    int x2 = sropArray[2];
    int x3 = sropArray[4];
    int x4 = sropArray[6];

    int y1 = sropArray[1];
    int y2 = sropArray[3];
    int y3 = sropArray[5];
    int y4 = sropArray[7];

    Point2f tlA, trB, blC, brD;
    tlA = Point2f(x1, y1);
    trB = Point2f(x2, y2);
    blC = Point2f(x3, y3);
    brD = Point2f(x4, y4);

    LOGE("x1 = %d", x1);
    LOGE("x2 = %d", x2);
    LOGE("x3 = %d", x3);
    LOGE("x4 = %d", x4);
    LOGE("y1 = %d", y1);
    LOGE("y2 = %d", y2);
    LOGE("y3 = %d", y3);
    LOGE("y4 = %d", y4);

    //获取截图最高高度、最长宽度
    float w1 = sqrt(pow(x4 - x3, 2) + pow(y4 - y3, 2));
    float w2 = sqrt(pow(x2 - x1, 2) + pow(y2 - y1, 2));
    float h1 = sqrt(pow(x2 - x4, 2) + pow(y2 - y4, 2));
    float h2 = sqrt(pow(x1 - x3, 2) + pow(y1 - y3, 2));

    int maxWidth = (int) ((w1 < w2) ? w1 : w2);
    int maxHeight = (int) ((h1 < h2) ? h1 : h2);

    //判断是否和
    //调试发现，最大值只能为4096
    if (maxWidth > 4096) {
        maxWidth = 4096;
        maxHeight = maxHeight * 4096 / maxWidth;
    }

    if (maxHeight > 4096) {
        maxHeight = 4096;
        maxWidth = maxWidth * 4096 / maxHeight;
    }

    LOGE("maxWidth = %d", maxWidth);
    LOGE("maxHeight = %d", maxHeight);

    //1.初始化投射变换前后的交点向量
    // corners of destination image with the sequence [tlA, trB, blC, brD]
    vector<Point2f> dst_pts, img_pts;
    dst_pts.push_back(cv::Point(0, 0));              //A
    dst_pts.push_back(cv::Point(maxWidth - 1, 0));       //B
    dst_pts.push_back(cv::Point(0, maxHeight - 1));       //C
    dst_pts.push_back(cv::Point(maxWidth - 1, maxHeight - 1));//D

    img_pts.push_back(tlA);
    img_pts.push_back(trB);
    img_pts.push_back(blC);
    img_pts.push_back(brD);

    // 计算转化矩阵
    Mat transmtx = getPerspectiveTransform(img_pts, dst_pts);
    // 调用转化矩阵进行拉伸
    *dst = Mat::zeros(maxHeight, maxWidth, CV_8UC3);
    warpPerspective(*img, *dst, transmtx, (*dst).size());
}

double angle(cv::Point pt1, cv::Point pt2, cv::Point pt0) {
    double dx1 = pt1.x - pt0.x;
    double dy1 = pt1.y - pt0.y;
    double dx2 = pt2.x - pt0.x;
    double dy2 = pt2.y - pt0.y;
    return (dx1 * dx2 + dy1 * dy2) /
           sqrt((dx1 * dx1 + dy1 * dy1) * (dx2 * dx2 + dy2 * dy2) + 1e-10);
}

void getPoints(Mat * image, jint *ptr) {

    Mat img_proc;
    int w = (*image).size().width, h = (*image).size().height, min_w = 200;
    double scale = min(10.0, w * 1.0 / min_w);
    int w_proc = w * 1.0 / scale, h_proc = h * 1.0 / scale;
    resize(*image, img_proc, cv::Size(w_proc, h_proc));

    //int width = (*image).size().width;
    //int height = (*image).size().height;
    //Mat image_proc = (*image).clone();
    vector<vector<Point> > squares;
    // blur will enhance edge detection
    Mat blurred(img_proc);
    medianBlur(img_proc, blurred, 9);

    Mat gray0(blurred.size(), CV_8U), gray;
    vector<vector<Point> > contours;

    // find squares in every color plane of the image
    for (int c = 0; c < 3; c++) {
        int ch[] = {c, 0};
        mixChannels(&blurred, 1, &gray0, 1, ch, 1);

        // try several threshold levels
        const int threshold_level = 2;
        for (int l = 0; l < threshold_level; l++) {
            // Use Canny instead of zero threshold level!
            // Canny helps to catch squares with gradient shading
            if (l == 0) {
                Canny(gray0, gray, 10, 20, 3); //

                // Dilate helps to remove potential holes between edge segments
                dilate(gray, gray, Mat(), Point(-1, -1));
            } else {
                gray = gray0 >= (l + 1) * 255 / threshold_level;
            }

            // Find contours and store them in a list
            findContours(gray, contours, CV_RETR_LIST, CV_CHAIN_APPROX_SIMPLE);

            // Test contours
            vector<Point> approx;
            for (size_t i = 0; i < contours.size(); i++) {
                // approximate contour with accuracy proportional
                // to the contour perimeter
                approxPolyDP(Mat(contours[i]), approx, arcLength(Mat(contours[i]), true) * 0.02,
                             true);

                // Note: absolute value of an area is used because
                // area may be positive or negative - in accordance with the
                // contour orientation
                if (approx.size() == 4 &&
                    fabs(contourArea(Mat(approx))) > 1000 &&
                    isContourConvex(Mat(approx))) {
                    double maxCosine = 0;

                    for (int j = 2; j < 5; j++) {
                        double cosine = fabs(angle(approx[j % 4], approx[j - 2], approx[j - 1]));
                        maxCosine = MAX(maxCosine, cosine);
                    }

                    if (maxCosine < 0.3)
                        squares.push_back(approx);
                }
            }
        }

        double largest_area = -1;
        int largest_contour_index = 0;
        for (int i = 0; i < squares.size(); i++) {
            double a = contourArea(squares[i], false);
            if (a > largest_area) {
                largest_area = a;
                largest_contour_index = i;
            }
        }

        vector<Point> points;
        if (squares.size() > 0) {
            points = squares[largest_contour_index];
        } else {
            points.push_back(Point(0, 0));
            points.push_back(Point(w_proc, 0));
            points.push_back(Point(0, h_proc));
            points.push_back(Point(w_proc, h_proc));
        }

        ptr[0] = (int)(points[0].x* scale);
        ptr[1] = (int)(points[0].y* scale);
        ptr[2] = (int)(points[1].x* scale);
        ptr[3] = (int)(points[1].y* scale);
        ptr[4] = (int)(points[3].x* scale);
        ptr[5] = (int)(points[3].y* scale);
        ptr[6] = (int)(points[2].x* scale);
        ptr[7] = (int)(points[2].y* scale);

        LOGE("points[0].x = %d",points[0].x);
        LOGE("points[0].y = %d",points[0].y);
        LOGE("points[1].x = %d",points[1].x);
        LOGE("points[1].y = %d",points[1].y);
        LOGE("points[2].x = %d",points[2].x);
        LOGE("points[2].y = %d",points[2].y);
        LOGE("points[3].x = %d",points[3].x);
        LOGE("points[3].y = %d",points[3].y);
    }
}

