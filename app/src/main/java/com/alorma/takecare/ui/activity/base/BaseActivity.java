package com.alorma.takecare.ui.activity.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import com.alorma.takecare.AppPreferences;

public class BaseActivity extends AppCompatActivity {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    configureTheme();
    super.onCreate(savedInstanceState);
  }

  private void configureTheme() {
    switch (getThemeType()) {
      case AppPreferences.Ui.Theme.DARK:
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        break;
      case AppPreferences.Ui.Theme.AUTO:
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO);
        break;
      default:
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        break;
    }
  }

  @AppPreferences.Ui.ThemeType
  private int getThemeType() {
    return AppPreferences.Ui.getThemeType(this, AppPreferences.Ui.Theme.AUTO);
  }
}
