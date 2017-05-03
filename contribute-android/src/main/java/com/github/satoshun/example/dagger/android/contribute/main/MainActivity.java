package com.github.satoshun.example.dagger.android.contribute.main;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.github.satoshun.example.dagger.android.contribute.R;
import com.github.satoshun.example.dagger.android.contribute.databinding.MainActBinding;
import com.github.satoshun.example.dagger.android.contribute.sub.SubActivity;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity implements MainContract.View {

  @Inject MainPresenter presenter;

  @Inject String message; // from App Component
  @Inject int tax; // from Activity Component

  private MainActBinding binding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = DataBindingUtil.setContentView(this, R.layout.main_act);
    setSupportActionBar(binding.toolbar);

    binding.fab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        startActivity(new Intent(MainActivity.this, SubActivity.class));
      }
    });
    binding.content.edit.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        presenter.doTask();
      }
    });

    if (getSupportFragmentManager().findFragmentByTag("retain") == null) {
      getSupportFragmentManager().beginTransaction()
          .add(new MainFragment(), "retain")
          .commit();
    }
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override public void addTask(String task) {
    TextView view = new TextView(this);
    view.setText(task);
    binding.content.container.addView(view);
  }

  @Override public void showMessage(String message) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
  }

  @Override public void showErrorMessage(String errorMessage) {
    Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
  }
}
