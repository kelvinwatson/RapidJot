package com.watsonlogic.rapidjot.view;

import com.watsonlogic.rapidjot.model.Jot;

/**
 * @author: Kelvin Watson
 */
public interface ViewOpsExposedToPresenter {

    /**
     * Called when creating a {@link Jot}
     *
     * @param {@link Jot} jot
     */
    void notifyJotCreated(Jot jot);

    /**
     * Called when updating a {@link Jot}
     *
     * @param {@link Jot} jot
     */
    void notifyJotUpdated(Jot jot);
}
