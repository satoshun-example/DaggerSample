package com.github.satoshun.example.dagger.android.contribute;

import com.github.satoshun.example.dagger.android.contribute.main.MainActivity;
import com.github.satoshun.example.dagger.android.contribute.main.MainFragment;
import com.github.satoshun.example.dagger.android.contribute.sub.SubActivity;
import com.github.satoshun.example.dagger.android.contribute.sub.SubActivityFragment;

import javax.inject.Singleton;

import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.ContributesAndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import dagger.android.support.DaggerApplication;

public class App extends DaggerApplication {

  @Singleton
  @dagger.Component(
      modules = {
          AndroidSupportInjectionModule.class,
          InjectorsModule.class,
          BuildModule.class
      }
  ) interface Component extends AndroidInjector<App> {
    @dagger.Component.Builder
    abstract class Builder extends AndroidInjector.Builder<App> {
    }
  }

  @Module
  abstract class InjectorsModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = {MainActivity.Module.class, MainActivityBindModule.class})
    abstract MainActivity mainActivity();

    @ActivityScope
    @ContributesAndroidInjector(modules = {SubActivity.Module.class, SubActivityBindModule.class})
    abstract SubActivity subActivity();
  }

  @Module
  abstract class MainActivityBindModule {
    @FragmentScope
    @ContributesAndroidInjector(modules = {MainFragment.Module.class})
    abstract MainFragment mainFragment();
  }

  @Module
  abstract class SubActivityBindModule {
    @FragmentScope
    @ContributesAndroidInjector(modules = {SubActivityFragment.Module.class})
    abstract SubActivityFragment subFragment();
  }

  @Override public void onCreate() {
    super.onCreate();
  }

  @Override protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
    return DaggerApp_Component.builder().create(this);
  }
}
