package com.watsonlogic.rapidjot.model;

import java.util.Date;
import java.util.Map;

/**
 * @author: Kelvin Watson
 */
public interface ModelOpsExposedToPresenter {
    /**
     * Get list of jots from database
     *
     * @return a List of {@link Jot}s
     */
    Map<Long, Jot> fetchJots();

    /**
     * Insert a new {@link Jot} in the database
     *
     * @param {@link Jot}
     */
    void createJot(Jot jot);

    /**
     * Update an existing {@link Jot} in the database
     *
     * @param {@link Jot}
     */
    void updateJot(Jot jot);

    /**
     * Retrieve one {@link Jot} from the database
     *
     * @param id
     * @return a {@link Jot}
     */
    Jot getJot(Date id);
}
