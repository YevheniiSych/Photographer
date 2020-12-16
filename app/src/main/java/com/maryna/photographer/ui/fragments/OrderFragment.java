package com.maryna.photographer.ui.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.maryna.photographer.MainActivity;
import com.maryna.photographer.R;

public class OrderFragment extends Fragment {

    public static final String PHOTO_SESSION_NAME = "PHOTO_SESSION_NAME";

    private TextView headerTxt;
    private TextView nameTxt;
    private TextView phoneTxt;
    private TextView emailTxt;
    private TextView dateTxt;
    private TextView wishesTxt;
    private TextView orderBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_order, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home && getActivity() != null) {
            getActivity().onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    private void init() {
        if (getActivity() != null) {
            headerTxt = getActivity().findViewById(R.id.orderHeaderTxt);
            nameTxt = getActivity().findViewById(R.id.nameTxt);
            phoneTxt = getActivity().findViewById(R.id.phoneNumberTxt);
            emailTxt = getActivity().findViewById(R.id.emailTxt);
            dateTxt = getActivity().findViewById(R.id.dateTxt);
            wishesTxt = getActivity().findViewById(R.id.wishesTxt);
            orderBtn = getActivity().findViewById(R.id.orderButton);

            orderBtn.setOnClickListener(v -> handleOrderClick());
            if (getArguments() != null) {
                headerTxt.setText(getString(R.string.order_photo_session_type, getArguments().get(PHOTO_SESSION_NAME)));
            }
        }
    }

    private void handleOrderClick() {
        if (checkFields()) {
            sendEmail();
        } else {
            Toast.makeText(getContext(), R.string.require_fields, Toast.LENGTH_LONG).show();
        }
    }

    private boolean checkFields() {
        return nameTxt.getText().length() > 0
                && phoneTxt.getText().length() == 10
                && dateTxt.getText().length() > 0
                && emailTxt.getText().length() > 0;
    }

    private void sendEmail() {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setType("message/rfc822");
        String emailBody = nameTxt.getText() + ", " + phoneTxt.getText() + ", " + emailTxt.getText() +  ", " + dateTxt.getText() + "\n" + wishesTxt.getText();
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"viktorianika28key@gmail.com"}); // email фотографа
        emailIntent.putExtra(Intent.EXTRA_TEXT, emailBody);
        startActivity(Intent.createChooser(emailIntent, "Сhoose email app"));
        ((MainActivity)getActivity()).getNavController().navigate(R.id.action_orderFragment_to_homeFragment);
    }
}