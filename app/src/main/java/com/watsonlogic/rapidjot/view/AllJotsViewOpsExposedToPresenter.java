package com.watsonlogic.rapidjot.view;

import com.watsonlogic.rapidjot.model.Jot;

/**
 * @author: Kelvin Watson
 */
public interface AllJotsViewOpsExposedToPresenter {
    /**
     * Called when updating a {@link Jot}
     *
     * @param {@link Jot} jot
     */
    void notifyJotUpdated(Jot jot);
}
