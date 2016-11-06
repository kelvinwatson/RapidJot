package com.watsonlogic.rapidjot.view;

import com.watsonlogic.rapidjot.model.Jot;

/**
 * @author: Kelvin Watson
 */

public interface JotEditorViewOpsExposedToPresenter {
    /**
     * Presenter signals to the view that the {@link Jot} was retrieved from the database
     *
     * @param jot
     */
    void notifyJotRetreived(Jot jot);

    /**
     * Presenter signals to the view that the {@link Jot} was created in the database
     *
     * @param jot
     */
    void notifyJotCreated(Jot jot);

    /**
     * Presenter signals to the view that the {@link Jot} was updated in the database
     *
     * @param jot
     */
    void notifyJotUpdated(Jot jot);
}
