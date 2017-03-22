package com.alorma.takecare;

import android.content.Context;
import android.preference.PreferenceManager;
import android.support.annotation.IntDef;
import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.SOURCE;

public class AppPreferences {

  public static class Ui {
    private static final String THEME_TYPE = "THEME_TYPE";
    private static final String THEME_STYLE = "THEME_STYLE";

    public static class ThemeMode {
      public static final int LIGHT = 0;
      public static final int DARK = 1;
      public static final int AUTO = 2;
    }

    @Retention(SOURCE)
    @IntDef({ ThemeMode.LIGHT, ThemeMode.DARK, ThemeMode.AUTO })
    public @interface ThemeType {
    }

    @AppPreferences.Ui.ThemeType
    public static int getThemeType(Context context, @ThemeType int defaultThemeType) {
      int theme = PreferenceManager.getDefaultSharedPreferences(context).getInt(THEME_TYPE, defaultThemeType);
      if (theme == ThemeMode.LIGHT) {
        return ThemeMode.LIGHT;
      } else if (theme == ThemeMode.DARK) {
        return ThemeMode.DARK;
      } else if (theme == ThemeMode.AUTO) {
        return ThemeMode.AUTO;
      }
      return ThemeMode.LIGHT;
    }

    public static void setThemeType(Context context, @ThemeType int themeType) {
      PreferenceManager.getDefaultSharedPreferences(context).edit().putInt(THEME_TYPE, themeType).apply();
    }

    public static class ThemeColor {
      public static final int RED = 0;
      public static final int GREEN = 1;
      public static final int BLUE = 2;
    }

    @Retention(SOURCE)
    @IntDef({ ThemeColor.RED, ThemeColor.GREEN, ThemeColor.BLUE })
    public @interface ThemeStyle {
    }

    @ThemeStyle
    public static int getThemeStyle(Context context, @ThemeStyle int themeStyle) {
      int theme = PreferenceManager.getDefaultSharedPreferences(context).getInt(THEME_STYLE, themeStyle);
      if (theme == ThemeColor.RED) {
        return ThemeColor.RED;
      } else if (theme == ThemeColor.GREEN) {
        return ThemeColor.GREEN;
      } else if (theme == ThemeColor.BLUE) {
        return ThemeColor.BLUE;
      }
      return ThemeColor.RED;
    }

    public static void setThemeStyle(Context context, int themeStyle) {
      PreferenceManager.getDefaultSharedPreferences(context).edit().putInt(THEME_STYLE, themeStyle).apply();
    }
  }
}
