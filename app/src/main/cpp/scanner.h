//
// Created by Liang on 2017/3/27.
//

#ifndef OPENCVTEST_SCANNER_H
#define OPENCVTEST_SCANNER_H


#include <opencv2/core/mat.hpp>
using namespace cv;
using namespace std;

void ScannerCrop(Mat *img, jint *sropArray);
void ScannerCut(Mat *img, jint *sropArray,Mat *dst);
void getPoints(Mat * image, jint *ptr);
#endif //OPENCVTEST_SCANNER_H
