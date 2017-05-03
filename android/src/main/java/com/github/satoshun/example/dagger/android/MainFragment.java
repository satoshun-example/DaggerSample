package com.github.satoshun.example.dagger.android;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import javax.inject.Inject;

import dagger.Binds;
import dagger.Provides;
import dagger.android.AndroidInjector;
import dagger.android.support.DaggerFragment;
import dagger.multibindings.IntoMap;

public class MainFragment extends DaggerFragment {

  @dagger.Subcomponent(modules = BuildModule.class)
  interface Component extends AndroidInjector<MainFragment> {
    @dagger.Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainFragment> {
    }
  }

  @dagger.Module
  static class BuildModule {
    @Provides
    float provideWeight() {
      return 60;
    }
  }

  @dagger.Module(subcomponents = MainFragment.Component.class)
  abstract static class Module {

    @Binds
    @IntoMap
    @dagger.android.support.FragmentKey(MainFragment.class)
    abstract AndroidInjector.Factory<? extends Fragment> bind(MainFragment.Component.Builder builder);
  }

  @Inject String message;
  @Inject int tax;
  @Inject float weight;

  @Override public void onAttach(Context context) {
    super.onAttach(context);
  }

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setRetainInstance(true);
  }
}
