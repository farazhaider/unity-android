package com.labs.leben.unitysimple;

import android.app.Activity;

import android.app.ActionBar;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class DashboardActivity extends FragmentActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;
    private int  mGreen,mRed,mBlue;
    private int mIcon;


    private ArrayList<UnitModel> accelarationArrayList = new ArrayList<UnitModel>();
    private ArrayList<UnitModel> areaArrayList = new ArrayList<UnitModel>();
    private ArrayList<UnitModel> currencyArrayList = new ArrayList<UnitModel>();
    private ArrayList<UnitModel> digitalStorageArrayList = new ArrayList<UnitModel>();
    private ArrayList<UnitModel> energyArrayList = new ArrayList<UnitModel>();
    private ArrayList<UnitModel> forceArrayList = new ArrayList<UnitModel>();
    private ArrayList<UnitModel> lengthArrayList = new ArrayList<UnitModel>();
    private ArrayList<UnitModel> massArrayList = new ArrayList<UnitModel>();
    private ArrayList<UnitModel> numberSystemArrayList = new ArrayList<UnitModel>();
    private ArrayList<UnitModel> powerArrayList = new ArrayList<UnitModel>();
    private ArrayList<UnitModel> speedArrayList = new ArrayList<UnitModel>();
    private ArrayList<UnitModel> temperatureArrayList = new ArrayList<UnitModel>();
    private ArrayList<UnitModel> timeArrayList = new ArrayList<UnitModel>();
    private ArrayList<UnitModel> volumeArrayList = new ArrayList<UnitModel>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        mNavigationDrawerFragment = (NavigationDrawerFragment)

                getFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));

    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment f;
        switch (position) {
            case 0:
                accelarationArrayList.clear();
                accelarationArrayList.add(new UnitModel("Metre/Second Square (m/s2)",1.0d,null,true));
                accelarationArrayList.add(new UnitModel("Foot/Second Square (ft/s2)",0.3048d,null,true));
                accelarationArrayList.add(new UnitModel("Standard Gravity (gn)",9.806614d,null,true));
                f=new RecyclerViewFragment(accelarationArrayList);
                onSectionAttached(position+1);
                fragmentManager.beginTransaction()
                        .replace(R.id.container,f)
                        .commit();
                mTitle=getTitle();
                break;
            case 1:
                areaArrayList.clear();
                areaArrayList.add(new UnitModel("Square Kilometre (km2)",1000000.0d,null,true));
                areaArrayList.add(new UnitModel("Hectare (ha)",10000d,null,true));
                areaArrayList.add(new UnitModel("Square Metre (m2)",1.0d,null,true));
                areaArrayList.add(new UnitModel("Square Centimetre (cm2)",0.0001d,null,true));
                areaArrayList.add(new UnitModel("Square Mile (mi2)",2589988d,null,true));
                areaArrayList.add(new UnitModel("Acre (ac)",4046.856d,null,true));
                areaArrayList.add(new UnitModel("Square Foot (ft2)",0.0929304d,null,true));
                areaArrayList.add(new UnitModel("Square Yard (yd2)",0.8361274d,null,true));
                f=new RecyclerViewFragment(areaArrayList);
                onSectionAttached(position+1);
                fragmentManager.beginTransaction()
                        .replace(R.id.container,f)
                        .commit();
                break;
            case 2:
                currencyArrayList.add(new UnitModel("USD",1,null,false));
                currencyArrayList.add(new UnitModel("AED",3.673062,null,false));
                currencyArrayList.add(new UnitModel("INR",61.49862,null,false));
                currencyArrayList.add(new UnitModel("EUR",0.804639,null,false));
                currencyArrayList.add(new UnitModel("GBP",0.631063,null,false));
                currencyArrayList.add(new UnitModel("RUB",45.87329,null,false));
                f=new RecyclerViewFragment(currencyArrayList);
                onSectionAttached(position+1);
                fragmentManager.beginTransaction()
                        .replace(R.id.container,f)
                        .commit();
                break;
            case 3:
                digitalStorageArrayList.clear();
                digitalStorageArrayList.add(new UnitModel("Bit", 1d, null, true));
                digitalStorageArrayList.add(new UnitModel("Byte",8d,null,true));
                digitalStorageArrayList.add(new UnitModel("KiloBit",1000d,null,true));
                digitalStorageArrayList.add(new UnitModel("KiloByte",8000d,null,true));
                digitalStorageArrayList.add(new UnitModel("MegaBit",1000000d,null,true));
                digitalStorageArrayList.add(new UnitModel("MegaByte",8000000d,null,true));
                f=new RecyclerViewFragment(digitalStorageArrayList);
                onSectionAttached(position+1);
                fragmentManager.beginTransaction()
                        .replace(R.id.container,f)
                        .commit();
                break;
            case 4:
                energyArrayList.clear();
                energyArrayList.add(new UnitModel("Kilojoule (kJ)", 1000d, null, true));
                energyArrayList.add(new UnitModel("Joule (kJ)",1d,null,true));
                energyArrayList.add(new UnitModel("KiloWatt-Hour (kWh)",3600000d,null,true));
                energyArrayList.add(new UnitModel("Kilocalorie (kcal)",4184d,null,true));
                f=new RecyclerViewFragment(energyArrayList);
                onSectionAttached(position+1);
                fragmentManager.beginTransaction()
                        .replace(R.id.container,f)
                        .commit();
                break;
            case 5:
                forceArrayList.clear();
                forceArrayList.add(new UnitModel("Newton (N)",1d,null,true));
                forceArrayList.add(new UnitModel("Dyne (N)",0.00001d,null,true));
                forceArrayList.add(new UnitModel("Kilgram-Force (N)",9.80665d,null,true));
                f=new RecyclerViewFragment(forceArrayList);
                onSectionAttached(position+1);
                fragmentManager.beginTransaction()
                        .replace(R.id.container,f)
                        .commit();
                break;
            case 6:
                lengthArrayList.clear();
                lengthArrayList.add(new UnitModel("Kilometer (km)",1000.0d,null,true));
                lengthArrayList.add(new UnitModel("Metre (m)",1.0d,null,true));
                lengthArrayList.add(new UnitModel("Centimetre (cm)",0.01d,null,true));
                lengthArrayList.add(new UnitModel("Millimetre (cm)",0.001d,null,true));
                lengthArrayList.add(new UnitModel("Mile (mi)",1609.344d,null,true));
                lengthArrayList.add(new UnitModel("Yard (yd)",0.9144d,null,true));
                lengthArrayList.add(new UnitModel("Foot(ft)",0.3048d,null,true));
                lengthArrayList.add(new UnitModel("Inch(in)", 0.0254d,null,true));
                f=new RecyclerViewFragment(lengthArrayList);
                onSectionAttached(position+1);
                fragmentManager.beginTransaction()
                        .replace(R.id.container,f)
                        .commit();
                break;
            case 7:
                massArrayList.clear();
                massArrayList.add(new UnitModel("Metric Ton",1000d,null,true));
                massArrayList.add(new UnitModel("Kilogram (kg)",1d,null,true));
                massArrayList.add(new UnitModel("Gram (g)",0.001d,null,true));
                massArrayList.add(new UnitModel("Stone",6.350293d,null,true));
                massArrayList.add(new UnitModel("Ounce",0.02834952d,null,true));
                massArrayList.add(new UnitModel("Pound",0.4535924d,null,true));
                f=new RecyclerViewFragment(massArrayList);
                onSectionAttached(position+1);
                fragmentManager.beginTransaction()
                        .replace(R.id.container,f)
                        .commit();
                break;
            case 8:
                numberSystemArrayList.clear();
                numberSystemArrayList.add(new UnitModel("Decimal", 1, null, true));
                numberSystemArrayList.add(new UnitModel("Binary",1,null,true));
                numberSystemArrayList.add(new UnitModel("Octal",1,null,true));
                numberSystemArrayList.add(new UnitModel("Hexadecimal",1,null,true));
                f=new RecyclerViewFragment(numberSystemArrayList);
                onSectionAttached(position+1);
                fragmentManager.beginTransaction()
                        .replace(R.id.container,f)
                        .commit();
                break;
            case 9:
                powerArrayList.clear();
                powerArrayList.add(new UnitModel("Megawatt (MW)",1000000,null,true));
                powerArrayList.add(new UnitModel("Kilowatt (KW)",1000,null,true));
                powerArrayList.add(new UnitModel("Watt (W)",1,null,true));
                powerArrayList.add(new UnitModel("Horsepower (hp)",735.4987,null,true));
                f=new RecyclerViewFragment(powerArrayList);
                onSectionAttached(position+1);
                fragmentManager.beginTransaction()
                        .replace(R.id.container,f)
                        .commit();
                break;
            case 10:
                speedArrayList.clear();
                speedArrayList.add(new UnitModel("Mile/Hour (mph)",0.4470401,null,true));
                speedArrayList.add(new UnitModel("Feet/Second (fps)",0.3048,null,true));
                speedArrayList.add(new UnitModel("Metre/Second (mps)",1,null,true));
                speedArrayList.add(new UnitModel("Kilometre/Hour (mph)",0.27777,null,true));
                speedArrayList.add(new UnitModel("Knot",0.514444,null,true));
                f = new RecyclerViewFragment(speedArrayList);
                onSectionAttached(position+1);
                fragmentManager.beginTransaction().replace(R.id.container,f).commit();
                break;
            case 11:
                temperatureArrayList.clear();
                temperatureArrayList.add(new UnitModel("Celsius (C)",1,null,true));
                temperatureArrayList.add(new UnitModel("Fahrenheit (F)",1,null,true));
                temperatureArrayList.add(new UnitModel("Kelvin (K)",1,null,true));
                f = new RecyclerViewFragment(temperatureArrayList);
                onSectionAttached(position+1);
                fragmentManager.beginTransaction().replace(R.id.container,f).commit();
                break;
            case 12:
                timeArrayList.clear();
                timeArrayList.add(new UnitModel("Microsecond", 0.000001, null, true));
                timeArrayList.add(new UnitModel("Millisecond",0.001,null,true));
                timeArrayList.add(new UnitModel("Second",1,null,true));
                timeArrayList.add(new UnitModel("Minute",60,null,true));
                timeArrayList.add(new UnitModel("Hour",3600,null,true));
                timeArrayList.add(new UnitModel("Day",86400,null,true));
                f = new RecyclerViewFragment(timeArrayList);
                onSectionAttached(position+1);
                fragmentManager.beginTransaction().replace(R.id.container,f).commit();
                break;
            case 13:
                volumeArrayList.clear();
                f = new RecyclerViewFragment(volumeArrayList);
                onSectionAttached(position+1);
                fragmentManager.beginTransaction().replace(R.id.container,f).commit();
                break;
        }


    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.title_section1);
                mIcon = R.drawable.accel_icon;
                mRed=51;
                mGreen=25;
                mBlue=0;
                RecyclerViewFragment.mBlue=mBlue;
                RecyclerViewFragment.mBlue=mRed;
                RecyclerViewFragment.mBlue=mGreen;

                break;
            case 2:
                mTitle = getString(R.string.title_section2);
                mIcon = R.drawable.length_icon;
                mRed=153;
                mGreen=0;
                mBlue=153;
                RecyclerViewFragment.mBlue=mBlue;
                RecyclerViewFragment.mBlue=mRed;
                RecyclerViewFragment.mBlue=mGreen;
                break;
            case 3:
                mTitle = getString(R.string.title_section3);
                mIcon = R.drawable.currency_icon;
                mRed=153;
                mGreen=153;
                mBlue=0;
                RecyclerViewFragment.mBlue=mBlue;
                RecyclerViewFragment.mBlue=mRed;
                RecyclerViewFragment.mBlue=mGreen;
                break;
            case 4:
                mTitle = getString(R.string.title_section4);
                mIcon = R.drawable.digital_icon;
                mRed=51;
                mGreen=25;
                mBlue=0;
                RecyclerViewFragment.mBlue=mBlue;
                RecyclerViewFragment.mBlue=mRed;
                RecyclerViewFragment.mBlue=mGreen;
                break;
            case 5:
                mTitle = getString(R.string.title_section5);
                mIcon = R.drawable.energy_icon;
                mRed=204;
                mGreen=204;
                mBlue=0;
                RecyclerViewFragment.mBlue=mBlue;
                RecyclerViewFragment.mBlue=mRed;
                RecyclerViewFragment.mBlue=mGreen;
                break;
            case 6:
                mTitle = getString(R.string.title_section6);
                mIcon = R.drawable.force_icon;
                mRed=204;
                mGreen=229;
                mBlue=255;
                RecyclerViewFragment.mBlue=mBlue;
                RecyclerViewFragment.mBlue=mRed;
                RecyclerViewFragment.mBlue=mGreen;
                break;
            case 7:
                mTitle = getString(R.string.title_section7);
                mIcon = R.drawable.length2_icon;
                mRed=0;
                mGreen=153;
                mBlue=153;
                RecyclerViewFragment.mBlue=mBlue;
                RecyclerViewFragment.mBlue=mRed;
                RecyclerViewFragment.mBlue=mGreen;
                break;
            case 8:
                mTitle = getString(R.string.title_section8);
                mIcon = R.drawable.mass_icon;
                mRed=255;
                mGreen=69;
                mBlue=0;
                RecyclerViewFragment.mBlue=mBlue;
                RecyclerViewFragment.mBlue=mRed;
                RecyclerViewFragment.mBlue=mGreen;
                break;
            case 9:
                mTitle = getString(R.string.title_section9);
                mIcon = R.drawable.number_system_icon;
                mRed=32;
                mGreen=178;
                mBlue=170;
                RecyclerViewFragment.mBlue=mBlue;
                RecyclerViewFragment.mBlue=mRed;
                RecyclerViewFragment.mBlue=mGreen;
                break;
            case 10:
                mTitle = getString(R.string.title_section10);
                mIcon = R.drawable.power_icon;
                mRed=255;
                mGreen=165;
                mBlue=0;
                RecyclerViewFragment.mBlue=mBlue;
                RecyclerViewFragment.mBlue=mRed;
                RecyclerViewFragment.mBlue=mGreen;
                break;
            case 11:
                mTitle = getString(R.string.title_section11);
                mIcon = R.drawable.speed_icon;
                mRed=154;
                mGreen=205;
                mBlue=50;
                RecyclerViewFragment.mBlue=mBlue;
                RecyclerViewFragment.mBlue=mRed;
                RecyclerViewFragment.mBlue=mGreen;
                break;
            case 12:
                mTitle = getString(R.string.title_section12);
                mIcon = R.drawable.temp_icon;
                mRed=255;
                mGreen=0;
                mBlue=0;
                RecyclerViewFragment.mBlue=mBlue;
                RecyclerViewFragment.mBlue=mRed;
                RecyclerViewFragment.mBlue=mGreen;
                break;
            case 13:
                mTitle = getString(R.string.title_section13);
                mIcon = R.drawable.time_icon;
                mRed=205;
                mGreen=133;
                mBlue=63;
                RecyclerViewFragment.mBlue=mBlue;
                RecyclerViewFragment.mBlue=mRed;
                RecyclerViewFragment.mBlue=mGreen;
                break;
            case 14:
                mTitle = getString(R.string.title_section14);
                mIcon = R.drawable.volume_icon;
                mRed=51;
                mGreen=51;
                mBlue=255;
                RecyclerViewFragment.mBlue=mBlue;
                RecyclerViewFragment.mBlue=mRed;
                RecyclerViewFragment.mBlue=mGreen;
                break;

        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        Log.d("DashboardActivity->", "" + mTitle);
        actionBar.setTitle(mTitle);
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.rgb(mRed, mGreen, mBlue)));
        actionBar.setIcon(mIcon);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.dashboard, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            /*Intent intent = new Intent(DashboardActivity.this, ContactActivity.class);
    *//*Here ActivityA is current Activity and ColourActivity is the target Activity.*//*
            startActivity(intent);*/
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";


        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            Log.d("Dashboard", "" + sectionNumber);
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;

        }

        public PlaceholderFragment() {
        }



        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
           final View rootView = inflater.inflate(R.layout.fragment_dashboard, container, false);

            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((DashboardActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));

        }
    }

}
