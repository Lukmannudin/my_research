package com.example.lukman.latihanmvp;

import android.provider.ContactsContract;

import java.lang.ref.WeakReference;

/**
 * Created by Lukman on 12/24/2017.
 */

public class MainPresenter implements
        MainMVP.RequiredPresenterOps, MainMVP.PresenterOps {

    // Layer View reference
    private WeakReference<MainMVP.RequiredViewOps> mView;
    // Layer Model reference
    private MainMVP.ModelOps mModel;

    // Configuration change state
    private boolean mIsChangingConfig;

    public MainPresenter(MainMVP.RequiredViewOps mView){
        this.mView = new WeakReference<>(mView);
        this.mModel = new MainModel(this);
    }

    /**
     * Sent from Activity after a configuration changes
     * @param view View reference
     */
    @Override
    public void onConfigurationChanged(MainMVP.RequiredViewOps view) {
        mView = new WeakReference<>(view);
    }

    /**
     * Receives {@link MainActivity#onDestroy()} event
     * @param isChangingConfig Config change state
     */

    @Override
    public void onDestroy(Boolean isChangingConfig) {
        mView = null;
        mIsChangingConfig = isChangingConfig;
        if (!isChangingConfig){
            mModel.onDestroy();
        }
    }


    /**
     * Called by user interaction from {@link MainActivity}
     * creates a new Note
     */

    @Override
    public void newNote(String noteText) {
        Note note = new Note();
        note.setText(noteText);
        note.setData(getDate());
        mModel.insertNote(note);
    }

    /**
     * Called from {@link MainModel}
     * when a Note is inserted successfully
     */

    @Override
    public void onNoteInserted(Note newNote) {
        mView.get().showToast("New register added at " + newNote.getDate());
    }

    /**
     * Receives call from {@link MainModel}
     * when Note is removed
     */

    @Override
    public void onNoteRemoved(Note errorMsg) {
        mView.get().showToast("Note removed");
    }
    @Override
    public void deleteNote(Note note) {

    }





}
