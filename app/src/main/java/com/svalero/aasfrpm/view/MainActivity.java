package com.svalero.aasfrpm.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.svalero.aasfrpm.R;
import com.svalero.aasfrpm.contract.ProductListContract;
import com.svalero.aasfrpm.domain.Product;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

//Funciona como launcher o pantalla de carga al inicio de la APP

public class MainActivity extends AppCompatActivity implements ProductListContract.View{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, ProductListView.class); //indicamos otra view

                startActivity(intent); // Para que muestre la otra view
                finish(); // terminamos esta actividad
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, 5000);
    }

    @Override
    public void showProducts(List<Product> products) {

    }

    @Override
    public void showMessage(String message) {

    }
}