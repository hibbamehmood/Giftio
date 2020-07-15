package com.example.giftio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

public class Hibba extends AppCompatActivity {

    private RecyclerView recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hibba);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        recyclerview= findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager= new LinearLayoutManager((this));
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(layoutManager);
        List<ModelClass> modelClassList= new ArrayList<>();
        modelClassList.add(new ModelClass(R.drawable.ic_card_giftcard_black_24dp,"Mother's day"));
        modelClassList.add(new ModelClass(R.drawable.ic_card_giftcard_black_24dp,"Friendship Day"));
        modelClassList.add(new ModelClass(R.drawable.ic_card_giftcard_black_24dp,"Birthday"));
        modelClassList.add(new ModelClass(R.drawable.ic_card_giftcard_black_24dp,"Teacher's Day"));
        modelClassList.add(new ModelClass(R.drawable.ic_card_giftcard_black_24dp,"Valentine's Day"));
        modelClassList.add(new ModelClass(R.drawable.ic_card_giftcard_black_24dp,"Father's Day"));
        modelClassList.add(new ModelClass(R.drawable.ic_card_giftcard_black_24dp,"Marriage Ceremony"));
        modelClassList.add(new ModelClass(R.drawable.ic_card_giftcard_black_24dp,"Engagement Ceremony"));




        Adapter adapter=new Adapter(getApplicationContext(), modelClassList);
        recyclerview.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
}
