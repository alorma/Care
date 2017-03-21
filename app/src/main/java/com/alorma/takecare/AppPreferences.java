package com.alorma.takecare;

import android.content.Context;
import android.preference.PreferenceManager;
import android.support.annotation.IntDef;
import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.SOURCE;

public class AppPreferences {

  public static class Ui {
    private static final String THEME_TYPE = "THEME_TYPE";

    public static class Theme {
      public static final int LIGHT = 0;
      public static final int DARK = 1;
      public static final int AUTO = 2;
    }

    @Retention(SOURCE)
    @IntDef({ Theme.LIGHT, Theme.DARK, Theme.AUTO })
    public @interface ThemeType {
    }

    @AppPreferences.Ui.ThemeType
    public static int getThemeType(Context context, @ThemeType int defaultThemeType) {
      int theme = PreferenceManager.getDefaultSharedPreferences(context).getInt(THEME_TYPE, defaultThemeType);
      if (theme == Theme.LIGHT) {
        return Theme.LIGHT;
      } else if (theme == Theme.DARK) {
        return Theme.DARK;
      } else if (theme == Theme.AUTO) {
        return Theme.AUTO;
      }
      return Theme.LIGHT;
    }
  }
}
