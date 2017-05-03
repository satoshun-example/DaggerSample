package com.github.satoshun.example.dagger.android.contribute.main;

import java.util.Random;

import javax.inject.Inject;

public class MainPresenter implements MainContract.Presenter {

  private final MainContract.View view;

  @Inject MainPresenter(MainContract.View view) {
    this.view = view;
  }

  @Override public void doTask() {
    if (new Random().nextInt(2) == 0) {
      view.addTask("TASK");
      view.showMessage("SUCCESS");
    } else {
      view.showErrorMessage("ERROR");
    }
  }
}
