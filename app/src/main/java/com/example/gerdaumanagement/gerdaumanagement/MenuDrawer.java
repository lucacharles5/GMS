package com.example.gerdaumanagement.gerdaumanagement;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MenuDrawer extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private TextView nomeUser;
    private TextView cargoUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        menuTec menuTec = new menuTec();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.content,menuTec, menuTec.getTag()).commit();


        View hView =  navigationView.getHeaderView(0);

       nomeUser = (TextView) hView.findViewById(R.id.nomeFuncAlterar);
        cargoUser = (TextView) hView.findViewById(R.id.cargoFuncAlterar);

        Intent intent = getIntent();

            if(intent != null) {
                String nome = intent.getStringExtra("chave1");
                String cargo = intent.getStringExtra("chave2");

                nomeUser.setText(nome);
                cargoUser.setText(cargo);
            }
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
        getMenuInflater().inflate(R.menu.menu_drawer, menu);
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

        if (id == R.id.home) {
            menuTec menuTec = new menuTec();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.content,menuTec, menuTec.getTag()).addToBackStack(null).commit();

        } else if (id == R.id.perfil) {

        } else if (id == R.id.save) {

        } else if (id == R.id.report) {

        } else if (id == R.id.exit) {


        }else if (id == R.id.usuario) {
            usuario usuario = new usuario();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.content,usuario, usuario.getTag()).addToBackStack(null).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



    //Alterar o titulo da actionbar
    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    public void selecionaMenuTec(View view){

        if (view.getId() == R.id.idAmc) {

            String TAG = "myApp";
            Log.d(TAG, "ENTROU!");

            tecAmc tecAmc = new tecAmc();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.content,tecAmc, tecAmc.getTag()).addToBackStack(null).commit();

        }else if (view.getId() == R.id.idIgp) {

        } else if (view.getId() == R.id.idIpl) {

        }else if (view.getId() == R.id.idOac) {

        }else if (view.getId() == R.id.idIpu) {

        }else if (view.getId() == R.id.idHoraSeg) {

        }else if (view.getId() == R.id.idRiscoC) {

        }
    }

    public void adicionarAmc(View view){
        adicionarAmc adicionarAmc = new adicionarAmc();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.content,adicionarAmc, adicionarAmc.getTag()).addToBackStack(null).commit();
    }



}