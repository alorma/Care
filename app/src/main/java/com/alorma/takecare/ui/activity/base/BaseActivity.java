package com.alorma.takecare.ui.activity.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import com.alorma.takecare.AppPreferences;
import com.alorma.takecare.R;

public class BaseActivity extends AppCompatActivity {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    configureTheme();
    super.onCreate(savedInstanceState);
  }

  private void configureTheme() {
    configureThemeStyle();
    configureThemeMode();
  }

  private void configureThemeStyle() {
    switch (getThemeStyle()) {
      case AppPreferences.Ui.ThemeColor.BLUE:
        setTheme(R.style.AppTheme_Blue);
        break;
      case AppPreferences.Ui.ThemeColor.RED:
        setTheme(R.style.AppTheme_Red);
        break;
      case AppPreferences.Ui.ThemeColor.GREEN:
        setTheme(R.style.AppTheme_Green);
        break;
      default:
        setTheme(R.style.AppTheme_Blue);
        break;
    }
  }

  @AppPreferences.Ui.ThemeStyle
  private int getThemeStyle() {
    return AppPreferences.Ui.getThemeStyle(this, AppPreferences.Ui.ThemeColor.BLUE);
  }

  private void configureThemeMode() {
    switch (getThemeType()) {
      case AppPreferences.Ui.ThemeMode.DARK:
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        break;
      case AppPreferences.Ui.ThemeMode.AUTO:
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO);
        break;
      default:
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        break;
    }
  }

  @AppPreferences.Ui.ThemeType
  private int getThemeType() {
    return AppPreferences.Ui.getThemeType(this, AppPreferences.Ui.ThemeMode.AUTO);
  }
}
