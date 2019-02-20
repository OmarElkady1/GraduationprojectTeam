package com.example.omar.graduationproject1.Home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.omar.graduationproject1.R;
/**
 * Created by User on 5/28/2017.
 * test
 * 3laa
 * 7amdy
 */

public class CameraFragment extends Fragment {
    private static final String TAG = "CameraFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.camera_faragment, container, false);

        return view;
    }
}
