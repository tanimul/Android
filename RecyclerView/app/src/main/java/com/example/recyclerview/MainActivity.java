package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[]language={"java","c","python","java","c","python","java","c","python","java","c","python","java","c","python"};
        RecyclerView programminglist=findViewById(R.id.programminglist);
        programminglist.setLayoutManager(new LinearLayoutManager(this));

        programminglist.setAdapter(new ProgrammingAdapter(language));
    }
}
