package com.watsonlogic.rapidjot.view.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.watsonlogic.rapidjot.R;
import com.watsonlogic.rapidjot.model.Jot;
import com.watsonlogic.rapidjot.model.JotModel;
import com.watsonlogic.rapidjot.presenter.AllJotsPresenter;
import com.watsonlogic.rapidjot.presenter.AllJotsPresenterOpsExposedToView;
import com.watsonlogic.rapidjot.view.AllJotsViewOpsExposedToPresenter;

import java.util.Date;

import static android.support.v4.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE;

/**
 * @author: Kelvin Watson
 */
public class AllJotsFragment extends Fragment implements AllJotsViewOpsExposedToPresenter {

    private AllJotsPresenterOpsExposedToView allJotsPresenter = new AllJotsPresenter(this);
    private RecyclerView.Adapter adapter;

    public static final String JOT_ID = "jot_date";
    public static final String JOT_TITLE = "jot_title";
    public static final String JOT_PLAIN_TEXT_CONTENT = "jot_plain_text_content";
    public static final String EDITOR_FRAGMENT = "editor_fragment";

    public AllJotsFragment() {
        // Required empty public constructor
    }

    /**
     * Create a new instance of this fragment
     *
     * @return A new instance of fragment AllJotsFragment.
     */
    public static AllJotsFragment newInstance() {
        return new AllJotsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        allJotsPresenter.setModel(new JotModel());
        allJotsPresenter.getJots();
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_all_jots, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.add_jot_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //jotEditorPresenter.createJot(new Date()); //call this from EditorFragment
                launchJotEditor();
            }
        });

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.all_jots_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new CustomAdapter();
        recyclerView.setAdapter(adapter);

    }

    private void launchJotEditor() {
        Bundle args = new Bundle();
        args.putSerializable(JOT_ID, new Date().getTime());
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, JotEditorFragment.newInstance(args), EDITOR_FRAGMENT);
        transaction.addToBackStack(EDITOR_FRAGMENT);
        transaction.setTransition(TRANSIT_FRAGMENT_FADE);
        transaction.commit();
    }

    @Override
    public void notifyJotUpdated(Jot currentJot) {
        displayJot(currentJot);
    }

    protected void displayJot(Jot jot) {
//        ViewGroup parent = (ViewGroup) getView().findViewById(R.id.content_main);
//        View jotCard = getActivity().getLayoutInflater().inflate(R.layout.jot_display_card, parent, false);
//        ((TextView) jotCard.findViewById(R.id.preview_title)).setText(jot.getTitle());
//        ((TextView) jotCard.findViewById(R.id.preview_content)).setText(jot.getPlainTextContent());
//        parent.addView(jotCard);
    }

    private class CustomAdapter extends RecyclerView.Adapter<JotDisplayViewHolder> {
        @Override
        public JotDisplayViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return allJotsPresenter.createViewHolder(parent, viewType);
        }

        @Override
        public void onBindViewHolder(JotDisplayViewHolder holder, int position) {
            allJotsPresenter.bindViewHolder(holder, position);
        }

        @Override
        public int getItemCount() {
            return allJotsPresenter.getJotCount();
        }
    }

    public static class JotDisplayViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;
        private TextView previewTitle;
        private TextView previewPlainTextContent;

        public JotDisplayViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.jot_img);
            previewTitle = (TextView) itemView.findViewById(R.id.preview_title);
            previewPlainTextContent = (TextView) itemView.findViewById(R.id.preview_plain_text_content);
        }
    }
}
