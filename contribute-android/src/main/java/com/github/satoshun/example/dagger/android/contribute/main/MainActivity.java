package com.github.satoshun.example.dagger.android.contribute.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.github.satoshun.example.dagger.android.contribute.R;
import com.github.satoshun.example.dagger.android.contribute.sub.SubActivity;

import javax.inject.Inject;

import dagger.Provides;
import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity {

  @dagger.Module
  public static class Module {
    @Provides int provideTax() {
      return 10;
    }
  }

  @Inject String message; // from App Component
  @Inject int tax; // from Activity Component

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main_act);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        startActivity(new Intent(MainActivity.this, SubActivity.class));
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

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();

    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }
}
