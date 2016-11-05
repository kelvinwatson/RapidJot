package com.watsonlogic.rapidjot.view;

import com.watsonlogic.rapidjot.model.Jot;

/**
 * @author: Kelvin Watson
 */
public interface ViewOpsExposedToPresenter {

    /**
     * Notify the view that the jot has been inserted into the database
     */
    void notifyJotInserted(Jot currentJot);
}
