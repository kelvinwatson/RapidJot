package com.watsonlogic.rapidjot.presenter;

import com.watsonlogic.rapidjot.model.Jot;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author: Kelvin Watson
 */
public interface PresenterOpsExposedToView {

    /**
     * Set the current jot
     */
    void setCurrentJot(Date id);

    /**
     * Calls the model to fetch a {@link Jot} from the service with the corresponding id
     * @return {@link Jot}
     */
    Jot getCurrentJot();

    Jot getJot(Date id);

    /**
     * Creates a new jot based on the unique date
     * @param id
     */
    void createJot(Date id);

}
