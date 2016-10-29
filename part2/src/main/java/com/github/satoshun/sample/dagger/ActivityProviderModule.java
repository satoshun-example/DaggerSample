package com.github.satoshun.sample.dagger;

import com.github.satoshun.sample.dagger.sub.SubActivity;
import com.github.satoshun.sample.dagger.top.MainActivity;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {
        MainActivityComponent.class,
        SubActivityComponent.class
})
public abstract class ActivityProviderModule {

  @Binds
  @IntoMap
  @ActivityKey(MainActivity.class)
  public abstract BaseBuilder provideMainActivityComponentBuilder(MainActivityComponent.Builder builder);

  @Binds
  @IntoMap
  @ActivityKey(SubActivity.class)
  public abstract BaseBuilder provideSubActivityComponentBuilder(SubActivityComponent.Builder builder);
}
