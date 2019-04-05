package com.example.fragmentdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    String [] name={"Batch1","Batch2"};
    boolean b=true;
    FrameLayout frameLayout;
    Fragment1 fragment1;
    BlankFragment fragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner=findViewById(R.id.spinner);
        frameLayout=findViewById(R.id.frameLayout);
        spinner.setOnItemSelectedListener(this);
        fragment1=new Fragment1();
        fragment2=new BlankFragment();

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,name);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(aa);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0:
                setFragment(fragment1);
                break;
            case 1:
                setFragment(fragment2);
                break;
        }



    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public  void setFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
    }
}
