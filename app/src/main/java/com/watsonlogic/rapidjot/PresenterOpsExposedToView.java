package com.watsonlogic.rapidjot;

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
     * Get the current jot based on the id
     * @return Jot
     */
    Jot getCurrentJot(Date id);

    /**
     * Get the list of user jots
     */
    Map<Long, Jot> loadJots();

    /**
     * Creates a new jot based on the unique date
     * @param id
     */
    void createJot(Date id);

}
