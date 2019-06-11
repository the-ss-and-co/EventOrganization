package com.Myproject.myapp.fragments;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.Myproject.myapp.Adapter.PlaceAutocompleteAdapter;
import com.Myproject.myapp.R;
import com.Myproject.myapp.Util.LocationPermission;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlaceBuffer;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.tasks.OnSuccessListener;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class GetLocationFragment extends Fragment implements
        GoogleApiClient.OnConnectionFailedListener,
        GoogleApiClient.ConnectionCallbacks,View.OnClickListener, OnSuccessListener<Location> {
    AutoCompleteTextView autoCompleteTextView;
    PlaceAutocompleteAdapter mPlaceArrayAdapter;
    private static final String LOG_TAG = "GetLocationFragment";
    private static final int GOOGLE_API_CLIENT_ID = 0;
    private GoogleApiClient mGoogleApiClient;
    public static final LatLngBounds BOUNDS_INDIA = new LatLngBounds(new LatLng(7.798000, 68.14712), new LatLng(37.090000, 97.34466));
    TextView getlocation;
    RelativeLayout btn_save;
    ProgressDialog progressDialog;
    String city,state,postalCode,address,type="";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_getlocation,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
Bundle bundle=new Bundle();
bundle=getArguments();
if(bundle!=null){
    type=bundle.getString("type");
}else {
    type="no";
}
        mGoogleApiClient = new GoogleApiClient.Builder(getContext())
                .addApi(Places.GEO_DATA_API)
                .enableAutoManage(getActivity(), GOOGLE_API_CLIENT_ID, this)
                .addConnectionCallbacks(this)
                .build();
        initview(view);

    }

    private void initview(View view){
        btn_save=view.findViewById(R.id.btn_save);
        getlocation=view.findViewById(R.id.getlocation);
        autoCompleteTextView=view.findViewById(R.id.autoCompleteTextView);
        autoCompleteTextView.setThreshold(3);
        autoCompleteTextView.setOnItemClickListener(onItemClickListener);
        mPlaceArrayAdapter = new PlaceAutocompleteAdapter(getContext(), android.R.layout.simple_list_item_1,
                BOUNDS_INDIA, null);
        autoCompleteTextView.setAdapter(mPlaceArrayAdapter);
        btn_save.setOnClickListener(this);
        getlocation.setOnClickListener(this);
        progressDialog=new ProgressDialog(getContext());
        progressDialog.setMessage("Loading...");
        progressDialog.setCanceledOnTouchOutside(false);
    }
    private AdapterView.OnItemClickListener onItemClickListener=new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            final PlaceAutocompleteAdapter.PlaceAutocomplete item = mPlaceArrayAdapter.getItem(position);
            final String placeId = String.valueOf(item.placeId);
            PendingResult<PlaceBuffer> placeResult = Places.GeoDataApi
                    .getPlaceById(mGoogleApiClient, placeId);
             placeResult.setResultCallback(mUpdatePlaceDetailsCallback);
            Log.i(LOG_TAG, "Fetching details for ID: " + item.placeId);
        }
    };

    private ResultCallback<PlaceBuffer> mUpdatePlaceDetailsCallback
            = new ResultCallback<PlaceBuffer>(){
        @Override
        public void onResult(PlaceBuffer places) {
            if (!places.getStatus().isSuccess()) {
                Log.e(LOG_TAG, "Place query did not complete. Error: " +
                        places.getStatus().toString());
                return;
            }
            // Selecting the first object buffer.
            final Place place = places.get(0);
            CharSequence attributions = places.getAttributions();
LatLng latLng=place.getLatLng();
generateAddress(latLng);

        }
    };



    @Override
    public void onConnected(@Nullable Bundle bundle) {
        mPlaceArrayAdapter.setGoogleApiClient(mGoogleApiClient);

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onPause() {
        super.onPause();
        mGoogleApiClient.stopAutoManage(getActivity());
        mGoogleApiClient.disconnect();

    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch (id){
            case R.id.getlocation:
                new LocationPermission(getContext(),getActivity(),this).checkPermission();

                getmycurrentlocation();
                break;
            case R.id.btn_save:
                if(!autoCompleteTextView.getText().toString().isEmpty()){
                        replace(new LocationAdress(),type); }
                        else {
                replace(new LocationAdress2(),type);
                }
                break;
        }

    }



    private void getmycurrentlocation(){
        FusedLocationProviderClient fusedLocationProviderClient;
        LocationPermission locationPermission=new LocationPermission(getContext(),getActivity(),this);

        if(!locationPermission.checkGPSAndNetwork()){
            locationPermission.enableLocation();
            return;
        }
        if(locationPermission.checkPlayServices()){
            fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(getContext());
            if (ActivityCompat.checkSelfPermission(getActivity().getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity().getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                Toast.makeText(getContext(), "Please Enable location permission", Toast.LENGTH_SHORT).show();

                return;
            }
            fusedLocationProviderClient.getLastLocation().addOnSuccessListener(this);
        } else {
            Toast.makeText(getContext(), "Eror occured check your location permission", Toast.LENGTH_SHORT).show();
        }

    }

    private void replace(Fragment fg,String type){

Bundle bundle=new Bundle();
bundle.putString("city",city);
bundle.putString("state",state);
bundle.putString("postalCode",postalCode);
bundle.putString("address",address);
bundle.putString("type",type);
fg.setArguments(bundle);
        String backStateName = fg.getClass().getName();
        boolean fragmentPopped = getFragmentManager().popBackStackImmediate(backStateName,0);
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if (!fragmentPopped) {
            ft.replace(R.id.location_contaner, fg);
            ft.addToBackStack(backStateName);
            ft.commit();
        }
    }

    private void generateAddress(LatLng latLng) {
new GetAddressAsync(latLng,getContext(),"manual").execute();

    }

    @Override
    public void onSuccess(Location location) {
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        new GetAddressAsync(latLng,getContext(),"auto").execute();
    }

    private class GetAddressAsync extends AsyncTask<Void, Void, String> {

        private LatLng latLng;
        private Context context;
        String ty;
        public GetAddressAsync(LatLng latLng, Context context,String type) {
            this.latLng = latLng;
            this.context = context;
            ty=type;

        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.show();
        }
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            progressDialog.dismiss();
if(ty.equalsIgnoreCase("auto")){
    address=s;
    getlocation.setText(s);
}
        }

        @Override
        protected String doInBackground(Void... voids){
            Geocoder geocoder;
            List<Address> addresses;
            geocoder = new Geocoder(context, Locale.getDefault());

            String loc = "Address Not Available";

            try {
                addresses = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1); // Here 1 represent max location result to returned, by documents it recommended 1 to 5
                if (addresses != null && addresses.size() > 0) {
                    String address = addresses.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
                     city = addresses.get(0).getLocality();
                     state = addresses.get(0).getAdminArea();
                    String country = addresses.get(0).getCountryName();
                     postalCode = addresses.get(0).getPostalCode();
                    String knownName = addresses.get(0).getFeatureName(); // Only if available else return NULL

                    loc = address;

                }
            } catch (IOException e){
                e.printStackTrace();
            }
            return loc;
        }
    }

}