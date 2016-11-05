package com.watsonlogic.rapidjot.model;

import com.watsonlogic.rapidjot.presenter.PresenterOpsExposedToModel;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: Kelvin Watson
 */
public class JotModel implements ModelOpsExposedToPresenter {

    private PresenterOpsExposedToModel presenter;

    public JotModel(PresenterOpsExposedToModel presenter) {
        this.presenter = presenter;
    }

    @Override
    public Map<Long, Jot> fetchJots() {
        return new LinkedHashMap<>();
    }

    @Override
    public void createJot(Jot jot) {
        //todo: call Volley
        presenter.notifyJotCreated(jot);
    }

    @Override
    public void updateJot(Jot jot) {
        //todo: call Volley
        presenter.notifyJotUpdated(jot);
    }

    @Override
    public Jot getJot(Date id) {
        return null;
    }
}
