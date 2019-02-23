package com.example.omar.graduationproject1.Profile;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.omar.graduationproject1.R;
import com.example.omar.graduationproject1.Utils.UniversalImageLoader;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Created by User on 5/28/2017.
 */

public class EditProfileFragment extends Fragment {
    private static final String TAG = "EditProfileFragment";
    private ImageView mprofilePhoto;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_editprofile, container, false);
       mprofilePhoto =(ImageView) view.findViewById(R.id.profile_photo);
       initImageLoader();
       setProfileImage();
        return view;
    }
    private  void initImageLoader(){

        UniversalImageLoader universalImageLoader =new UniversalImageLoader(getActivity());
        ImageLoader.getInstance().init(universalImageLoader.getConfig());

    }
    private void setProfileImage(){

        Log.d(TAG,"setProfileImage:setting profile image.");
        String imgURL ="images.idgesg.net/images/article/2017/08/android_robot_logo_by_ornecolorada_cc0_via_pixabay1904852_wide-100732483-large.jpg";
        UniversalImageLoader.setImage(imgURL,mprofilePhoto,null,"https://");

    }
}