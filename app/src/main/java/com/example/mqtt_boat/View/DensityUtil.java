package com.example.mqtt_boat.View;
import android.content.Context;

/**
 * 用于px和  dp，sp的转换工具
 */
public class DensityUtil {
        /**
         * dp转px
         * @param dip       dp
         * @param context   上下文
         * @return
         */
        public static int dip2px(float dip, Context context) {
            float density = context.getResources().getDisplayMetrics().density;
            int px = (int) (dip * density + 0.5f);// 4.9->4, 4.1->4, 四舍五入
            return px;
        }

        /**
         * px转dp
         * @param px        px
         * @param context   上下文
         * @return
         */
        public static float px2dip(int px, Context context) {
            float density = context.getResources().getDisplayMetrics().density;
            float dp = px / density;
            return dp;
        }



}