package br.com.smartgames.app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.ArrayList;

import helper.HttpRequest;
import helper.HttpRequestFabric;
import helper.ProdutoAdapter;
import models.Produto;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ProdutoAdapter produtoAdapter;
    ListView lstProdutos;
    Produto[] produtos;
    Context context;

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

        context = this;

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        lstProdutos = (ListView) findViewById(R.id.lstProdutos);

        ArrayList<Produto> lista = new ArrayList<Produto>();

        produtoAdapter = new ProdutoAdapter(this, R.layout.item_list_view, lista);

        lstProdutos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Produto p = produtoAdapter.getItem(position);
                Intent detalhes = new Intent(getApplicationContext(), DetalhesActivity.class);
                detalhes.putExtra("produto", p);
                startActivity(detalhes);

            }
        });
        new ObterDadosAPI().execute();


    }

    private class ObterDadosAPI extends AsyncTask<Void, Void , String>{

        @Override
        protected String doInBackground(Void... params) {


            String link = "http://192.168.0.11/API/obtem_produtos.php";

            boolean acessarInternet = true;

            HttpRequest http = HttpRequestFabric.getHttpRequest(acessarInternet);

            String json = http.getJson(link);

            return json;
        }

        @Override
        protected void onPostExecute(String stringJson) {
            super.onPostExecute(stringJson);
            Log.i("Json", stringJson);

            if(stringJson !=null) {

                Gson g = new Gson();
                produtos = g.fromJson(stringJson, Produto[].class);

                produtoAdapter.clear();
                produtoAdapter.addAll(produtos);

                lstProdutos.setAdapter(produtoAdapter);
            }
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

            SharedPreferences prefs = getSharedPreferences("meu_arquivo_de_preferencias", 0);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("estaLogado", false);

            editor.clear();
            editor.commit();

            Intent login = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(login);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.item_acao) {
            // Handle the camera action
        } else if (id == R.id.item_rpg) {

        } else if (id == R.id.item_esportes) {

        } else if (id == R.id.item_luta) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
