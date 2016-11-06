package com.watsonlogic.rapidjot.presenter;

import com.watsonlogic.rapidjot.model.Jot;
import com.watsonlogic.rapidjot.model.ModelOpsExposedToPresenter;
import com.watsonlogic.rapidjot.view.JotEditorViewOpsExposedToPresenter;

import java.lang.ref.WeakReference;
import java.util.Date;

/**
 * @author: Kelvin Watson
 */
public class JotEditorPresenter implements JotEditorPresenterOpsExposedToView {
    private WeakReference<JotEditorViewOpsExposedToPresenter> view;
    private ModelOpsExposedToPresenter model;
    private Jot jotUnderEdit;

    public JotEditorPresenter() {
    }

    @Override
    public Jot getJotUnderEdit(){
        return jotUnderEdit;
    }

    @Override
    public void setModel(ModelOpsExposedToPresenter model) {
        this.model = model;
    }

    public JotEditorPresenter(JotEditorViewOpsExposedToPresenter view) {
        this.view = new WeakReference<>(view);
    }

    @Override
    public void setJotUnderEdit(Jot jotUnderEdit) {
        this.jotUnderEdit = jotUnderEdit;
    }

    @Override
    public void notifyJotRetrieved(Jot jot) {
        view.get().notifyJotRetreived(jot);
    }

    @Override
    public void updateJot(String title, String plainTextContent) {
        if (jotUnderEdit != null) {
            model.updateJot(jotUnderEdit, title, plainTextContent);
        }
    }

    @Override
    public void createJot(Date id) {
        jotUnderEdit = new Jot(id);
        model.createJot(jotUnderEdit); //store Jot in database (and locally)
    }

    @Override
    public void notifyJotCreated(Jot jot) {
        view.get().notifyJotCreated(jot);
    }

    @Override
    public void notifyJotUpdated(Jot jot) {
        view.get().notifyJotUpdated(jot);
    }
}
