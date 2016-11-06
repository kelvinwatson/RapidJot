package com.watsonlogic.rapidjot.presenter;

import com.watsonlogic.rapidjot.model.ModelOpsExposedToPresenter;

/**
 * @author: Bryce
 */

public interface BasePresenter {
    /*
     * Set the model for this presenter
     */
    void setModel(ModelOpsExposedToPresenter model);
}
