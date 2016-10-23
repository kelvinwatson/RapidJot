package com.watsonlogic.rapidjot.presenter;

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
    private Jot currentJot;
    private Map<Long, Jot> jots = new LinkedHashMap<>(); //the Long is the Date in milliseconds

    public JotPresenter(ViewOpsExposedToPresenter view) {
        this.view = new WeakReference<>(view);
        loadJots(); //retrieve user's jots from service
    }

    @Override
    public void createJot(Date id) {
        currentJot = new Jot(id);
        jots.put(id.getTime(), currentJot); //insert the jot so that it can be retrieved later
        //todo: call service to store this new jot
    }

    @Override
    public Map<Long, Jot> loadJots() {
        //todo: create and execute async task to get jots
        return new LinkedHashMap<>();
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

    /**
     * Returns a jot from the service with the corresonding id
     * @param id
     * @return
     */
    @Override
    public Jot getCurrentJot(Date id) {
        return null;
    }

    public Jot getCurrentJot() {
        return currentJot;
    }

    /**
     * Stores a plain text jot for now. Support for rich text is planned for the future.
     *
     * @param title
     * @param plainTextContent
     */
    public void saveCurrentJot(Date id, String title, String plainTextContent) {
        //todo: retrieve jot from map
        if (currentJot != null) {
            currentJot.setTitle(title);
            currentJot.setPlainTextContent(plainTextContent);
        } else {
            currentJot = new Jot(id, title, plainTextContent);
        }

        //todo: make API call to store Jot object
        jots.put(id.getTime(), currentJot);

        notifyView();
    }

    private void notifyView(){
        view.get().notifyJotInserted();
    }
}
