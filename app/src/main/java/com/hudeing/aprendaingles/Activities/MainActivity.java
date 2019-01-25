package com.hudeing.aprendaingles.Activities;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hudeing.aprendaingles.Fragments.BichosFragment;
import com.hudeing.aprendaingles.Fragments.NumerosFragment;
import com.hudeing.aprendaingles.Fragments.PaollaFragment;
import com.hudeing.aprendaingles.Fragments.VogaisFragment;
import com.hudeing.aprendaingles.R;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class MainActivity extends AppCompatActivity {

    private SmartTabLayout smartTabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        smartTabLayout = findViewById(R.id.smartTabLayout);
        viewPager = findViewById(R.id.viewPager);

        //Aplica configurações na Action Bar
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle(R.string.app_name);

        //Configurar abas
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(), FragmentPagerItems.with(this)
                .add(R.string.str_bichos, BichosFragment.class)
                .add(R.string.str_numeros, NumerosFragment.class)
                //.add(R.string.str_vogais, VogaisFragment.class)
                .add(R.string.str_paolla, PaollaFragment.class)
                .create()
        );


        viewPager.setAdapter(adapter);
        smartTabLayout.setViewPager(viewPager);
    }
}
