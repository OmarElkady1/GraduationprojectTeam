package com.example.omar.graduationproject1.Utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SectionsStatePagerAdapter extends FragmentStatePagerAdapter {

   private final List<Fragment> mfragmentList= new ArrayList<>();
   private final HashMap<Fragment,Integer> mfragments = new HashMap<>();
   private  final  HashMap<String,Integer>mftagmentNumber=new HashMap<>();
    private  final  HashMap<Integer,String>mftagmentName=new HashMap<>();
    public SectionsStatePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mfragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mfragmentList.size();
    }
    public void addFragment(Fragment fragment,String fragmentName ){
        mfragmentList.add(fragment);
        mfragments.put(fragment,mfragmentList.size()-1);
        mftagmentName.put(mfragmentList.size()-1,fragmentName);
        mftagmentNumber.put(fragmentName,mfragmentList.size()-1);

    }

    public Integer getFragmentNumber(String fragmentName){
        if(mftagmentNumber.containsKey(fragmentName)){
            return mftagmentNumber.get(fragmentName);
        }else {
            return null;
        }
    }
    public Integer getFragmentNumber(Fragment fragmet){
        if(mftagmentNumber.containsKey(fragmet)){
            return mftagmentNumber.get(fragmet);
        }else {
            return null;
        }
    }
    public String getFragmentName(Integer fragmetNumber){
        if(mftagmentName.containsKey(fragmetNumber)){
            return mftagmentName.get(fragmetNumber);
        }else {
            return null;
        }
    }

}
