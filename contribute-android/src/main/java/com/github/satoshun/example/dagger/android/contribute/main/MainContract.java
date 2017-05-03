package com.github.satoshun.example.dagger.android.contribute.main;

public interface MainContract {

  interface View {
    void addTask(String task);

    void showMessage(String message);

    void showErrorMessage(String errorMessage);
  }

  interface Presenter {
    void doTask();
  }
}
