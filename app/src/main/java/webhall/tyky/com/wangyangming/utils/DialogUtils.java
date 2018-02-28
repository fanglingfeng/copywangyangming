package webhall.tyky.com.wangyangming.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.widget.ProgressBar;
import android.widget.TextView;


/**
 * Created by lenovo on 2017/1/16.
 */

public class DialogUtils {
    private Activity mActivity;
    private ProgressBar progressBar;
    private TextView progressPercent;
    private ProgressDialog downloadDialog;
    private AlertDialog alertDialog;

    public DialogUtils(Activity mActivity) {
        this.mActivity = mActivity;
    }

    /**
     * v7包提示对话框
     *
     * @param title 标题
     * @param msg 提示内容
     * @param cancelable 是否可以关闭
     */
//    public void showAdviceDialog(final String title, final String msg, boolean cancelable) {
//        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(mActivity);
//        builder.setTitle(title);
//        if (!TextUtils.isEmpty(msg)) {
//            builder.setMessage(msg);
//        } else {
//            builder.setMessage("");
//        }
//        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                dialog.dismiss();
//            }
//        });
//        builder.setCancelable(cancelable);
//        builder.show();
//    }
//
//    public void showSearchDialog(final DialogUtilsInterface callBack) {
//        final View view = LayoutInflater.from(mActivity).inflate(R.layout.edit_text_dialog_layout, null);//这里必须是final的
//        final EditText edit = (EditText) view.findViewById(R.id.search_et);//获得输入框对象
//        AlertDialog.Builder builder = new AlertDialog.Builder(mActivity, R.style.SearchAlertDialogStyle);
//        alertDialog = builder.show();
//        builder.setTitle("请输入搜索关键字")//提示框标题
//                .setView(view)
//                .setPositiveButton("搜索",//提示框的两个按钮
//                        new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog,
//                                                int which) {
//                                InputMethodUtils.hideInputMethod(view);
//                                dialog.cancel();
//                                String inputString = edit.getText().toString();
//                                callBack.inputInfo(inputString);
//                            }
//                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                InputMethodUtils.hideInputMethod(view);
//                dialog.cancel();
//            }
//        }).setCancelable(false).create().show();
//        if (alertDialog.getWindow() != null) {
//            alertDialog.getWindow().setWindowAnimations(R.style.alert_dialog_anim_style);
//        }
//
//    }
//
//    public void showDownloadDialog(String paramString, View.OnClickListener positiveClick, View.OnClickListener cancelClick) {
//        alertDialog = new AlertDialog.Builder(mActivity).create();
//        alertDialog.show();
//        Window window = alertDialog.getWindow();
//        // *** 主要就是在这里实现这种效果的.
//        // 设置窗口的内容页面,shrew_exit_dialog.xml文件中定义view内容
//        window.setContentView(R.layout.common_alert_dialog_custom);
//        TextView tv = (TextView) window
//                .findViewById(R.id.iknow_alert_dialog_content_message);
//        if (StringUtils.isEmptyAddNull(paramString)) {
//            tv.setText("有最新的软件包哦，亲快下载吧~");
//        } else {
//            tv.setText(paramString);
//        }
//        // 为确认按钮添加事件,执行退出应用操作
//        Button ok = (Button) window
//                .findViewById(R.id.iknow_alert_dialog_button2);
//        ok.setOnClickListener(positiveClick);
//
//        // 关闭alert对话框架
//        Button cancel = (Button) window
//                .findViewById(R.id.iknow_alert_dialog_button1);
//        cancel.setOnClickListener(cancelClick);
//    }
//
//    public void showDownloadProgressDialog(View.OnClickListener iKnowBtnClick, DialogInterface.OnClickListener cancelClick) {
//        downloadDialog = new ProgressDialog(mActivity);
//        downloadDialog.show();
//        downloadDialog.setContentView(R.layout.downloadprogress);
//        TextView title = (TextView) downloadDialog.findViewById(R.id.iknow_alert_dialog_title_text);
//        TextView message = (TextView) downloadDialog.findViewById(R.id.iknow_alert_dialog_content_message);
//        Button button = (Button) downloadDialog.findViewById(R.id.iknow_alert_dialog_button);
//        progressBar = (ProgressBar) downloadDialog.findViewById(R.id.download_process);
//        progressPercent = (TextView) downloadDialog.findViewById(R.id.download_process_percent);
//        title.setText("版本更新");
//        message.setText("亲~，正在下载更新包，请稍候");
//
//        button.setOnClickListener(iKnowBtnClick);
//
//        downloadDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);// 设置水平进度条
//        downloadDialog.setCancelable(false);// 设置是否可以通过点击Back键取消
//        downloadDialog.setCanceledOnTouchOutside(false);// 设置在点击Dialog外是否取消Dialog进度条
//        downloadDialog.setIcon(R.mipmap.ic_launcher);// 设置提示的title的图标，默认是没有的
//        downloadDialog.setTitle("版本更新");
//        downloadDialog.setMessage("亲~，正在下载更新包，请稍候");
//        downloadDialog.setMax(100);
//        downloadDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "取消下载", cancelClick);
//    }
//
//    public void setDownloadProgress(int progress) {
//        if (progressBar != null) {
//            progressBar.setProgress(progress);
//        }
//        if (progressPercent != null) {
//            progressPercent.setText(progress + "%");
//        }
//    }
//
//    public void dismissDownloadProgressDialog() {
//        if (downloadDialog != null && downloadDialog.isShowing()) {
//            downloadDialog.dismiss();
//        }
//    }
//
//    public void dismissDownloadDialog() {
//        if (alertDialog != null && alertDialog.isShowing()) {
//            alertDialog.dismiss();
//        }
//    }
//
//    public static void showWarnDialog(final Context context, String title, String message, String positiveMsg, DialogInterface.OnClickListener listener) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(context);
//        builder.setTitle(title)            //
//                .setMessage(message).setPositiveButton(positiveMsg, listener).setNegativeButton("取消", null).show();
//    }
//
//    public static void showWarnDialog(final Context context, String title, String message, String positiveMsg, DialogInterface.OnClickListener listener,String negativeMsg) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(context);
//        builder.setTitle(title)            //
//                .setMessage(message).setPositiveButton(positiveMsg, listener).setNegativeButton(negativeMsg, null).show();
//    }
//    /**
//     * 提示游客登录
//     */
//    public static void showLoginDialog(final Context context) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(context);
//        View view = LayoutInflater.from(context).inflate(R.layout.dialog_title,null);
//        ImageView imageView = (ImageView) view.findViewById(R.id.content);
//        TextView titleTv = (TextView) view.findViewById(R.id.title);
//        titleTv.setText(R.string.app_name);
//        imageView.setImageResource(R.mipmap.ic_launcher);
//        builder .setCustomTitle(view)          //
//                .setMessage("登录后才能使用该功能").setPositiveButton("去登录", new DialogInterface.OnClickListener() {
//
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Intent intent = new Intent();
//                intent.setClass(context, LoginActivity.class);
//                context.startActivity(intent);
//            }
//        }).setNegativeButton("知道了", null).show();
//    }
//
//    /**
//     * 登录超时，重新登录
//     */
//    public static void showLoginTimeOutDialog(final Context context) {
//        Activity activity = (Activity) context;
//        if (activity != null) {
//            activity.runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
//                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
//                    builder.setIcon(R.mipmap.ic_launcher)         //
//                            .setTitle(R.string.app_name)            //
//                            .setMessage("登录超时，请重新登录").setPositiveButton("去登录", new DialogInterface.OnClickListener() {
//
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            Intent intent = new Intent();
//                            intent.setClass(context, LoginActivity.class);
//                            context.startActivity(intent);
//                        }
//                    }).show();
//                }
//            });
//        }
//    }
//
//    /**
//     * 二维码
//     */
//    public static void showQRCode(final Context context, String title, String content) {
//        Observable.just(QRCodeEncoder.syncEncodeQRCode(content, BGAQRCodeUtil.dp2px(context, 150), Color.parseColor("#3399ff")))
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<Bitmap>() {
//                    @Override
//                    public void accept(Bitmap bitmap) throws Exception {
//
//                        View view = LayoutInflater.from(context).inflate(R.layout.dialog_notepad_qrcode,null);
//                        ImageView imageView = (ImageView) view.findViewById(R.id.content);
//                        TextView titleTv = (TextView) view.findViewById(R.id.title);
//                        titleTv.setText(title);
//                        imageView.setImageBitmap(bitmap);
//                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
//                        builder.setView(view)
//                                .show();
//                    }
//                });
//
//
//    }
//
//
//    public interface DialogUtilsInterface {
//        void inputInfo(String input);
//    }
}

