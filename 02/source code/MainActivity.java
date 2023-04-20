package com.example.lab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item_1:
                Toast.makeText(MainActivity.this, "You Clicked 1st item", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_item_2:
                Toast.makeText(MainActivity.this, "You Clicked 2nd item", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_item_3:
                Toast.makeText(MainActivity.this, "You Clicked 3rd item", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}