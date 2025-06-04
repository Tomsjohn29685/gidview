package com.example.gidview;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class Mygridview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mygridview);

        ListView mylist = findViewById(R.id.mylist2);
        ProgressBar progressBar = findViewById(R.id.progressBar);

        List<String> list_data = new ArrayList<>(100);
        for(int i=1;i <= 100;i++) {
            list_data.add("Item " + i);
        }
//            ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list_data);
//            mylist.setAdapter(adapter);
//            mylist.setEmptyView(findViewById(R.id.nodata));
        Handler handler = new Handler(Looper.myLooper()) {
            @Override
            public void handleMessage(@NonNull Message msg) {
                if (msg.what == 5) {
                    Bundle bundle = (Bundle) msg.obj;
                    ArrayList<String> retlist = bundle.getStringArrayList("mylist");
                    ListAdapter adapter = new ArrayAdapter<String>(Mygridview.this, android.R.layout.simple_list_item_1,list_data);
//绑定
                    mylist.setAdapter(adapter);
                    mylist.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.GONE);
                }
                super.handleMessage(msg);
            }
        };
Thread t = new Thread(new MyTask(handler));
t.start();
    }
}