package com.haha.week1;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class MyActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
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

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_my, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
    }

    public static class FragmentA extends Fragment {

        ListView listView;
        JSONArray jsonArray;

        static final String TAG_NAME = "NAME";
        static final String TAG_ADDRESS = "ADDRESS";

        String line =
                "{{\"name\":\"배트맨\",\"address\":\"고담\"},"+
                        "{\"name\":\"슈퍼맨\",\"address\":\"뉴욕\"},"+
                        "{\"name\":\"앤트맨\",\"address\":\"LA\"}}";

        String[] data = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S"};

        ArrayList<HashMap<String, String>> oslist = new ArrayList<HashMap<String, String>>();

        public FragmentA() {
        }

        public static FragmentA newInstance() {
            FragmentA fragment = new FragmentA();
            Bundle args = new Bundle();
            fragment.setArguments(args);
            return fragment;
        }

        public void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            /*try {
                jsonArray = new JSONArray(line);

                for (int i = 0; i < jsonArray.length(); i++) {

                    JSONObject c = jsonArray.getJSONObject(i);

                    // Storing  JSON item in a Variable
                    String name = c.getString(TAG_NAME);
                    String address = c.getString(TAG_ADDRESS);

                    // Adding value HashMap key => value
                    HashMap<String, String> map = new HashMap<String, String>();
                    map.put(TAG_NAME, name);
                    map.put(TAG_ADDRESS, address);

                    oslist.add(map);
                }

            } catch (JSONException e) {;}
            */

        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
            View view = inflater.inflate(R.layout.fragment_a, container, false);
            listView = (ListView) view.findViewById(R.id.listView1);
            SimpleAdapter adapter = new SimpleAdapter(getContext(), oslist, android.R.layout.simple_list_item_1,
                    new String[]{"name", "address"}, new int[]{android.R.id.text1, android.R.id.text2});
            ArrayAdapter<String> original = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, data);
            listView.setAdapter(original);
            return view;
        }
    }


    public static class FragmentB extends Fragment {

        public FragmentB() {
        }

        public static FragmentB newInstance() {
            FragmentB fragment = new FragmentB();
            Bundle args = new Bundle();
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_b, container, false);
            GridView myGrid = (GridView) rootView.findViewById(R.id.gridview1);
            myGrid.setAdapter(new ImageAdapter(getActivity()));
            return rootView;
        }
    }

    public static class FragmentC extends Fragment {

        public FragmentC() {
        }

        public static FragmentC newInstance() {
            FragmentC fragment = new FragmentC();
            Bundle args = new Bundle();
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_c, container, false);
            /*
            Implement what to do here for our Tab C...
             */
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            switch(position){
                case 0: return  FragmentA.newInstance();
                case 1: return  FragmentB.newInstance();
                case 2: return  FragmentC.newInstance();
                default: return FragmentA.newInstance();
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "A";
                case 1:
                    return "B";
                case 2:
                    return "C";
            }
            return null;
        }
    }
}
