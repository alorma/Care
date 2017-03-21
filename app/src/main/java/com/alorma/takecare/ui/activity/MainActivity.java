package com.alorma.takecare.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import butterknife.ButterKnife;
import com.alorma.takecare.R;
import com.alorma.takecare.ui.activity.base.BaseActivity;

public class MainActivity extends BaseActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ButterKnife.findById(this, R.id.fabAdd).setOnClickListener(v -> addPatient());
  }

  private void addPatient() {
    Intent intent = AddPatientActivity.createIntent(this);
    startActivity(intent);
  }
}
