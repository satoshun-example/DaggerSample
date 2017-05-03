package com.github.satoshun.example.dagger.android;

import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import dagger.android.support.DaggerApplication;

public class App extends DaggerApplication {

  @dagger.Component(
      modules = {
          AndroidSupportInjectionModule.class,
          MainActivity.Module.class,
          BuildModule.class
      }
  ) interface Component extends AndroidInjector<App> {
    @dagger.Component.Builder
    abstract class Builder extends AndroidInjector.Builder<App> {
    }
  }

  @Override public void onCreate() {
    super.onCreate();
  }

  @Override protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
    return DaggerApp_Component.builder().create(this);
  }
}
