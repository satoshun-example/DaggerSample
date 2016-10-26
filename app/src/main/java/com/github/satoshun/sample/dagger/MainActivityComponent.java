package com.github.satoshun.sample.dagger;

import android.app.Activity;

import com.github.satoshun.sample.dagger.top.MainActivity;

import dagger.Module;
import dagger.Provides;
import dagger.Subcomponent;
import io.reactivex.disposables.CompositeDisposable;

@ActivityScope
@Subcomponent(modules = MainActivityComponent.MainActivityModule.class)
public interface MainActivityComponent {

  @Subcomponent.Builder
  interface Builder {
    Builder activityModule(MainActivityModule module);

    MainActivityComponent build();
  }

  MainActivity inject(MainActivity activity);

  @Module
  class MainActivityModule {
    private final Activity activity;

    public MainActivityModule(Activity activity) {
      this.activity = activity;
    }

    @Provides @ActivityScope Activity provideActivity() {
      return activity;
    }

    @Provides @ActivityScope CompositeDisposable provideCompositeDisposable() {
      return new CompositeDisposable();
    }
  }
}
