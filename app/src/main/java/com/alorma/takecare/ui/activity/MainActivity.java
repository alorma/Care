package com.alorma.takecare.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import butterknife.ButterKnife;
import com.alorma.takecare.AppPreferences;
import com.alorma.takecare.R;
import com.alorma.takecare.ui.activity.base.BaseActivity;

public class MainActivity extends BaseActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ButterKnife.findById(this, R.id.fabAdd).setOnClickListener(v -> addPatient());
    ButterKnife.findById(this, R.id.themeLight).setOnClickListener(v -> setAppThemeMode(AppPreferences.Ui.ThemeMode.LIGHT));
    ButterKnife.findById(this, R.id.themeDark).setOnClickListener(v -> setAppThemeMode(AppPreferences.Ui.ThemeMode.DARK));
    ButterKnife.findById(this, R.id.themeAuto).setOnClickListener(v -> setAppThemeMode(AppPreferences.Ui.ThemeMode.AUTO));

    ButterKnife.findById(this, R.id.themeRed).setOnClickListener(v -> setAppThemeStyle(AppPreferences.Ui.ThemeColor.RED));
    ButterKnife.findById(this, R.id.themeGreen).setOnClickListener(v -> setAppThemeStyle(AppPreferences.Ui.ThemeColor.GREEN));
    ButterKnife.findById(this, R.id.themeBlue).setOnClickListener(v -> setAppThemeStyle(AppPreferences.Ui.ThemeColor.BLUE));
  }

  private void setAppThemeMode(@AppPreferences.Ui.ThemeType int themeType) {
    AppPreferences.Ui.setThemeType(this, themeType);
    recreate();
  }

  private void setAppThemeStyle(@AppPreferences.Ui.ThemeStyle int themeStyle) {
    AppPreferences.Ui.setThemeStyle(this, themeStyle);
    recreate();
  }

  private void addPatient() {
    Intent intent = AddPatientActivity.createIntent(this);
    startActivity(intent);
  }
}
