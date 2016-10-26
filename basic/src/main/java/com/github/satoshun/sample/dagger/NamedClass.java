package com.github.satoshun.sample.dagger;

import android.app.Activity;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Qualifier
@Documented
@Retention(RUNTIME)
public @interface NamedClass {
  Class<? extends Activity> value();
}
