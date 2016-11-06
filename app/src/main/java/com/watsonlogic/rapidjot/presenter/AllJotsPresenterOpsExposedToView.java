package com.watsonlogic.rapidjot.presenter;

import android.view.ViewGroup;

import com.watsonlogic.rapidjot.model.Jot;
import com.watsonlogic.rapidjot.view.fragments.AllJotsFragment;

/**
 * @author: Kelvin Watson
 */
public interface AllJotsPresenterOpsExposedToView extends BasePresenter {
    /**
     * Implementation should communicate to the model to get {@link Jot}s from database
     */
    void getJots();

    /**
     * Calls the model to fetch a {@link Jot} from the service with the corresponding id
     *
     * @return {@link Jot}
     */
    Jot getCurrentJot();

    /**
     * Returns the current number of jots in the database
     *
     * @return
     */
    int getJotCount();

    /**
     * Binds the {@link com.watsonlogic.rapidjot.view.fragments.AllJotsFragment.JotDisplayViewHolder}
     * with the RecyclerView
     *
     * @param holder
     * @param position
     */
    void bindViewHolder(AllJotsFragment.JotDisplayViewHolder holder, int position);

    /**
     * Creates the RecyclerViewHolder and sets up its view
     *
     * @param parent
     * @param viewType
     * @return
     */
    AllJotsFragment.JotDisplayViewHolder createViewHolder(ViewGroup parent, int viewType);
}
