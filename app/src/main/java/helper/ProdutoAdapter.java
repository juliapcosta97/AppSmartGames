package helper;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.smartgames.app.R;
import models.Produto;

/**
 * Created by julia on 18/12/2016.
 */

public class ProdutoAdapter extends ArrayAdapter<Produto>{
    int resource;
    Context context;

    public ProdutoAdapter(Context context, int resource, List<Produto> objects) {
        super(context, resource, objects);
        this.resource = resource;
        this.context = context;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View v = convertView;

        if(v == null) {

            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(resource, null);

        }
        Produto p = getItem(position);

        ImageView imgProduto;
        TextView txtNome,txtGenero;

        imgProduto =(ImageView) v.findViewById(R.id.imgProduto);
        txtNome = (TextView) v.findViewById(R.id.txtNome);
        txtGenero = (TextView) v.findViewById(R.id.txtGenero);

        txtNome.setText(p.getNome());

        txtGenero.setText(p.getGenero());

        String imagemProduto = context.getString(R.string.link) + "/ProjetoSmartGames/" + p.getImagem();
        Log.d("imagem", imagemProduto);

        Picasso.with(getContext()).load(imagemProduto).into(imgProduto);

        return v;
    }
}
