package com.aardouin.cv.utils;

import android.content.Context;

/**
 * Created by alexisardouin on 02/02/14.
 */
public class Utils {
    public static int dpToPx(Context context ,int dp)
    {
        float density = context.getResources().getDisplayMetrics().density;
        return Math.round((float)dp * density);
    }
}
