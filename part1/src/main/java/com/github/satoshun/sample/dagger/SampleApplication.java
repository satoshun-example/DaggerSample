package com.github.satoshun.sample.dagger;

import android.app.Application;
import android.content.Context;

import javax.inject.Inject;

public class SampleApplication extends Application {

  @Inject MainActivityComponent.Builder mainBuilder;
  @Inject SubActivityComponent.Builder subBuilder;

  public void onCreate() {
    super.onCreate();

    DaggerAppComponent.builder()
            .build().inject(this);
  }

  public static MainActivityComponent.Builder getMainActivityBuilder(Context context) {
    return ((SampleApplication) context.getApplicationContext()).mainBuilder;
  }

  public static SubActivityComponent.Builder getSubActivityBuilder(Context context) {
    return ((SampleApplication) context.getApplicationContext()).subBuilder;
  }
}
