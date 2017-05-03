package com.github.satoshun.example.dagger.android.contribute.sub;

import dagger.Provides;

@dagger.Module
public class SubActivityFragmentModule {
  @Provides float provideWeight() {
    return 200;
  }
}
