package com.example.vale.myapplication;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.Arrays;

/**
 * Created by vale on 1/02/17.
 */
public class MyListAdapter extends BaseAdapter {

    private Context context;
    private static int [] lista_dibujos = {R.string.accesible, R.string.alarma, R.string.androide, R.string.check, R.string.salida, R.string.setting, R.string.tarjeta, R.string.tresD};
    private Typeface typeface;
    private static boolean[] clicks;
    private static boolean filter;



    public MyListAdapter (Context context)
    {
        this.context = context;
        this.clicks = clicks;
        typeface = Typeface.createFromAsset(context.getAssets(),"MaterialIcons-Regular.ttf");
        clicks = new boolean[lista_dibujos.length];
        filter = false;

    }

    public MyListAdapter(Context context, boolean[] arrayBol){
        this.context = context;
        this.clicks = arrayBol;
        typeface = Typeface.createFromAsset(context.getAssets(),"MaterialIcons-Regular.ttf");
    }

    public MyListAdapter(Context context, boolean[] arrayBol, boolean filter){

        if(filter){
            lista_dibujos = filtrarDibujos(arrayBol);
            this.context = context;
            this.clicks = new boolean[lista_dibujos.length];
            this.filter = filter;
            typeface = Typeface.createFromAsset(context.getAssets(),"MaterialIcons-Regular.ttf");
        }
    }

    private int calculaElementos (boolean[] ab){

        int n = 0;

        for(boolean b : ab){
            if(b) n++;
        }

        return n;

    }

    private int[] filtrarDibujos (boolean[] ab){
        int[] ae_dev = null;
        int n = calculaElementos(ab);
        ae_dev = new int[n];
        int pos = 0;

        for(int i = 0; i < ab.length; i++){
            if(ab[i]){
                ae_dev[pos] = lista_dibujos[i];
                pos++;
            }
        }
        return ae_dev;

    }

    public static boolean[] getClicks(){
        return clicks;
    }

    @Override
    public int getCount() {
        return lista_dibujos.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = null;

            if (convertView==null)
            {
                Activity a = (Activity)context;
                LayoutInflater li = a.getLayoutInflater();
                view = li.inflate(R.layout.fila,parent, false);

            } else
                {
                    view = convertView;
                }


            TextView tv = (TextView) view.findViewById(R.id.texto);
            tv.setTypeface(typeface);
            tv.setText(lista_dibujos[position]);

            CheckBox checkBox = (CheckBox) view.findViewById(R.id.micheckbox);
            checkBox.setChecked(clicks[position]);

            checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CheckBox checkBox1 = (CheckBox) v;
                    clicks[position] = checkBox1.isChecked();
                }
            });

        //if(filter)Log.d(getClass().getCanonicalName(), "true"+position);


        return view;
    }
}
