package com.github.satoshun.sample.dagger;

import com.github.satoshun.sample.dagger.top.MainActivity;

import dagger.MembersInjector;
import dagger.Module;
import dagger.Provides;
import dagger.Subcomponent;
import io.reactivex.disposables.CompositeDisposable;

@ActivityScope
@Subcomponent(modules = MainActivityComponent.MainActivityModule.class)
public interface MainActivityComponent extends MembersInjector<MainActivity> {

  @Subcomponent.Builder
  interface Builder extends BaseBuilder<MainActivityComponent> {
    Builder activityModule(MainActivityModule module);
  }

  @Module
  class MainActivityModule extends BaseActivityModule<MainActivity> {

    public MainActivityModule(MainActivity activity) {
      super(activity);
    }

    @Provides @ActivityScope public static CompositeDisposable provideCompositeDisposable() {
      return new CompositeDisposable();
    }
  }
}
