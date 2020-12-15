package com.maryna.photographer.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.fragment.app.Fragment;

import com.maryna.photographer.App;
import com.maryna.photographer.MainActivity;
import com.maryna.photographer.R;
import com.maryna.photographer.model.PhotoPackage;
import com.maryna.photographer.model.PhotoSession;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static com.maryna.photographer.ui.fragments.DetailFragment.PHOTO_SESSION_ID;

public class SelectPackageFragment extends Fragment {

    private ImageView photoImg;
    private TextView titleTxt;
    private TextView priceTxt;
    private TextView timeTxt;
    private TextView photoCountTxt;
    private TextView orderBtn;
    private AppCompatSpinner spinner;

    private List<PhotoPackage> photoPackages;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_select_package, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    private void init(View view) {
        photoImg = view.findViewById(R.id.selectPackageImg);
        titleTxt = view.findViewById(R.id.selectPackageTitle);
        priceTxt = view.findViewById(R.id.selectPackagePrice);
        timeTxt = view.findViewById(R.id.selectPackageTime);
        orderBtn = view.findViewById(R.id.makeOrderBtn);
        spinner = view.findViewById(R.id.packageSpinner);
        photoCountTxt = view.findViewById(R.id.selectPackagePhotoCount);

        if (getArguments() != null) {
            int sessionId = getArguments().getInt(PHOTO_SESSION_ID);
            App.getInstance().getDatabase().photoSessionDao().getPhotoSessionById(sessionId)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(this::setUpSessionViews);

            App.getInstance().getDatabase().photoPackageDao().getAllPhotoPackages()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(this::setPackagesInfo);
        }
    }

    private void setUpSessionViews(PhotoSession photoSession) {
        if (getActivity() != null) {
            Objects.requireNonNull(((MainActivity) getActivity()).getSupportActionBar()).setTitle(photoSession.getTitle());
        }
        titleTxt.setText(photoSession.getTitle());

        Picasso.get()
                .load(photoSession.getPhotoURL())
                .placeholder(R.drawable.ic_loading)
                .error(R.drawable.ic_loading)
                .fit()
                .into(photoImg);
    }

    private void setPackagesInfo(List<PhotoPackage> photoPackages) {
        this.photoPackages = photoPackages;

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), R.layout.row, R.id.spinnerRow, getNamesFromPackages(photoPackages));
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                updatePackageInfo();
            }

            private void updatePackageInfo() {
                if(findPackageByName() != null){
                    priceTxt.setText(getString(R.string.uah,findPackageByName().getPrice()));
                    timeTxt.setText(getString(R.string.time, findPackageByName().getTimeMin()));
                    photoCountTxt.setText(getString(R.string.photo_count, findPackageByName().getPhotoCount()));
                }
            }

            private PhotoPackage findPackageByName(){
                for (PhotoPackage photoPackage : photoPackages) {
                    if(photoPackage.getName().equals(spinner.getSelectedItem().toString())){
                        return photoPackage;
                    }
                }
                return null;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private List<String> getNamesFromPackages(List<PhotoPackage> photoPackages) {
        List<String> names = new ArrayList<>();
        for (PhotoPackage photoPackage : photoPackages) {
            names.add(photoPackage.getName());
        }
        return names;
    }
}