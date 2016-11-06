package com.watsonlogic.rapidjot.model;

import com.watsonlogic.rapidjot.presenter.JotEditorPresenter;
import com.watsonlogic.rapidjot.presenter.JotEditorPresenterOpsExposedToView;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author: Kelvin Watson
 */
public class JotModel implements ModelOpsExposedToPresenter {

    private JotEditorPresenterOpsExposedToView presenter = new JotEditorPresenter();
    private List<Jot> jots = new ArrayList<>(); //local copy of Jots that is in sync with database

    public JotModel() {

    }

    public JotModel(JotEditorPresenterOpsExposedToView presenter) {
        this.presenter = presenter;
    }

    @Override
    public List<Jot> fetchJots() {
        //todo: call Volley, in onPostExecute, call the following:
        return jots;
    }

    @Override
    public List<Jot> getJots() {
        return jots;
    }

    @Override
    public void createJot(Jot jot) {
        jots.add(jot); // add to local copy

        //todo: call Volley, in onPostExecute, call the following:

        presenter.notifyJotCreated(jot);
    }

    @Override
    public void updateJot(Jot jotUnderEdit, String title, String plainTextContent) {
        // Update local copy
        if (jotUnderEdit != null) {
            Long id = jotUnderEdit.getId();
            Iterator<Jot> iterator = jots.iterator(); //concurrently modify the Jot stored locally
            while (iterator.hasNext())
            {
                Jot j = iterator.next();
                if (id.equals(j.getId())){
                    j.setPlainTextContent(title);
                    j.setPlainTextContent(plainTextContent);
                    break; //end concurrent modification
                }
            }
        } else {
            Date date = new Date();
            jotUnderEdit = new Jot(date, title, plainTextContent);
        }

        //todo 1: call Volley to update jotUnderEdit
        //todo 2: in onPostExecute, call the following:
        presenter.notifyJotUpdated(jotUnderEdit);
    }

    @Override
    public Jot getJot(int position) {
        return jots.get(position);
    }

    @Override
    public int getJotCount() {
        return jots.size();
    }
}
