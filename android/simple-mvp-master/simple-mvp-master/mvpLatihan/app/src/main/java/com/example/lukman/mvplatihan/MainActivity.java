package com.example.lukman.mvplatihan;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MainMVP.RequiredViewOps {

    protected final String TAG = getClass().getSimpleName();

    // responsible to maintain the object state
    // during changing configuration
    private final StateMaintainer mStateMaintainer =
            new StateMaintainer(this.getFragmentManager(),TAG);

    // Presenter operations
    private MainMVP.PresenterOps mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startMVPOps();
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    /**
     * Initialize and restart the Presenter
     *
     */
    public void startMVPOps(){
        try {
            if (mStateMaintainer.firstTimeIn()){
                Log.d(TAG, "onCreate() called for the first time");
                initialize(this);
            } else {
                Log.d(TAG, "onCreate() called more than once");
                reinitialize(this);
            }
        } catch (InstantiationException e){
            Log.d(TAG, "onCreate() "+e);
            throw new RuntimeException(e);
        } catch (IllegalAccessException e){
            Log.d(TAG, "onCreate() "+e);
            throw new RuntimeException(e);
        }
    }

    /**
     * Initialize relevant MVP Objects.
     * Creates a Presenter instance, saves the presenter in {@link StateMaintainer}
     */
    private void initialize(MainMVP.RequiredViewOps view) throws InstantiationException, IllegalAccessException {
        mPresenter = new MainPresenter(this);
        mStateMaintainer.put(MainMVP.PresenterOps.class.getSimpleName(), mPresenter);
    }

    /**
     * Recovers Presenter and informs Presenter that occured a config change.
     * If presenter has been lost, recreates a instance
     * @return
     */
    private void reinitialize(MainMVP.RequiredViewOps view) throws InstantiationException, IllegalAccessException {
        mPresenter = mStateMaintainer.get(MainMVP.PresenterOps.class.getSimpleName());
        if (mPresenter ==null){
            Log.w(TAG, "recreating Presenter");
            initialize(view);
        } else {
            mPresenter.onConfigurationChanged(view);
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showAlert(String msg) {
        // show alert box
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
