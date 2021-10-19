package com.example.raul.myapplication_tesis_2.ui;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.raul.myapplication_tesis_2.R;
import com.example.raul.myapplication_tesis_2.ui.fragment.AlimentacionFragment;
import com.example.raul.myapplication_tesis_2.ui.fragment.EstanqueFragment;
import com.example.raul.myapplication_tesis_2.ui.fragment.GranjaFragment;
import com.example.raul.myapplication_tesis_2.ui.fragment.IFragments;
import com.example.raul.myapplication_tesis_2.ui.fragment.MainFragment;
import com.example.raul.myapplication_tesis_2.ui.fragment.SiembraFragment;
import com.example.raul.myapplication_tesis_2.ui.fragment.UEBFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, IFragments {

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

        Fragment miFragment = new MainFragment();
        getSupportActionBar().setTitle(getString(R.string.home));
        getSupportFragmentManager().beginTransaction().replace(R.id.content_main, miFragment).commit();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        Fragment myFragment = null;
        boolean fragmentSelected = false;
        String title = "";

        // AQUI ES LA LOGICA PARA ASIGNR FRAGMENTS
        if (id == R.id.nav_home) {
            myFragment = MainFragment.newInstance();
            fragmentSelected = true;
            title = getString(R.string.home);
        } else if (id == R.id.nav_ueb){
            myFragment = UEBFragment.newInstance();
            fragmentSelected = true;
            title = getString(R.string.ueb);
        } else if (id == R.id.nav_siembra){
            myFragment = SiembraFragment.newInstance();
            fragmentSelected = true;
            title = getString(R.string.siembra);
        } else if (id == R.id.nav_estanque) {
            myFragment = EstanqueFragment.newInstance();
            fragmentSelected = true;
            title = getString(R.string.estanque);
        }else if (id == R.id.nav_alimentacion) {
            myFragment = AlimentacionFragment.newInstance();
            fragmentSelected = true;
            title = getString(R.string.alimentacion);
        }else if (id == R.id.nav_granja) {
            myFragment = GranjaFragment.newInstance();
            fragmentSelected = true;
            title = getString(R.string.granja);
        }

        if (fragmentSelected) {
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main, myFragment).commit();
            getSupportActionBar().setTitle(title);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        // do nothing
    }
}
