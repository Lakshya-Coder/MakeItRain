package com.lakshyagupta7089.makeitrain;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.icu.text.NumberFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private TextView moneyValue;
    private int moneyCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moneyValue = findViewById(R.id.moneyValue);
    }

    public void showMoney(View view) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            NumberFormat numberFormat = NumberFormat.getCurrencyInstance();

            if (moneyCounter >= 20_000) {
                moneyValue.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.orange));
            }

            moneyCounter += 1000;
            moneyValue.setText(numberFormat.format(moneyCounter));
        } else {
            moneyValue.setText(":(");
        }

    }

    public void showInfo(View view) {
//        Toast.makeText(MainActivity.this, R.string.app_info, Toast.LENGTH_SHORT)
//                .show();

        Snackbar.make(moneyValue, R.string.app_info, Snackbar.LENGTH_LONG)
                .setAction("More", v -> {
                    Toast.makeText(MainActivity.this, R.string.i_like_it, Toast.LENGTH_SHORT)
                            .show();
                })
                .show();
    }
}