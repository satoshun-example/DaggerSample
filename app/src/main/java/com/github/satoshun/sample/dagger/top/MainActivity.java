package com.github.satoshun.sample.dagger.top;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.github.satoshun.sample.dagger.MainActivityComponent;
import com.github.satoshun.sample.dagger.R;
import com.github.satoshun.sample.dagger.SampleApplication;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class MainActivity extends AppCompatActivity {

  @Inject CompositeDisposable disposables;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    SampleApplication
            .getMainActivityBuilder(this)
            .activityModule(new MainActivityComponent.MainActivityModule(this))
            .build().inject(this);
  }

  @Override protected void onDestroy() {
    disposables.clear();
    super.onDestroy();
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();

    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }
}
