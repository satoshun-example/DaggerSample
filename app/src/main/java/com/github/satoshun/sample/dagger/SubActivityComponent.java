package com.github.satoshun.sample.dagger;

import android.app.Activity;

import com.github.satoshun.sample.dagger.sub.SubActivity;

import dagger.Module;
import dagger.Provides;
import dagger.Subcomponent;
import io.reactivex.disposables.CompositeDisposable;

@ActivityScope
@Subcomponent(modules = SubActivityComponent.SubActivityModule.class)
public interface SubActivityComponent {

  @Subcomponent.Builder
  interface Builder {
    Builder activityModule(SubActivityModule module);

    SubActivityComponent build();
  }

  SubActivity inject(SubActivity activity);

  @Module
  class SubActivityModule {
    private final Activity activity;

    public SubActivityModule(Activity activity) {
      this.activity = activity;
    }

    @Provides @ActivityScope public Activity provideActivity() {
      return activity;
    }

    @Provides @ActivityScope public static CompositeDisposable provideCompositeDisposable() {
      return new CompositeDisposable();
    }
  }
}
