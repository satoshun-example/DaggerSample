package com.github.satoshun.sample.dagger;

import com.github.satoshun.sample.dagger.sub.SubActivity;

import dagger.MembersInjector;
import dagger.Module;
import dagger.Provides;
import dagger.Subcomponent;
import io.reactivex.disposables.CompositeDisposable;

@ActivityScope
@Subcomponent(modules = SubActivityComponent.SubActivityModule.class)
public interface SubActivityComponent extends MembersInjector<SubActivity> {

  @Subcomponent.Builder interface Builder extends BaseBuilder<SubActivityComponent> {
    Builder activityModule(SubActivityModule module);
  }

  @Module class SubActivityModule extends BaseActivityModule<SubActivity> {

    public SubActivityModule(SubActivity activity) {
      super(activity);
    }

    @Provides
    @ActivityScope
    public static CompositeDisposable provideCompositeDisposable() {
      return new CompositeDisposable();
    }
  }
}
