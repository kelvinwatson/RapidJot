package com.watsonlogic.rapidjot.presenter;

import com.watsonlogic.rapidjot.model.Jot;

/**
 * @author: Kelvin Watson
 */
public interface PresenterOpsExposedToModel {
    /**
     * Notify presenter that {@link Jot} has been inserted into the database
     *
     * @param jot
     */
    void notifyJotCreated(Jot jot);

    /**
     * Notify presenter that {@link Jot} has been udpated in the database
     *
     * @param jot
     */
    void notifyJotUpdated(Jot jot);
}
