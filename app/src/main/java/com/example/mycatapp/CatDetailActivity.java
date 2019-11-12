package com.example.mycatapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.ViewTarget;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.security.AccessController.getContext;

public class CatDetailActivity extends AppCompatActivity {
     TextView nameTextView;
    TextView dogTextView;
    TextView temperTextview;
    TextView originTextView;
    TextView lifespanTextView;
    TextView linkTextView;
    TextView descriptionTextView;
    ImageView catImageView;
    Button button;
    String catImageUrl="";
    Breeds tempCat;
    CatDetailActivity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cat_detail);

        nameTextView = findViewById(R.id.name);
        dogTextView = findViewById(R.id.dog_friendly);
        temperTextview = findViewById(R.id.temper);
        originTextView = findViewById(R.id.origin);
        linkTextView = findViewById(R.id.link);
        lifespanTextView = findViewById(R.id.lifespan);
        descriptionTextView = findViewById(R.id.description);
        catImageView = findViewById(R.id.photo);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        final CatDatabase db = CatDatabase.getInstance(this);
        Cat cat = db.catDao().findCatByName(name);
        System.out.println(cat.getName());

        nameTextView.setText(cat.getName());
        dogTextView.setText(cat.getDog_friendly());
        temperTextview.setText(cat.getTemperament());
        originTextView.setText(cat.getOrigin());
        linkTextView.setText(cat.getWikipedia_url());
        lifespanTextView.setText(cat.getLife_span());
        descriptionTextView.setText(cat.getDescription());

        String imageUrl = cat.getUrl();


//        final RequestQueue requestQueue =  Volley.newRequestQueue(getApplicationContext());

        final String catID = intent.getStringExtra("id");
        final String searchUrl = "https://api.thecatapi.com/v1/images/search?breed_id=" + catID;

//        StringRequest stringRequest = new StringRequest(Request.Method.GET, searchUrl,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        Gson gson = new Gson();
//                        String apiText = response.toString();
//                        System.out.println("Cat ID is:" + catID);
//                        System.out.println("Cat Response: " + apiText);
//                        CatImage[] catImageObj = gson.fromJson(apiText, CatImage[].class);
//
//                        if (catImageObj.length != 0) {
//                            catImageUrl = catImageObj[0].getUrl();
//                            Breeds[] catBreeds = catImageObj[0].getBreeds();
//                            tempCat = catBreeds[0];
//                           Glide.with(activity).load(catImageUrl).into(catImageView);
//                        } else {
//                            System.out.println("API TEXT RETURNED NOTHING");
//
//                        }
//
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.d("NO BUENO", error.toString());
//              }
//        }
//        ) {
//            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//                Map<String, String> headers = new HashMap<String, String>();
//                headers.put("x-api-key", "e11cbe67-4e8f-4f95-85e6-c634fc9582b5");
//                return headers;
//            }
//        };
//
//
//        requestQueue.add(stringRequest);



}

}
