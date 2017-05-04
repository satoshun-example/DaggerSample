package com.github.satoshun.example.dagger.android.contribute.sub;

import com.github.satoshun.example.dagger.android.contribute.FragmentScope;

import dagger.Provides;

@dagger.Module
public class SubActivityFragmentModule {

  @FragmentScope @Provides
  SubActivityContract.View provideSubActivityContractView(SubActivityFragment fragment) {
    return fragment;
  }

  @FragmentScope @Provides
  SubActivityContract.Presenter provideSubActivityContractPresenter(SubActivityPresenter presenter) {
    return presenter;
  }

  @Provides float provideWeight() {
    return 200;
  }
}
