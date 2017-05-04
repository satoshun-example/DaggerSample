package com.github.satoshun.example.dagger.android.contribute.sub;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.github.satoshun.example.dagger.android.contribute.R;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class SubActivity extends DaggerAppCompatActivity {

  @Inject String message; // from App Component
  @Inject int tax; // from Activity Component

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.sub_activity);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
  }
}
