package helper;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URL;

/**
 * Created by julia on 30/11/2016.
 */
public class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {


    WeakReference<ImageView> imageViewRef;

    public DownloadImageTask(ImageView imageView) {
        this.imageViewRef = new WeakReference<ImageView>(imageView);
    }

    @Override
    protected Bitmap doInBackground(String... params) {

        String caminhoImagem = params[0];
        Bitmap bitmap=null;

        try {
            InputStream inputStream= (InputStream)new URL(caminhoImagem).getContent();
            bitmap= BitmapFactory.decodeStream(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return bitmap;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);

        if(bitmap!= null) {

            ImageView img = imageViewRef.get();

            if(img!=null)
                img.setImageBitmap(bitmap);

        }
    }

}

