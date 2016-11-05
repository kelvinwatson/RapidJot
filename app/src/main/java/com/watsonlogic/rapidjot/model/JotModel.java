package com.watsonlogic.rapidjot.model;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: Kelvin Watson
 */
public class JotModel implements ModelOpsExposedToPresenter {
    @Override
    public Map<Long, Jot> fetchJots() {
        return new LinkedHashMap<>();
    }

    @Override
    public void storeJot(Jot jot) {

    }

    @Override
    public Jot getJot(Date id) {
        return null;
    }
}
