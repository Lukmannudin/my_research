package com.example.lukman.latihanmvp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity  implements MainMVP.RequiredViewOps{

    protected final String TAG = getClass().getSimpleName();

    // Responible to maintain the objects state
    // during changing configuration

    private final StateMaintainer mStateMaintainer =
            new StateMaintainer(this.getFragmentManager(), TAG);

    //Presenter Operations
    private MainMVP.PresenterOps mPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startMVPOps();
        setContentView(R.layout.activity_main);
        FloatingActionButton fab =  (FloatingActionButton)findViewById(R.id.fab);
    }

    /**
     * Initialize and restart the presenter
     * This method should be called after {@link Activity#onCreate(Bundle)}
     */

    public void startMVPOps() {
        try {
            if ( mStateMaintainer.firstTimeIn() ) {
                Log.d(TAG, "onCreate() called for the first time");
                initialize(this);
            } else {
                Log.d(TAG, "onCreate() called more than once");
                reinitialize(this);
            }
        } catch ( InstantiationException | IllegalAccessException e ) {
            Log.d(TAG, "onCreate() " + e );
            throw new RuntimeException( e );
        }
    }

    /**
     * Initialize relevant MVP Objects
     * Creates a Presenter instance, saves the presenter in {@link StateMaintainer}
     */

    private void initialize(MainMVP.RequiredViewOps view) throws InstantiationException, IllegalAccessException {
        mPresenter = new MainPresenter(view);
        mStateMaintainer.put(MainMVP.PresenterOps.class.getSimpleName(), mPresenter);
    }

    /**
     * Recovers Presenter and informs Presenter that occured a config change
     * If presenter has been lost, recreates a instance
     */

    private void reinitialize(MainMVP.RequiredViewOps view) throws  InstantiationException, IllegalAccessException {
        mPresenter = mStateMaintainer.get(MainMVP.PresenterOps.class.getSimpleName());
        if( mPresenter == null) {
            Log.w(TAG, "Recreating Presenter");
            initialize(view);
        } else {
            mPresenter.onConfigurationChanged(view);
        }
    }

    // Show alert Dialog
    @Override
    public void showAlert(String msg){
        // show alert box
    }

    // Show toast
    @Override
    public void showToast(String msg){
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }





}
