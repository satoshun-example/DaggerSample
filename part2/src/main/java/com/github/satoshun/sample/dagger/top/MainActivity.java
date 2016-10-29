package com.github.satoshun.sample.dagger.top;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.satoshun.sample.dagger.ActivityScope;
import com.github.satoshun.sample.dagger.MainActivityComponent;
import com.github.satoshun.sample.dagger.R;
import com.github.satoshun.sample.dagger.SampleApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

  @Inject CompositeDisposable disposables;
  @Inject SampleAdapter adapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    ((MainActivityComponent.Builder) SampleApplication.activityBuilder(this, MainActivity.class))
            .activityModule(new MainActivityComponent.MainActivityModule(this))
            .build().injectMembers(this);
    disposables.add(Observable.timer(1, TimeUnit.SECONDS)
            .repeat(100)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Consumer<Long>() {
              @Override
              public void accept(Long aLong) throws Exception {
                adapter.countup();
              }
            }));

    RecyclerView view = (RecyclerView) findViewById(R.id.content);
    view.setAdapter(adapter);
  }

  @Override
  protected void onDestroy() {
    // release all tasks.
    disposables.clear();
    super.onDestroy();
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @ActivityScope
  public static class SampleAdapter extends RecyclerView.Adapter<SampleViewHolder> {

    // this is a ActivityScope CompositeDisposable, Live along with the Activity LifeCycle.
    @Inject CompositeDisposable disposables;

    private final Context context;
    private final List<Integer> counts = new ArrayList<>();

    @Inject
    public SampleAdapter(Context context) {
      this.context = context;
    }

    @Override
    public SampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      return new SampleViewHolder(new TextView(context));
    }

    @Override
    public void onBindViewHolder(SampleViewHolder holder, int position) {
      holder.parentView.setText(String.valueOf(position));

      // simulates a heavy task
      disposables.add(Observable.timer(10, TimeUnit.SECONDS).subscribe());
    }

    @Override
    public int getItemCount() {
      return counts.size();
    }

    void countup() {
      counts.add(0);
      notifyDataSetChanged();
    }
  }

  private static class SampleViewHolder extends RecyclerView.ViewHolder {

    private final TextView parentView;

    public SampleViewHolder(TextView itemView) {
      super(itemView);
      this.parentView = itemView;
    }
  }
}
