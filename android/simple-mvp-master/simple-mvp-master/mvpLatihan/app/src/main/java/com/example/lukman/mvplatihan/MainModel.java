package com.example.lukman.mvplatihan;

/**
 * Created by Lukman on 12/28/2017.
 */

public class MainModel implements MainMVP.ModelOps{

    // Presenter reference
    private MainMVP.RequiredPresenterOps mPresenter;

    public MainModel(MainMVP.RequiredPresenterOps mPresenter){
        this.mPresenter = mPresenter;
    }

    /**
     * Sent from {@link MainPresenter#onDestroy(boolean)}
     * Should stop/kill operations that could be running
     * and aren't need anymore
     */
    @Override
    public void onDestroy() {
        // Destroying actions
    }

    // Insert Note in DB
    @Override
    public void insertNote(Note note) {
        // data business logic
        // ...
        mPresenter.onNoteInserted(note);
    }

    // Removes Note from DB
    @Override
    public void removeNote(Note note) {
        // data business logic
        // ...
        mPresenter.onNoteRemoved(note);
    }

}
