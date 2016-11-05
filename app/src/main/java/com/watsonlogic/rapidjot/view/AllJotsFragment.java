package com.watsonlogic.rapidjot.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.watsonlogic.rapidjot.R;
import com.watsonlogic.rapidjot.model.Jot;
import com.watsonlogic.rapidjot.presenter.JotPresenter;
import com.watsonlogic.rapidjot.presenter.PresenterOpsExposedToView;

import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AllJotsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AllJotsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AllJotsFragment extends Fragment implements ViewOpsExposedToPresenter  {

    private PresenterOpsExposedToView presenter = new JotPresenter(this);

    public static final String JOT_ID = "jot_date";
    public static final String JOT_TITLE = "jot_title";
    public static final String JOT_PLAIN_TEXT_CONTENT = "jot_plain_text_content";
    public static final String EDITOR_FRAGMENT = "editor_fragment";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public AllJotsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment AllJotsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AllJotsFragment newInstance() {
        return new AllJotsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all_jots, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.add_jot_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.createJot(new Date());
            }
        });
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    @Override
    public void notifyJotCreated(Jot currentJot) {
        launchJotEditor(currentJot);
    }

    private void launchJotEditor(Jot jot) {
        Bundle args = new Bundle();
        args.putSerializable(JOT_ID, jot.getId());
        args.putString(JOT_TITLE, jot.getTitle());
        args.putString(JOT_PLAIN_TEXT_CONTENT, jot.getPlainTextContent());
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, JotEditorFragment.newInstance(args), EDITOR_FRAGMENT);
        transaction.addToBackStack(EDITOR_FRAGMENT);
        transaction.commit();
    }

    @Override
    public void notifyJotUpdated(Jot currentJot) {
        displayJot(currentJot);
    }

    protected void displayJot(Jot jot) {
        ViewGroup parent = (ViewGroup) getView().findViewById(R.id.content_main);
        View jotCard = getActivity().getLayoutInflater().inflate(R.layout.jot_display_card, parent, false);
        ((TextView)jotCard.findViewById(R.id.preview_title)).setText(jot.getTitle());
        ((TextView)jotCard.findViewById(R.id.preview_content)).setText(jot.getPlainTextContent());
        parent.addView(jotCard);
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
