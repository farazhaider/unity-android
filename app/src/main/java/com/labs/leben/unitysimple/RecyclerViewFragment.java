package com.labs.leben.unitysimple;


import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RecyclerViewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecyclerViewFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private  ArrayList<UnitModel> infoArrayList = new ArrayList<UnitModel>();



    private UnitAdapter mUnitAdapter;

    public static final String ARG_SECTION_NUMBER = "section_number";
    public static int mRed,mGreen,mBlue;



    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RecyclerViewFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RecyclerViewFragment newInstance(String param1, String param2) {
        RecyclerViewFragment fragment = new RecyclerViewFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public RecyclerViewFragment() {
        // Required empty public constructor
    }
    // Not an error only a warning
    public RecyclerViewFragment(ArrayList<UnitModel> infoArrayList) {
        // Required empty public constructor
        this.infoArrayList=infoArrayList;

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
        final View view= inflater.inflate(R.layout.fragment_recycler_view, container, false);

        FloatingActionButton fabButton = new FloatingActionButton.Builder(getActivity())
                .withDrawable(getResources().getDrawable(R.drawable.ic_action_add2))
                .withButtonColor(Color.GRAY)
                .withGravity(Gravity.BOTTOM | Gravity.RIGHT)
                .withMargins(0, 0, 16, 16)
                .create();
        final ListView listView = (ListView) view.findViewById(R.id.cardList);

        mUnitAdapter = new UnitAdapter(infoArrayList);
        listView.setAdapter(mUnitAdapter);

        fabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    for(UnitModel x:infoArrayList){
                        x.textfield=null;
                    }
                mUnitAdapter.notifyDataSetChanged();
            }
        });

        return view;
    }


    public void requestContent() throws IOException, JSONException {
        Log.d("RecyclerViewFragment", "Inside requestContent");
        String url = "http://openexchangerates.org/api/latest.json?app_id=8e998b80f9d84e01bacdb2aa0c3defb7";
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                Log.d("RecyclerViewFragment", "Response Failure");
            }

            @Override
            public void onResponse(Response response) throws IOException {
                //checkIfTaskDone = false;
                Log.d("RecylerViewFragment", "Response Successful");
                String str = response.body().string();
                try {
                    JSONObject content_json = new JSONObject(str);
                    JSONObject content_json_object = content_json.getJSONObject("rates");
                    content_json_object.get("AED");
                    content_json_object.get("EUR");
                    content_json_object.get("INR");
                    content_json_object.get("GBP");
                } catch (JSONException e) {
                    Log.d("RecyclerViewFragment", "exception");
                }
            }
        });
    }
}
