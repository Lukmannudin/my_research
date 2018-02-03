package com.example.lukman.mvplatihan;

/**
 * Created by Lukman on 12/28/2017.
 */

/**
 * Aggregates all communication operations between MVP pattern layers
 * Model, View and Presenter
 */
public interface MainMVP {
    /**
     * View mandatory methods. Available to Presenter
     * Presenter -> View
     */
    interface RequiredViewOps {
        void showToast(String msg);
        void showAlert(String msg);
        // any other ops
    }

    /**
     * Operations offered from Presenter to View
     * View -> Presenter
     */
    interface PresenterOps {
        void onConfigurationChanged(RequiredViewOps view);
        void onDestroy(boolean isChangingConfig);
        void newNote(String textToNote);
        void removeNote(Note note);
        //any other ops to be called from view
    }

    /**
     * Operations offered from Presenter to Model
     * Model -> Presenter
     */
    interface RequiredPresenterOps {
        void onNoteInserted(Note note);
        void onNoteRemoved(Note note);
        void onError(String errorMsg);
        // Any other returning operation Model -> Presenter
    }

    /**
     * Model operations offered to Presenter
     * Presenter -> Model
     */
    interface ModelOps {
        void insertNote(Note note);
        void removeNote(Note note);
        void onDestroy();
        // Any other data operations
    }
}
