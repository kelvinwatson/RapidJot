package com.watsonlogic.rapidjot.presenter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.watsonlogic.rapidjot.R;
import com.watsonlogic.rapidjot.model.Jot;
import com.watsonlogic.rapidjot.model.JotModel;
import com.watsonlogic.rapidjot.model.ModelOpsExposedToPresenter;
import com.watsonlogic.rapidjot.view.AllJotsViewOpsExposedToPresenter;
import com.watsonlogic.rapidjot.view.fragments.AllJotsFragment;

import java.lang.ref.WeakReference;

/**
 * @author: Kelvin Watson
 */
public class AllJotsPresenter implements AllJotsPresenterOpsExposedToView {

    private WeakReference<AllJotsViewOpsExposedToPresenter> view;
    private ModelOpsExposedToPresenter model = new JotModel();
    protected Jot currentJot;

    public AllJotsPresenter(AllJotsViewOpsExposedToPresenter view) {
        this.view = new WeakReference<>(view);
    }

    @Override
    public void setModel(ModelOpsExposedToPresenter model){
        this.model = model;
    }

    @Override
    public void getJots(){
        model.fetchJots();
    }

    @Override
    public int getJotCount() {
        return model.getJotCount();
    }

    @Override
    public void bindViewHolder(AllJotsFragment.JotDisplayViewHolder holder, int position) {
        model.getJot(position);
    }

    @Override
    public AllJotsFragment.JotDisplayViewHolder createViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.jot_display_card, parent, false);
        return new AllJotsFragment.JotDisplayViewHolder(itemView);
    }


    @Override
    public Jot getCurrentJot() {
        return currentJot;
    }
}
