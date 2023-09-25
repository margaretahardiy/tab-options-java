package com.example.optionsmenujava;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    TabLayoutMediator mediator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        ViewPager2 vp = findViewById(R.id.pager);

        TabAdapter adapter = new TabAdapter(getSupportFragmentManager(), getLifecycle());
        vp.setAdapter(adapter);

        mediator = new TabLayoutMediator(tabLayout, vp, (tab, position) -> {
            tab.setText("Tab" + position+1);
        });
        mediator.attach();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
      //  return super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.action_home :

                Toast.makeText(this, "item 1", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.action_material:
                Toast.makeText(this, "item 2", Toast.LENGTH_SHORT).show();
                return true;
        }

        return super.onOptionsItemSelected(item);


    }
}