package com.github.satoshun.sample.dagger;

import android.app.Application;
import android.content.Context;

import javax.inject.Inject;

public class SampleApplication extends Application {

  private AppComponent component;

  @Inject MainActivityComponent.Builder builder;

  public void onCreate() {
    super.onCreate();

    component = DaggerAppComponent.builder()
            .build();
    component.inject(this);
  }


  public static MainActivityComponent.Builder getBuilder(Context context) {
    return ((SampleApplication) context.getApplicationContext()).builder;
  }
}
