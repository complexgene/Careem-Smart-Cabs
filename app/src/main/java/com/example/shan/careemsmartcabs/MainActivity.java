package com.example.shan.careemsmartcabs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_bookCab = (Button)findViewById(R.id.bookride);
        btn_bookCab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent ii = new Intent(MainActivity.this, MapHolder.class);
                ii.putExtra("userloc","12.93,77.61");
                startActivity(ii);
            }
        });
    }
}
