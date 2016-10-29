package com.github.satoshun.sample.dagger;

import com.github.satoshun.sample.dagger.sub.SubActivity;
import com.github.satoshun.sample.dagger.top.MainActivity;

import dagger.Binds;
import dagger.Module;

@Module(subcomponents = {
        MainActivityComponent.class,
        SubActivityComponent.class
})
public abstract class ActivityProviderModule {

  @QualifierClass(MainActivity.class)
  public abstract MainActivityComponent.Builder provideMainActivityComponentBuilder(MainActivityComponent.Builder builder);

  @QualifierClass(SubActivity.class)
  public abstract SubActivityComponent.Builder provideSubActivityComponentBuilder(SubActivityComponent.Builder builder);
}
