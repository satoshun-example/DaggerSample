package com.github.satoshun.example.dagger.android.sub;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.github.satoshun.example.dagger.android.ActivityScope;
import com.github.satoshun.example.dagger.android.R;

import javax.inject.Inject;

import dagger.Binds;
import dagger.Provides;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.android.support.DaggerAppCompatActivity;
import dagger.multibindings.IntoMap;

public class SubActivity extends DaggerAppCompatActivity {

  @ActivityScope
  @dagger.Subcomponent(
      modules = {SubActivityFragment.Module.class, SubActivity.BuildModule.class}
  ) public interface Component extends AndroidInjector<SubActivity> {
    @dagger.Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<SubActivity> {
    }
  }

  @dagger.Module
  public static class BuildModule {
    @Provides
    int provideTax() {
      return 100;
    }
  }

  @dagger.Module(subcomponents = SubActivity.Component.class)
  public abstract static class Module {

    @Binds
    @IntoMap
    @ActivityKey(SubActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bind(SubActivity.Component.Builder builder);
  }

  @Inject String message;
  @Inject int tax;

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
