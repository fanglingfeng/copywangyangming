//
// Created by Liang on 2017/3/22.
//

#include <jni.h>
#include <string>
#include <opencv2/opencv.hpp>
#include "scanner.h"

using namespace cv;
using namespace std;

#define  LOG_TAG    "JNI_SCANNER_MANAGER"
#define LOGI(...)  __android_log_print(ANDROID_LOG_INFO,LOG_TAG, __VA_ARGS__)
#define LOGD(...)  __android_log_print(ANDROID_LOG_DEBUG,LOG_TAG, __VA_ARGS__)
#define LOGW(...)  __android_log_print(ANDROID_LOG_WARN,LOG_TAG, __VA_ARGS__)
#define LOGE(...)  __android_log_print(ANDROID_LOG_ERROR,LOG_TAG, __VA_ARGS__)
#define LOGF(...)  __android_log_print(ANDROID_LOG_FATAL,LOG_TAG, __VA_ARGS__)

extern "C" {

JNIEXPORT void JNICALL
Java_com_tyky_nativelib_ScannerManager_beginCrop(JNIEnv *env, jobject instance, jlong addrMat,
                                                 jintArray Crop_) {

    // TODO
    Mat *img = (Mat *) addrMat;
    jint *Crop = env->GetIntArrayElements(Crop_, NULL);

    ScannerCrop(img,Crop);
    //释放内存
    env->ReleaseIntArrayElements(Crop_, Crop, 0);
}

JNIEXPORT void JNICALL
Java_com_tyky_nativelib_ScannerManager_beginCut(JNIEnv *env, jobject instance, jlong addrMat,
                                                jintArray Crop_, jlong addrDst) {
    jint *Crop = env->GetIntArrayElements(Crop_, NULL);

    // TODO
    Mat *img = (Mat *) addrMat;
    Mat *dst = (Mat *) addrDst;


    ScannerCut(img,Crop,dst);
    env->ReleaseIntArrayElements(Crop_, Crop, 0);
}

JNIEXPORT void JNICALL
Java_com_tyky_nativelib_ScannerManager_beginPoints(JNIEnv *env, jobject instance, jlong addrMat,
                                                   jintArray Crop_) {
    // TODO
    jint *Crop = env->GetIntArrayElements(Crop_, NULL);
    Mat *img = (Mat *) addrMat;

    getPoints(img,Crop);

    env->ReleaseIntArrayElements(Crop_, Crop, 0);
}

}