package com.github.teste.testegithub.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;
import com.github.teste.testegithub.R;
import com.github.teste.testegithub.fragments.RepositoryFragment;
import com.github.teste.testegithub.model.Repository;
import com.novoda.merlin.MerlinsBeard;

public class MainActivity extends AppCompatActivity {
    private FragmentManager mFragmentManager;

    public static void openDetailsRepository(Context context, Repository repository) {
        if (MerlinsBeard.from(context).isConnected()) {
            Intent intent = new Intent(context, PullRequestActivity.class);
            intent.putExtra("repository", repository);
            context.startActivity(intent);
        }
        else {
            makeToast(context, context.getResources().getString(R.string.network_unavailable_message));
        }
    }

    private static void makeToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.setTitle(getResources().getString(R.string.title_main_activity));

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        mFragmentManager = getSupportFragmentManager();
        loadInitialFragment();
    }

    private void loadInitialFragment() {
        Fragment initialFragment = RepositoryFragment.newInstance();
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, initialFragment);
        fragmentTransaction.commit();
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
}