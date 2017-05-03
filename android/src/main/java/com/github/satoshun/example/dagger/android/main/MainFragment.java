package com.github.satoshun.example.dagger.android.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.github.satoshun.example.dagger.android.FragmentScope;

import javax.inject.Inject;

import dagger.Binds;
import dagger.Provides;
import dagger.android.AndroidInjector;
import dagger.android.support.DaggerFragment;
import dagger.multibindings.IntoMap;

public class MainFragment extends DaggerFragment {

  @FragmentScope
  @dagger.Subcomponent(modules = BuildModule.class)
  public interface Component extends AndroidInjector<MainFragment> {
    @dagger.Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainFragment> {
    }
  }

  @dagger.Module
  public static class BuildModule {
    @Provides
    float provideWeight() {
      return 60;
    }
  }

  @dagger.Module(subcomponents = MainFragment.Component.class)
  public abstract static class Module {

    @Binds
    @IntoMap
    @dagger.android.support.FragmentKey(MainFragment.class)
    abstract AndroidInjector.Factory<? extends Fragment> bind(MainFragment.Component.Builder builder);
  }

  @Inject String message;
  @Inject int tax;
  @Inject float weight;

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setRetainInstance(true);
  }
}
