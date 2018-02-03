package com.example.lukman.latihanmvp;

/**
 * Created by Lukman on 12/24/2017.
 */

/*
*  Aggregates all communication operations between MVP pattern layer:
*  Model, View and Presenter
* */
public interface MainMVP {
    /**
     * View mandatory methods. Available to Presenter
     *      Presenter -> View
     */
    interface RequiredViewOps {
        void showToast(String msg);
        void showAlert(String msg);
        // any other ops
    }

    /**
     * Operations offered from presenter to view
     *     View -> Presenter
     */
    interface PresenterOps {
        void onConfigurationChanged(RequiredViewOps viewOps);
        void onDestroy(Boolean isChangingConfig);
        void newNote(String textToNote);
        void deleteNote(Note note);
        //any other ops to be called from view
    }

    /**
     *  Operations offered from Presenter to Model
     *  Model -> Presenter
     */
    interface RequiredPresenterOps {
        void onNoteInserted(Note novaNote);
        void onNoteRemoved(Note errorMsg);
        // Any other returning operation Model -> Presenter
    }

    /**
     * Model operations offered to Presenter
     */
    interface ModelOps {
        void insertNote(Note note);
        void removeNote(Note note);
        void onDestroy();
    }
}
