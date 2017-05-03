package com.github.satoshun.example.dagger.android.contribute.main;

import android.os.Bundle;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public class MainFragment extends DaggerFragment {

  @Inject String message; // from App Component
  @Inject int tax; // from Activity Component
  @Inject float weight; // from Fragment Component

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setRetainInstance(true);
  }
}
