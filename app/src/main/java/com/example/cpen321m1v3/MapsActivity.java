package com.example.cpen321m1v3;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.collections.GroundOverlayManager;
import com.google.maps.android.collections.MarkerManager;
import com.google.maps.android.collections.PolygonManager;
import com.google.maps.android.collections.PolylineManager;
import com.google.maps.android.data.geojson.GeoJsonLayer;
import com.google.maps.android.data.geojson.GeoJsonPolygonStyle;

import org.json.JSONException;

import java.io.IOException;
import java.util.Objects;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback{

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }



    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @SuppressLint("PotentialBehaviorOverride")
    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        mMap.getUiSettings().setZoomControlsEnabled(true);

//        MarkerManager markerManager = new MarkerManager(mMap);
//        GroundOverlayManager groundOverlayManager = new GroundOverlayManager(mMap);
//        PolygonManager polygonManager = new PolygonManager(mMap);
//        PolylineManager polylineManager = new PolylineManager(mMap);
//        // GeoJSON polygon
//
//        try {
//            //GeoJsonLayer layer = new GeoJsonLayer(mMap, R.raw.customgeo, getApplicationContext());
//            GeoJsonLayer layer = new GeoJsonLayer(mMap, R.raw.customgeo, this, markerManager, polygonManager, polylineManager, groundOverlayManager);
//
//            GeoJsonPolygonStyle style = layer.getDefaultPolygonStyle();
//            style.setFillColor(Color.MAGENTA);
//            style.setStrokeColor(Color.MAGENTA);
//            style.setStrokeWidth(1F);
//
//            layer.addLayerToMap();
//
//        } catch (IOException ex) {
//            Log.e("IOException", ex.getLocalizedMessage());
//        } catch (JSONException ex) {
//            Log.e("JSONException", ex.getLocalizedMessage());
//        }

        LatLng USA = new LatLng(37, -95);
        LatLng Russia = new LatLng(61.5, 105.3);
        LatLng Iran = new LatLng(32.4, 53.7);
        LatLng Canada = new LatLng(56, -106.3);
        LatLng Qatar = new LatLng(25.4, 51.2);
        LatLng China = new LatLng(35.9, 104.2);
        LatLng Norway = new LatLng(60.5, 8.5);
        LatLng Australia = new LatLng(-25.3, 133.8);
        LatLng SaudiArabia = new LatLng(23.9, 45.1);
        LatLng Algeria = new LatLng(28, 1.7);

        String USAInfo = "The USA is the world's leading country in the production of fossil fuels, primarily oil and natural gas. "
                + "It's highest producing state is Texas, who have a large collection of oil wells.";
        String RussiaInfo = "Russia is the largest source of fossil fuels for Europe, largely due to it's large area and subsequent access to a vast array of natural resources."
                + "Much of Europe is dependent upon Russia for their energy usage, which has recently become an issue due to the advent of Russia's invasion of Ukraine";
        String IranInfo = "Iran is the world's largest producer of natural gas, and also has large oil reserves."
                + "Iran is extremely dependent on their fossil fuel production, as 50% of their state revenue comes from oil exports.";
        String CanadaInfo = "Fossil fuels are a large part of the Canadian economy, being one of the major international oil suppliers."
                + "However, 60% of Canada's energy consumption comes from Hydropower, and an additional 15% comes from Nuclear.";
        String QatarInfo = "Despite being a relatively small country, Qatar is one of the biggest producers of fossil fuel in the world, due to large supplies of oil and natural gas."
                + "In fact, Qatar has the highest GDP per capita in the world, with an average of over 60,000 USD.";
        String ChinaInfo = "With the largest population of any country, it is no surprise that China is a large producer of fossil fuels, mainly in the form of coal."
                + "Currently, over 50% of China's energy consumption comes from the use of coal power plants, however they have set the target of being completely carbon neutral by 2060.";
        String NorwayInfo = "Norway is one of the largest producers of fossil fuels in Europe, largely stemming from oil drilling taking place in the North Sea."
                + "However, Norway is considered a model for responsible management of fossil fuel resources, and was the first country to spearhead an industrial scale carbon capture and storage project.";
        String AustraliaInfo = "Australia is one of the world's leading producers and users of coal, primarily due to the large expanse and access to natural resources."
                + "In fact, in 2009 Australia had the highest per capita CO2 emissions of any country.";
        String SaudiArabiaInfo = "Saudi Arabia has one of the highest GDP per capita in the world, largely due to it's oil exports, which account for up to 75% of government revenue."
                + "They are home to the Ghawar oil field, which is the largest oil field in the world with reserves of up to 11 billions m^3";
        String AlgeriaInfo = "Algeria is home to large oil and natural gas reserves, which is a large source of their financial exports."
                + "Despite this, there are serious plans in place to invest in solar energy, as they have the highest potential of solar energy in the MENA region.";

        mMap.addMarker(new MarkerOptions().position(USA).draggable(true).title("USA").snippet(USAInfo));
        mMap.addMarker(new MarkerOptions().position(Russia).visible(true).title("Russia").snippet(RussiaInfo));
        mMap.addMarker(new MarkerOptions().position(Iran).visible(true).title("Iran").snippet(IranInfo));
        mMap.addMarker(new MarkerOptions().position(Canada).visible(true).title("Canada").snippet(CanadaInfo));
        mMap.addMarker(new MarkerOptions().position(Qatar).visible(true).title("Qatar").snippet(QatarInfo));
        mMap.addMarker(new MarkerOptions().position(China).visible(true).title("China").snippet(ChinaInfo));
        mMap.addMarker(new MarkerOptions().position(Norway).visible(true).title("Norway").snippet(NorwayInfo));
        mMap.addMarker(new MarkerOptions().position(Australia).visible(true).title("Australia").snippet(AustraliaInfo));
        mMap.addMarker(new MarkerOptions().position(SaudiArabia).visible(true).title("Saudi Arabia").snippet(SaudiArabiaInfo));
        mMap.addMarker(new MarkerOptions().position(Algeria).visible(true).title("Algeria").snippet(AlgeriaInfo));

        mMap.setInfoWindowAdapter(new CustomInfoWindowAdapter(this));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(USA));
    }
}