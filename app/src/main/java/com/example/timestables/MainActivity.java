package com.example.timestables;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SeekBar seekbar = (SeekBar)findViewById(R.id.seekBar);
        seekbar.setMax(19);
       // seekbar.setMin(1);
        listView=(ListView)findViewById(R.id.listview);
        setadapter(1);
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                progress=progress+1;

                setadapter(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void setadapter(int progress) {
        ArrayList<String> p = new ArrayList<String>();
        for( int i=1;i<=10;i++){
            p.add(Integer.toString(i*progress));
            Log.i("message",Integer.toString(i*progress));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,p);
        listView.setAdapter(arrayAdapter);
    }
}
