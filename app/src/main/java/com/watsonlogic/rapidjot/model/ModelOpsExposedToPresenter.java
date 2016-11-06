package com.watsonlogic.rapidjot.model;

import java.util.List;

/**
 * @author: Kelvin Watson
 */
public interface ModelOpsExposedToPresenter {
    /**
     * Get list of {@Link Jot}s from database
     *
     * @return a List of {@link Jot}s
     */
    List<Jot> fetchJots();

    /**
     * Get local copy of list of {@Link Jot}s
     *
     * @return a List of {@link Jot}s
     */
    List<Jot> getJots();

    /**
     * Insert a new {@link Jot} in the database
     *
     * @param {@link Jot}
     */
    void createJot(Jot jot);

    /**
     * Update an existing {@link Jot} in the database
     *
     * @param jotUnderEdit {@link Jot}
     * @param title
     * @param plainTextContent
     */
    void updateJot(Jot jotUnderEdit, String title, String plainTextContent);

    /**
     * Retrieve one {@link Jot} from the list of Jots
     *
     * @param position
     * @return a {@link Jot}
     */
    Jot getJot(int position);

    /**
     * Return the number of {@link Jot}s from the list of Jots
     *
     * @return
     */
    int getJotCount();
}
