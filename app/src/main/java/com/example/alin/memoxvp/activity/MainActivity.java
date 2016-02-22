package com.example.alin.memoxvp.activity;

import android.app.ActivityOptions;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.alin.memoxvp.POJOs.RecyclerItem;
import com.example.alin.memoxvp.R;
import com.example.alin.memoxvp.Utils.DialogActivity;
import com.example.alin.memoxvp.Utils.MagicFAB;
import com.example.alin.memoxvp.adapter.MainRecycleViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ProgressDialog progressDialog = null;
    private List<RecyclerItem> feedsList;
    private RecyclerView mRecyclerView;
    private MainRecycleViewAdapter adapter;
    MagicFAB magicFAB;
    private int RC_LOGIN = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_main);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        adapter = new MainRecycleViewAdapter(createList(0));
        mRecyclerView.setAdapter(adapter);

//        magicFAB = (MagicFAB) findViewById(R.id.magic_fab);
//        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
//        magicFAB.setIntent(intent);
//        magicFAB.setOnClickListener(new MagicFAB.OnClickListener(){
//
//            @Override
//            public void onClick(MagicFAB magicFAB, View v) {
//                magicFAB.activityAnimation();
//            }
//        });


        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_morph);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DialogActivity.class);
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, fab, getString(R.string.transition_dialog));
                startActivityForResult(intent, RC_LOGIN, options.toBundle());
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
       // magicFAB.onResume();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_HOME) {
            startActivity(new Intent(this, MainActivity.class));
        } else if (id == R.id.nav_about) {
            startActivity(new Intent(this, AboutActivity.class));
        } else if (id == R.id.nav_prices) {
            startActivity(new Intent(this, ResultActivity.class));
        }
        else if (id == R.id.nav_clients) {
            startActivity(new Intent(this, CustomersActivity.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private List<RecyclerItem> createList(int size) {

        List<RecyclerItem> result = new ArrayList<RecyclerItem>();
        for (int i = 0; i <= size; i++) {
            RecyclerItem item = new RecyclerItem();
            item.setThumbnail(R.drawable.app_memox);
            item.setText("Aplicația MemoX VP a fost concepută pentru a ușura activitatea persoanelor care activează în domeniul\n" +
                    "        financiar contabil și nu numai.");


            result.add(item);
        }

        return result;
    }


}
