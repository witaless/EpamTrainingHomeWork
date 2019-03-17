package com.witaless.epamtraininghomework;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class RestoreStateFragment extends Fragment {

    private final String TEXT_VIEW_USER_NAME_VALUE_KEY = "textViewUserNameValue";
    private final String EDIT_TEXT_USER_NAME_VALUE_KEY = "editTextUserNameValue";
    private final String TAG = RestoreStateFragment.class.getSimpleName();

    private TextView userNameTextView;
    private EditText userNameEditView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_restore_state, container, false);
        userNameEditView = view.findViewById(R.id.user_name_edittext);
        userNameTextView = view.findViewById(R.id.user_name_textview);

        view.findViewById(R.id.user_name_ok_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userNameTextView.setText(userNameEditView.getText().toString());
            }
        });

        return view;
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);

        Log.d(TAG, "onViewStateRestored: savedInstance " + savedInstanceState);

        if (savedInstanceState != null) {

            if (savedInstanceState.getString(EDIT_TEXT_USER_NAME_VALUE_KEY) != null || savedInstanceState.getString(TEXT_VIEW_USER_NAME_VALUE_KEY) != null) {
                userNameEditView.setText(savedInstanceState.getString(EDIT_TEXT_USER_NAME_VALUE_KEY));
                userNameTextView.setText(savedInstanceState.getString(TEXT_VIEW_USER_NAME_VALUE_KEY));
            }

        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        if (userNameTextView.getText().toString().length() > 0 || userNameEditView.getText().toString().length() > 0) {
            outState.putString(TEXT_VIEW_USER_NAME_VALUE_KEY, userNameTextView.getText().toString());
            outState.putString(EDIT_TEXT_USER_NAME_VALUE_KEY, userNameEditView.getText().toString());
        }
    }

}
