package com.example.lukman.mvplatihan;

import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Lukman on 12/28/2017.
 */

public class MainPresenter implements MainMVP.RequiredPresenterOps,MainMVP.PresenterOps{

    //Layer View Reference
    private WeakReference<MainMVP.RequiredViewOps> mView;
    //Layer Model Reference
    private MainMVP.ModelOps mModel;

    //Configuration change state
    private boolean mIsChangingConfig;

    public MainPresenter(MainMVP.RequiredViewOps mView){
        this.mView = new WeakReference<>(mView);
        this.mModel = new MainModel(this);
    }

    /**
     * Sent from activity after a configuration changes
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
    public void onDestroy(boolean isChangingConfig) {
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
    public void newNote(String textToNote) {
        Note note = new Note();
        note.setText(textToNote);

        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        String formattedDate = df.format(c.getTime());

        note.setDate(formattedDate);
        mModel.insertNote(note);
    }

    /**
     * Called from {@link MainActivity}
     * remove a note
     */
    @Override
    public void removeNote(Note note){
        mModel.removeNote(note);
    }

    /**
     * Called from {@link MainModel}
     * when a Note is inserted succesfully
     */

    @Override
    public void onNoteInserted(Note newNote) {
        mView.get().showToast("New register added at " + newNote.getDate());
    }

    /**
     * Receives call from {@link MainModel}
     * When Note is Removed
     */
    @Override
    public void onNoteRemoved(Note noteRemoved) {
        mView.get().showToast("Note Removed");
    }

    /**
     * receive Errors
     * @param errorMsg
     */
    @Override
    public void onError(String errorMsg) {
        mView.get().showAlert(errorMsg);
    }
}
