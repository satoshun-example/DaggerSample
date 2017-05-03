package com.github.satoshun.example.dagger.android.contribute.sub;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.satoshun.example.dagger.android.contribute.R;

import javax.inject.Inject;

import dagger.Provides;
import dagger.android.support.DaggerFragment;

public class SubActivityFragment extends DaggerFragment {

  @dagger.Module
  public static class Module {
    @Provides float provideWeight() {
      return 200;
    }
  }

  @Inject String message; // from App Component
  @Inject int tax; // from Activity Component
  @Inject float weight; // from Fragment Component

  public SubActivityFragment() {
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_sub, container, false);
  }
}
