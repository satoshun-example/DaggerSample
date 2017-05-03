package com.github.satoshun.example.dagger.android.contribute.main;

import com.github.satoshun.example.dagger.android.contribute.ActivityScope;
import com.github.satoshun.example.dagger.android.contribute.FragmentScope;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@dagger.Module
public class MainActivityModule {
  @Module
  public abstract class BindModule {
    @FragmentScope
    @ContributesAndroidInjector(modules = {MainFragmentModule.class})
    abstract MainFragment mainFragment();
  }

  @ActivityScope @Provides MainContract.View provideMainContractView(MainActivity activity) {
    return activity;
  }

  @ActivityScope @Provides int provideTax() {
    return 10;
  }
}
