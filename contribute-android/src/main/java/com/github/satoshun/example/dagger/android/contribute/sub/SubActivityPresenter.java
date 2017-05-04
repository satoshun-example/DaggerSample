package com.github.satoshun.example.dagger.android.contribute.sub;

import javax.inject.Inject;

public class SubActivityPresenter implements SubActivityContract.Presenter {
  private final SubActivityContract.View view;

  @Inject
  public SubActivityPresenter(SubActivityContract.View view) {
    this.view = view;
  }
}
