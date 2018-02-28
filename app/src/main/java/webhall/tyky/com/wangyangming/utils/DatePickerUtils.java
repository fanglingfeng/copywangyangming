package webhall.tyky.com.wangyangming.utils;

import android.app.DatePickerDialog;
import android.content.Context;

import java.util.Calendar;

/**
 * Created by TYKY001 on 2017/9/8.
 */

public class DatePickerUtils {
    public static void selectDate(Context context,DatePickerDialog.OnDateSetListener clickListener) {
        Calendar calendar =Calendar.getInstance();
        int StartTime_Year = calendar.get(Calendar.YEAR);
        int StartTime_Month = calendar.get(Calendar.MONTH);
        int StartTime_Day = calendar.get(Calendar.DAY_OF_MONTH);
        new DatePickerDialog(context, clickListener, StartTime_Year, StartTime_Month, StartTime_Day).show();
    }
}
