package com.github.satoshun.sample.dagger;

import android.app.Activity;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import dagger.MapKey;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@MapKey
@Documented
@Retention(RUNTIME)
public @interface ActivityKey {
  Class<? extends Activity> value();
}
