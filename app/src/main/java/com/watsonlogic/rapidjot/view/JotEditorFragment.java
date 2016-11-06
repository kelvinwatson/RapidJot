package com.watsonlogic.rapidjot.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.watsonlogic.rapidjot.R;

/**
 * @author: Kelvin Watson
 */
public class JotEditorFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public JotEditorFragment() {
        // Required empty public constructor
    }

    /**
     * Create a new instance of JotEditorFragment using the provided parameters.
     *
     * @param args {@link Bundle}.
     * @return A new instance of fragment JotEditorFragment.
     */
    // TODO: Rename and change types and number of parameters
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_jot_editor, container, false);
    }

    public void onBackPressed(){
        getActivity().getSupportFragmentManager().popBackStack();
    }
}
