package com.github.satoshun.example.dagger.android;

import dagger.Module;
import dagger.Provides;

@Module class BuildModule {
  @Provides
  static String provideMessage() {
    return "Hello World!!";
  }
}
