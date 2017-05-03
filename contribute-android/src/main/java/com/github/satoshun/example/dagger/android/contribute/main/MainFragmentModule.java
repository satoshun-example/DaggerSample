package com.github.satoshun.example.dagger.android.contribute.main;

import dagger.Provides;

@dagger.Module
public class MainFragmentModule {
  @Provides float provideWeight() {
    return 60;
  }
}
