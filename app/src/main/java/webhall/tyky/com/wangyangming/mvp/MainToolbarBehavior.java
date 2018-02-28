package webhall.tyky.com.wangyangming.mvp;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.dino.changeskin.utils.PrefUtils;
import com.socks.library.KLog;

import webhall.tyky.com.wangyangming.R;


/**
 * Created by dengyibin on 2017/7/19.
 *
 * @description
 */

public class MainToolbarBehavior extends CoordinatorLayout.Behavior<MainToolbar> {
    private PrefUtils prefUtils;

    private Runnable mScrollChecker;
    private static final int DELAY_MILLIS = 100;
    private int mPreviousPosition;

    /**
     * Default constructor for inflating Behaviors from layout. The Behavior will have
     * the opportunity to parse specially defined layout parameters. These parameters will
     * appear on the child view tag.
     */
    public MainToolbarBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private View statusBarView;

    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, MainToolbar child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        int alpha = getNestedScrollY(target);
//        KLog.d("alpha: " + alpha);
        changeAlpha(child, alpha);
    }

    private void changeAlpha(MainToolbar child, int alpha) {
        if (alpha > 255) {
            alpha = 255;
        }
        if (alpha < 0) {
            alpha = 0;
        }
        if (alpha > 0 && alpha < 255) {
//            child.findViewById(R.id.appbar).setBackgroundColor(child.getResources().getColor(R.color.transparent));
        }
        child.findViewById(R.id.toolbar).getBackground().setAlpha(alpha);
        prefUtils = new PrefUtils(child.getContext());
        if (statusBarView == null) {
            //android系统级的资源id得这么拿,不然拿不到
            int identifier = child.getResources().getIdentifier("statusBarBackground", "id", "android");
            statusBarView = child.getRootView().findViewById(identifier);
        }
        if (statusBarView != null) {
//            if (alpha > 0 && alpha < 255) {
//                if ("red".equals(prefUtils.getSuffix())) {
//                    statusBarView.setBackgroundColor(child.getResources().getColor(R.color.colorPrimary_red));
//                    statusBarView.getBackground().setAlpha(0);
//
//                } else if ("yellow".equals(prefUtils.getSuffix())) {
//                    statusBarView.setBackgroundColor(child.getResources().getColor(R.color.colorPrimary_yellow));
//                    statusBarView.getBackground().setAlpha(0);
//
//                } else {
//                    statusBarView.setBackgroundColor(child.getResources().getColor(R.color.colorPrimary));
//                    statusBarView.getBackground().setAlpha(0);
//
//                }
//            } else {

//
//            if ("red".equals(prefUtils.getSuffix())) {
//                statusBarView.setBackgroundColor(child.getResources().getColor(R.color.colorPrimary_red));
//            } else if ("yellow".equals(prefUtils.getSuffix())) {
//                statusBarView.setBackgroundColor(child.getResources().getColor(R.color.colorPrimary_yellow));
//
//            } else {
//                statusBarView.setBackgroundColor(child.getResources().getColor(R.color.colorPrimary));
//
//            }
//            statusBarView.getBackground().setAlpha(alpha);

//            }
        }
    }

    @Override
    public boolean onNestedFling(CoordinatorLayout coordinatorLayout, MainToolbar child, View target, float velocityX, float velocityY, boolean consumed) {


        mScrollChecker = new Runnable() {
            @Override
            public void run() {
                int position = getNestedScrollY(target);
                KLog.d("position: " + position);
                changeAlpha(child, position);
                if (mPreviousPosition - position != 0) {
                    mPreviousPosition = getNestedScrollY(target);
                    target.postDelayed(mScrollChecker, DELAY_MILLIS);
                }
            }
        };

        target.post(mScrollChecker);
        return super.onNestedFling(coordinatorLayout, child, target, velocityX, velocityY, consumed);
    }


    private int getNestedScrollY(View view) {

        if ((view instanceof ViewGroup) && view.getScrollY() == 0) {
            return getNestedScrollY(((ViewGroup) view).getChildAt(0));
        }
        if (view != null) {
            return view.getScrollY();
        }
        return 0;
    }


    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, MainToolbar child, View directTargetChild, View target, int nestedScrollAxes) {
        return (nestedScrollAxes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0;
    }


}