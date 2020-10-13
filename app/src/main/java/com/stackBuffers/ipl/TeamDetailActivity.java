package com.stackBuffers.ipl;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;
import com.stackBuffers.ipl.Adapters.TeamDetailAdapter;
import com.stackBuffers.ipl.Models.TeamDetailModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TeamDetailActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    Context context;
    List<TeamDetailModel> list;
    Toolbar mToolBar;
    String id,image;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_detail);
        id=getIntent().getStringExtra("id");
        image=getIntent().getStringExtra("image");
        initViews();
        setRecycler();
    }
    protected void initViews()
    {
        context=this;
        mToolBar = findViewById(R.id.toolbar_td);
        imageView=findViewById(R.id.teamDetail_img);
        setSupportActionBar(mToolBar);
        getSupportActionBar().setTitle("Team Detail");
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        } else {
            getActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getActionBar().setHomeButtonEnabled(true);
        }

        recyclerView=findViewById(R.id.recycler_teamDetail);
        linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        Picasso.with(context).load(image).placeholder(R.drawable.cricket).into(imageView);
        list=new ArrayList<>();
    }
    private void setRecycler() {
        final ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Please Wait");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();

        StringRequest stringRequest=new StringRequest(Request.Method.GET, URLHelper.GET_TEAM_DETAIL+id, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();
                try {
                    JSONObject object;
                    JSONObject jsonObject=new JSONObject(response);
                    boolean Status=jsonObject.getBoolean("status");
                    JSONArray jsonArray=jsonObject.getJSONArray("data");
                    for (int i=0; i<jsonArray.length(); i++)
                    {
                        object=jsonArray.getJSONObject(i);
                        list.add(new TeamDetailModel(object.getString("player_name"),object.getString("is_foreign"),object.getString("type")));
                    }
                    TeamDetailAdapter adapter=new TeamDetailAdapter(list,context);
                    recyclerView.setAdapter(adapter);
                }
                catch (JSONException e)
                {

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                setRecycler();
            }
        });
        Volley.newRequestQueue(context).add(stringRequest);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
