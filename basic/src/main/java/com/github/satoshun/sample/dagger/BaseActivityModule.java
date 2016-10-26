package com.github.satoshun.sample.dagger;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class BaseActivityModule<A extends Activity> {
  private final A activity;

  public BaseActivityModule(A activity) {
    this.activity = activity;
  }

  @Provides @ActivityScope public A provideActivity() {
    return activity;
  }
}
