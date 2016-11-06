package com.watsonlogic.rapidjot.presenter;

import com.watsonlogic.rapidjot.model.Jot;

import java.util.Date;

/**
 * @author: Kelvin Watson
 */

public interface JotEditorPresenterOpsExposedToView extends BasePresenter {
    /**
     * Get the current {@link Jot} that the user is editing
     *
     */
    Jot getJotUnderEdit();

    /**
     * Set the current {@link Jot} that the user is editing
     *
     * @param jotUnderEdit
     */
    void setJotUnderEdit(Jot jotUnderEdit);

    /**
     * Let the view know that a Jot has been fetched from the database
     *
     * @param jot
     */
    void notifyJotRetrieved(Jot jot);

    /**
     * Update the plain text content of a {@link Jot} in the database
     * @param title
     * @param plainTextContent
     */
    void updateJot(String title, String plainTextContent);

    /**
     * Notify presenter that {@link Jot} has been updated in the database
     *
     * @param jot
     */
    void notifyJotUpdated(Jot jot);

    /**
     * Creates a new jot based on the unique date
     *
     * @param id
     */
    void createJot(Date id);

    /**
     * Notify presenter that {@link Jot} has been inserted into the database
     *
     * @param jot
     */
    void notifyJotCreated(Jot jot);
}
