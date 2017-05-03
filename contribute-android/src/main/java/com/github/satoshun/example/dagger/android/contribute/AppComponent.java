package com.github.satoshun.example.dagger.android.contribute;

import javax.inject.Singleton;

import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@dagger.Component(
    modules = {
        AndroidSupportInjectionModule.class,
        InjectorsModule.class,
        BuildModule.class
    }
)
public interface AppComponent extends AndroidInjector<App> {
  @dagger.Component.Builder
  abstract class Builder extends AndroidInjector.Builder<App> {
  }
}
