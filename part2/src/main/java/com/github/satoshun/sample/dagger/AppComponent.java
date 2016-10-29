package com.github.satoshun.sample.dagger;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        AppModule.class,
        ActivityProviderModule.class
})
public interface AppComponent {
  SampleApplication inject(SampleApplication application);
}
