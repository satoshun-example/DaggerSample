package com.github.satoshun.example.dagger.android.contribute.main;

import com.github.satoshun.example.dagger.android.contribute.ActivityScope;

import dagger.Provides;

@dagger.Module
public class MainActivityModule {

  @ActivityScope @Provides MainContract.View provideMainContractView(MainActivity activity) {
    return activity;
  }

  @ActivityScope @Provides int provideTax() {
    return 10;
  }
}
