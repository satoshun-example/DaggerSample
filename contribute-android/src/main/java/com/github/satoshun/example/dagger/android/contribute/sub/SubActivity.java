package com.github.satoshun.example.dagger.android.contribute.sub;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.github.satoshun.example.dagger.android.contribute.R;

import javax.inject.Inject;

import dagger.Provides;
import dagger.android.support.DaggerAppCompatActivity;

public class SubActivity extends DaggerAppCompatActivity {

  @dagger.Module
  public static class Module {
    @Provides int provideTax() {
      return 100;
    }
  }

  @Inject String message; // from App Component
  @Inject int tax; // from Activity Component

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.sub_activity);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
            .setAction("Action", null).show();
      }
    });
  }
}
