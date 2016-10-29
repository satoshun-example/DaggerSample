package com.github.satoshun.sample.dagger;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import java.util.Map;

import javax.inject.Inject;

public class SampleApplication extends Application {

  @Inject Map<Class<? extends Activity>, BaseBuilder> builders;

  public void onCreate() {
    super.onCreate();

    DaggerAppComponent.builder()
            .build().inject(this);
  }

  @SuppressWarnings("unchecked")
  public static <T extends BaseBuilder> T activityBuilder(Context context, Class<? extends Activity> activityClass) {
    return (T) ((SampleApplication) context.getApplicationContext()).builders.get(activityClass);
  }
}
