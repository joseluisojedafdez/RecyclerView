package com.i4bchile.reciclerview;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.i4bchile.reciclerview.modelo.Postre;
import com.i4bchile.reciclerview.vistas.Detalle;
import com.i4bchile.reciclerview.vistas.PostresAdapter;

public class MainActivity extends AppCompatActivity implements PostresAdapter.OnItemClickListener {

    private static final String TAG ="Log";
    private RecyclerView rvlistaPostres;
    private PostresAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAdapter = new PostresAdapter(this, Postre.getDesserts(), this);
        rvlistaPostres = findViewById(R.id.rv_Lista);
        rvlistaPostres.setAdapter(mAdapter);
        GridLayoutManager layoutGrid2;
        layoutGrid2 = new GridLayoutManager(this, 2, GridLayoutManager.HORIZONTAL, false);
        rvlistaPostres.setLayoutManager(layoutGrid2);


    }
    public void onClick(Postre postre) {

        String detalleNombre = postre.getNombre();
        String detalleDescripcion = postre.getDescripcion();
        int detalleImagen = postre.getImage();

        Log.e(TAG, "onClick postre: ");
        Fragment detalle = Detalle.newInstance(detalleNombre, detalleDescripcion, detalleImagen);
        Log.e(TAG, "Crea Fragmento: ");
        getSupportFragmentManager().beginTransaction().add(R.id.fr_detalle, detalle, "Detalle").commit();


    }


}


