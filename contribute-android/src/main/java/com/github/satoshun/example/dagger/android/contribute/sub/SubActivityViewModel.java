package com.github.satoshun.example.dagger.android.contribute.sub;

import android.databinding.Observable;
import android.databinding.ObservableField;
import android.text.TextUtils;

import javax.inject.Inject;

public class SubActivityViewModel {

  public final ObservableField<String> left = new ObservableField<>("0");
  public final ObservableField<String> right = new ObservableField<>("0");
  public final ObservableField<String> result = new ObservableField<>("0");

  private final SubActivityContract.Presenter presenter;

  @Inject SubActivityViewModel(SubActivityContract.Presenter presenter) {
    this.presenter = presenter;

    left.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
      @Override public void onPropertyChanged(Observable sender, int propertyId) {
        changeValue();
      }
    });
    right.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
      @Override public void onPropertyChanged(Observable sender, int propertyId) {
        changeValue();
      }
    });
  }

  private void changeValue() {
    if (TextUtils.isEmpty(left.get()) || TextUtils.isEmpty(right.get())) {
      result.set("-");
      return;
    }
    result.set(
        String.valueOf(Integer.parseInt(left.get()) + Integer.parseInt(right.get()))
    );
  }
}
