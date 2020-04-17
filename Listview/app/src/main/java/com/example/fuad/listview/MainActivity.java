package com.example.fuad.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private String []Bangladesh_team;
    private int [] pic={R.drawable.mas,R.drawable.mus,R.drawable.tamim,R.drawable.sakib,R.drawable.mah,R.drawable.som,
    R.drawable.lit,R.drawable.mir,R.drawable.sabbir,R.drawable.musta,R.drawable.rub,R.drawable.tas};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mains);
        listView=findViewById(R.id.listview1);
      Bangladesh_team=getResources().getStringArray(R.array.Bangladesh_Team_icc_2019_world_cup);
      CustomAdapter adapter=new CustomAdapter(this,Bangladesh_team,pic);
      listView.setAdapter(adapter);

    }
}
