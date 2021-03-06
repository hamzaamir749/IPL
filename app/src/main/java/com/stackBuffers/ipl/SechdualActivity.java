package com.stackBuffers.ipl;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.stackBuffers.ipl.Adapters.ScheduleAdapter;
import com.stackBuffers.ipl.Models.SechduleModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SechdualActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    Context context;
    List<SechduleModel> list;
    Toolbar mToolBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sechdual);
        initViews();
        setRecycler();
    }

    protected void initViews()
    {
        context=this;
        mToolBar = findViewById(R.id.toolbar_schedule);
        setSupportActionBar(mToolBar);
        getSupportActionBar().setTitle("Schedule");
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        } else {
            getActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getActionBar().setHomeButtonEnabled(true);
        }

        recyclerView=findViewById(R.id.recyclerview_schedule);
        linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        list=new ArrayList<>();
    }
    private void setRecycler() {
        final ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Please Wait");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();

        StringRequest stringRequest=new StringRequest(Request.Method.GET, URLHelper.GET_SCHEDULE, new Response.Listener<String>() {
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
                        list.add(new SechduleModel(object.getString("match_no"),object.getString("team_a"),object.getString("team_b"),object.getString("date"),object.getString("ground"),object.getString("time")));
                    }
                    ScheduleAdapter adapter=new ScheduleAdapter(list,context);
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
