package com.github.satoshun.example.dagger.android.contribute.sub;

import com.github.satoshun.example.dagger.android.contribute.FragmentScope;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@dagger.Module
public class SubActivityModule {
  @Module
  public abstract class BindModule {
    @FragmentScope
    @ContributesAndroidInjector(modules = {SubActivityFragmentModule.class})
    abstract SubActivityFragment subFragment();
  }

  @Provides int provideTax() {
    return 100;
  }
}
