package com.watsonlogic.rapidjot.view.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.watsonlogic.rapidjot.R;
import com.watsonlogic.rapidjot.model.Jot;
import com.watsonlogic.rapidjot.presenter.JotEditorPresenter;
import com.watsonlogic.rapidjot.presenter.JotEditorPresenterOpsExposedToView;
import com.watsonlogic.rapidjot.view.JotEditorViewOpsExposedToPresenter;

public class JotEditorFragment extends Fragment implements JotEditorViewOpsExposedToPresenter {

    private JotEditorPresenterOpsExposedToView editorPresenter = new JotEditorPresenter(this);

    public JotEditorFragment() {
        // Required empty public constructor
    }

    /**
     * Create a new instance of JotEditorFragment using the provided parameters.
     *
     * @param args {@link Bundle}.
     * @return A new instance of fragment JotEditorFragment.
     */
    public static JotEditorFragment newInstance(Bundle args) {
        JotEditorFragment fragment = new JotEditorFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_jot_editor, container, false);
    }

    public void onBackPressed() {
        getActivity().getSupportFragmentManager().popBackStack();
    }

    @Override
    public void notifyJotRetreived(Jot jot) {

    }

    @Override
    public void notifyJotCreated(Jot jot) {

    }

    @Override
    public void notifyJotUpdated(Jot jot) {

    }
}