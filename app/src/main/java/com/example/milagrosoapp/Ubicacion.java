package com.example.milagrosoapp;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.VolleyError;
import com.example.milagrosoapp.databinding.ActivityUbicacionBinding;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;



public class Ubicacion extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityUbicacionBinding binding;
    private static final int REQUEST_CODE_LOCATION_PERMISSION = 1;
    private FusedLocationProviderClient fusedLocationClient;

    private Button btnDibujarRuta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUbicacionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        // Obtener el SupportMapFragment y notificar cuando el mapa esté listo para ser utilizado
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        btnDibujarRuta = findViewById(R.id.btnDibujarRuta);

        // Agregar un OnClickListener al botón de dibujar ruta
        btnDibujarRuta.setOnClickListener(view -> onSendMaps());
    }

    /** * Manipula el mapa una vez que esté disponible. * Este callback se activa cuando el mapa está listo para ser utilizado. * Aquí es donde podemos agregar marcadores o líneas, agregar oyentes o mover la cámara. * Si Google Play services no está instalado en el dispositivo, se le pedirá al usuario que lo instale * dentro del SupportMapFragment. Este método solo se activará una vez que el usuario haya * instalado Google Play services y haya regresado a la aplicación. */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // coordenadas de Bogotá
        LatLng bogota = new LatLng(4.641258981363604, -74.10998263884213);

        // Mueve la cámara a la ubicación de Bogotá con un nivel de zoom
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(bogota, 12f));

        // Habilitar la ubicación del usuario en el mapa
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, REQUEST_CODE_LOCATION_PERMISSION);
            return;
        }
        mMap.setMyLocationEnabled(true);

        // Agregar un marcador en la ubicación de destino
        LatLng hospitalMilagroso = new LatLng(4.641258981363604, -74.10998263884213);
        mMap.addMarker(new MarkerOptions().position(hospitalMilagroso).title("Hospital Milagroso"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(hospitalMilagroso));
    }

    public void onSendMaps(){

        //Latitud: 4.7009744
        //Longitud: -74.1708576


        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https")
                .authority("www.google.com")
                .appendPath("maps")
                .appendPath("dir")
                .appendPath("")
                .appendQueryParameter("api", "1")
                .appendQueryParameter("destination",   "4.641258981363604 , -74.10998263884213");
        String url = builder.build().toString();
        Log.d("Directions", url);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    // Función para el botón de emergencia
    public void botonEmergencia(View view) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, REQUEST_CODE_LOCATION_PERMISSION);
            return;
        }

        fusedLocationClient.getLastLocation().addOnSuccessListener(this, location -> {
            if (location != null) {
                double latitud = location.getLatitude();
                double longitud = location.getLongitude();

                Intent intent = new Intent(Ubicacion.this, Emergency.class);
                intent.putExtra("latitud", latitud);
                intent.putExtra("longitud", longitud);
                startActivity(intent);
            }
        });
    }

}
