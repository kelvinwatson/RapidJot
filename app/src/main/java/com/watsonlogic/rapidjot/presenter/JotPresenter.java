package com.watsonlogic.rapidjot.presenter;

import com.watsonlogic.rapidjot.model.JotModel;
import com.watsonlogic.rapidjot.view.ViewOpsExposedToPresenter;
import com.watsonlogic.rapidjot.model.Jot;

import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: Kelvin Watson
 */
public class JotPresenter implements PresenterOpsExposedToView, PresenterOpsExposedToModel {

    private WeakReference<ViewOpsExposedToPresenter> view;
    private JotModel model;
    protected Jot currentJot;
    private Map<Long, Jot> jots = new LinkedHashMap<>(); //the Long is the Date in milliseconds

    public JotPresenter(ViewOpsExposedToPresenter view) {
        this.view = new WeakReference<>(view);
        this.model = new JotModel(this);
        jots = model.fetchJots(); //retrieve user's jots from service
    }

    @Override
    public void createJot(Date id) {
        currentJot = new Jot(id);
        jots.put(id.getTime(), currentJot); //store jot locally
        model.createJot(currentJot);         //store jot in database
        notifyViewJotCreated(currentJot);
    }

    /**
     * Stores a plain text jot for now. Support for rich text is planned for the future.
     *
     * @param title
     * @param plainTextContent
     */
    public void updateCurrentJot(String title, String plainTextContent) {
        if (currentJot != null) {
            currentJot.setTitle(title);
            currentJot.setPlainTextContent(plainTextContent);
            jots.put(currentJot.getId().getTime(), currentJot);
        } else {
            Date date = new Date();
            currentJot = new Jot(date, title, plainTextContent);
            jots.put(date.getTime(), currentJot);
        }

        model.updateJot(currentJot);

        notifyViewJotUpdated(currentJot);
    }

    private void notifyViewJotUpdated(Jot jot){
        view.get().notifyJotUpdated(jot);
    }

    private void notifyViewJotCreated(Jot jot){
        view.get().notifyJotCreated(jot);
    }

    @Override
    public void notifyJotCreated(Jot jot) {
        view.get().notifyJotCreated(jot);
    }

    @Override
    public void notifyJotUpdated(Jot jot) {
        view.get().notifyJotUpdated(jot);
    }

    public Map<Long, Jot> getJots() {
        return jots;
    }

    /**
     *
     * @param id
     */
    @Override
    public void setCurrentJot(Date id) {
        if (jots != null && !jots.isEmpty())
            currentJot = jots.get(id.getTime()); //retrieve the jot if it exists

        if (currentJot == null) {
            currentJot = new Jot(id); //create a new jot if jot is not in the user's jot map
            jots.put(id.getTime(), currentJot);
        }
    }

    @Override
    public Jot getCurrentJot() {
        return currentJot;
    }

    @Override
    public Jot getJot(Date id){
        return model.getJot(id);
    }
}
