package com.example.asycntask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
private EditText ed1,ed2;
private Button bt1;
private  int result,i,j;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1=findViewById(R.id.ed1);
        ed2=findViewById(R.id.ed2);
        bt1=findViewById(R.id.bt1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 i=Integer.parseInt(ed1.getText().toString());
                j=Integer.parseInt(ed2.getText().toString());

                new  Multyply().execute();
            }
        });
    }

    public class Multyply extends AsyncTask<Integer,Void,Void>{
        @Override
        protected void onPostExecute(Void aVoid) {
            Toast.makeText(MainActivity.this, "result:"+result, Toast.LENGTH_SHORT).show();
            super.onPostExecute(aVoid);
        }

        @Override
        protected Void doInBackground(Integer... integers) {
            result=i*j;
            return null;
        }
    }
}
