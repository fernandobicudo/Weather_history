package com.fernando.teste_com_fab;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.fernando.teste_com_fab.R;
import com.fernando.teste_com_fab.Weather;

import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

public class CityArrayAdapter extends ArrayAdapter<String> {

    private class ViewHolder {

        public TextView cityTextView;
    }


    CityArrayAdapter(Context context, List<String> cidades) {
        super(context, -1, cidades); //QUE PORRA É ESSA?????????????????????????????????????????????????????????
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder vh = null;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list_city, parent, false);
            vh = new ViewHolder();
            vh.cityTextView = convertView.findViewById(R.id.cityTextView);

            convertView.setTag(vh);
        } else
            //downcasting
            vh = (ViewHolder) convertView.getTag();

        String cidade = getItem(position);

        vh.cityTextView.setText(cidade);

        return convertView;
    }
}
