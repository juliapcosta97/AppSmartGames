package br.com.smartgames.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import models.Produto;

import static br.com.smartgames.app.R.id.txtGenero;

public class DetalhesActivity extends AppCompatActivity {

    ImageView img_detalhes;
    TextView txtNomeDetalhe,txtGeneroDetalhe, txtDescricao, txtPreco, txtPlataforma,txtDesenvolvedor,txtLoja;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        context = this;

        final Intent intent = getIntent();

        img_detalhes =(ImageView) findViewById(R.id.img_detalhes);
        txtNomeDetalhe = (TextView) findViewById(R.id.txtNomeDetalhe);
        txtGeneroDetalhe = (TextView) findViewById(R.id.txtGeneroDetalhe);
        txtDescricao = (TextView) findViewById(R.id.txtDescricao);
        txtPreco = (TextView) findViewById(R.id.txtPreco);
        txtPlataforma = (TextView) findViewById(R.id.txtPlataforma);
        txtDesenvolvedor = (TextView) findViewById(R.id.txtDesenvolvedor);
        txtLoja = (TextView) findViewById(R.id.txtLoja);

        if(intent != null) {

            Produto p = (Produto) intent.getSerializableExtra("produto");

            txtNomeDetalhe.setText(p.getNome());
            txtGeneroDetalhe.setText("Gênero: " + p.getGenero());
            txtDescricao.setText(p.getDescricao());
            txtPreco.setText("Preço: R$ " + p.getPreco());
            txtPlataforma.setText("Plataforma: " + p.getPlataforma());
            txtDesenvolvedor.setText("Desenvolvedor: " + p.getDesenvolvedor());
            //txtLoja.setText(p.getLoja());*/

            String imagemProduto = context.getString(R.string.link) + "/AppSmartGames/" + p.getImagem();
            Log.d("imgDetalhe", imagemProduto);

           Picasso.with(context).load(imagemProduto).into(img_detalhes);

        }

    }

}
