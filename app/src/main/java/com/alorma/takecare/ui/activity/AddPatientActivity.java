package com.alorma.takecare.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;
import com.alorma.takecare.R;
import com.alorma.takecare.ui.activity.base.BaseActivity;

public class AddPatientActivity extends BaseActivity {
  public static Intent createIntent(Context context) {
    return new Intent(context, AddPatientActivity.class);
  }

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_patinent);

    ButterKnife.findById(this, R.id.addPatient).setOnClickListener(v -> finish());
  }
}
