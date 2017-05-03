package com.github.satoshun.example.dagger.android;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import javax.inject.Inject;

import dagger.Binds;
import dagger.Provides;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.android.support.DaggerAppCompatActivity;
import dagger.multibindings.IntoMap;

public class MainActivity extends DaggerAppCompatActivity {

  @dagger.Subcomponent(
      modules = {MainFragment.Module.class, BuildModule.class}
  ) interface Component extends AndroidInjector<MainActivity> {

    @dagger.Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity> {
    }
  }

  @dagger.Module
  static class BuildModule {
    @Provides
    int provideTax() {
      return 10;
    }
  }

  @dagger.Module(subcomponents = Component.class)
  abstract static class Module {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bind(Component.Builder builder);
  }

  @Inject String message;
  @Inject int tax;

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
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
            .setAction("Action", null).show();
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
