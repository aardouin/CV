package com.aardouin.cv.utils;

import android.content.Context;
import android.graphics.Color;

/**
 * Created by alexisardouin on 02/02/14.
 */
public class Utils {
    public static int dpToPx(Context context, int dp) {
        float density = context.getResources().getDisplayMetrics().density;
        return Math.round((float) dp * density);
    }

    public static int darkenColor(int color){
        float[] hsv = new float[3];
        Color.colorToHSV(color, hsv);
        hsv[2] -= hsv[2]*0.3;
        return Color.HSVToColor(hsv);
    }
}
