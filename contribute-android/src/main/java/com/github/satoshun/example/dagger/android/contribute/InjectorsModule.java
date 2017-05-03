package com.github.satoshun.example.dagger.android.contribute;

import com.github.satoshun.example.dagger.android.contribute.main.MainActivity;
import com.github.satoshun.example.dagger.android.contribute.main.MainActivityModule;
import com.github.satoshun.example.dagger.android.contribute.sub.SubActivity;
import com.github.satoshun.example.dagger.android.contribute.sub.SubActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class InjectorsModule {
  @ActivityScope
  @ContributesAndroidInjector(modules = {MainActivityModule.class, MainActivityModule.BindModule.class})
  abstract MainActivity mainActivity();

  @ActivityScope
  @ContributesAndroidInjector(modules = {SubActivityModule.class, SubActivityModule.BindModule.class})
  abstract SubActivity subActivity();
}
