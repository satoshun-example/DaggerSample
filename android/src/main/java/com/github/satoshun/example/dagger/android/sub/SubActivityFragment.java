package com.github.satoshun.example.dagger.android.sub;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.satoshun.example.dagger.android.FragmentScope;
import com.github.satoshun.example.dagger.android.R;

import javax.inject.Inject;

import dagger.Binds;
import dagger.Provides;
import dagger.android.AndroidInjector;
import dagger.android.support.DaggerFragment;
import dagger.multibindings.IntoMap;

public class SubActivityFragment extends DaggerFragment {

  @FragmentScope
  @dagger.Subcomponent(modules = SubActivityFragment.BuildModule.class)
  public interface Component extends AndroidInjector<SubActivityFragment> {
    @dagger.Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<SubActivityFragment> {
    }
  }

  @dagger.Module
  public static class BuildModule {
    @Provides
    float provideWeight() {
      return 100;
    }
  }

  @dagger.Module(subcomponents = SubActivityFragment.Component.class)
  public abstract static class Module {

    @Binds
    @IntoMap
    @dagger.android.support.FragmentKey(SubActivityFragment.class)
    abstract AndroidInjector.Factory<? extends Fragment> bind(SubActivityFragment.Component.Builder builder);
  }

  @Inject float weight;

  public SubActivityFragment() {
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_sub, container, false);
  }
}
