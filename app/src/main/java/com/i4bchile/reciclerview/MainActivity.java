package com.i4bchile.reciclerview;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.i4bchile.reciclerview.modelo.Postre;

public class MainActivity extends AppCompatActivity implements PostresAdapter.OnItemClickListener {

    private RecyclerView rvlistaPostres;
    private PostresAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAdapter=new PostresAdapter(this,Postre.getDesserts(),this);
        rvlistaPostres=findViewById(R.id.rv_Lista);
        rvlistaPostres.setAdapter(mAdapter);
        GridLayoutManager layoutGrid2;
        layoutGrid2 = new GridLayoutManager(this,2, GridLayoutManager.VERTICAL,false);
        rvlistaPostres.setLayoutManager(layoutGrid2);


    }

    @Override
    public void onClick(Postre postre) {
        Intent detail = new Intent(getApplicationContext(), Detalle.class);
        detail.putExtra("NAME", postre.getNombre());
        detail.putExtra("IMAGE", postre.getImage());

        startActivity(detail);
    }
}


