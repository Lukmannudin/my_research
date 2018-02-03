package com.example.lukman.latihanmvp;

/**
 * Created by Lukman on 12/24/2017.
 */

public class MainModel implements MainMVP.ModelOps {

    // Presenter reference
    private MainMVP.RequiredPresenterOps mPresenter;

    public MainModel(MainMVP.RequiredPresenterOps mPresenter){
        this.mPresenter = mPresenter;
    }

    /**
     * Sent from {@link MainPresenter#onDestroy(Boolean)}
     * Should stop/kill operations that could be running
     * and aren't need anymore
     */

    @Override
    public void onDestroy() {
        // destroying actions
    }

    // Insert Note in DB
    @Override
    public void insertNote(Note note) {
        //data business logic
        //...
        mPresenter.onNoteInserted(note);
    }

    // remove Note from DB
    @Override
    public void removeNote(Note note) {
        //data business logic
        //...
        mPresenter.onNoteRemoved(note);
    }


}
