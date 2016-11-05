package com.watsonlogic.rapidjot.model;

import java.util.Date;
import java.util.Map;

/**
 * Created by Bryce on 10/23/2016.
 */
public interface ModelOpsExposedToPresenter {
    /**
     * Get list of jots from database
     * @return a List of {@link Jot}s
     */
    Map<Long, Jot> fetchJots();

    /**
     * Store a {@link Jot} in  database
     * @param {@link Jot}
     */
    void storeJot(Jot jot);

    /**
     * Retrieve one {@link Jot} from the database
     * @param id
     * @return a {@link Jot}
     */
    Jot getJot(Date id);
}
