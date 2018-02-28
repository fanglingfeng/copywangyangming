package webhall.tyky.com.wangyangming.mvp.start;

import android.graphics.Color;
import android.view.View;

import net.liang.appbaselibrary.base.BaseAppCompatActivity;
import net.liang.appbaselibrary.base.mvp.MvpPresenter;

import butterknife.BindView;
import butterknife.OnClick;
import webhall.tyky.com.wangyangming.R;
import webhall.tyky.com.wangyangming.mvp.login.LoginActivity;
import webhall.tyky.com.wangyangming.wights.CircleTextProgressbar;

/**
 * Created by Dino on 1/3 0003.
 */

public class AppStart extends BaseAppCompatActivity {
    @BindView(R.id.timer)
    CircleTextProgressbar timer;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_app_start;
    }

    @Override
    protected MvpPresenter getPresenter() {
        return null;
    }

    @Override
    public void init() {

        timer.setCountdownProgressListener(1, progressListener);
        timer.setProgressType(CircleTextProgressbar.ProgressType.COUNT);
        timer.setTimeMillis(3000);
        timer.setOutLineColor(Color.parseColor("#662d2c54"));
        timer.setInCircleColor(Color.TRANSPARENT);
        timer.setProgressColor(Color.WHITE);
//        timer.setProgressColor(Color.parseColor("#FFFF4149"));
        timer.start();
    }

    private CircleTextProgressbar.OnCountdownProgressListener progressListener = new CircleTextProgressbar.OnCountdownProgressListener() {
        @Override
        public void onProgress(int what, int progress) {
            // 比如在首页，这里可以判断进度，进度到了100或者0的时候，你可以做跳过操作。
            if (progress == 100) {
                timer.stop();
                nextActivity(LoginActivity.class);
                finish();
            }
            timer.setText((100-progress)*3/100+1+"s");

        }
    };

    @OnClick({R.id.timer})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.timer:
                timer.stop();
                nextActivity(LoginActivity.class);
                finish();
                break;

        }
    }

}
