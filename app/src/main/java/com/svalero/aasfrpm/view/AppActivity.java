package com.svalero.aasfrpm.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.svalero.aasfrpm.R;
import com.svalero.aasfrpm.contract.ProductListContract;
import com.svalero.aasfrpm.domain.Product;

import java.util.List;

public class AppActivity extends AppCompatActivity implements ProductListContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);

       /* Intent intent = new Intent(AppActivity.this, ProductListView.class); //indicamos otra view

        startActivity(intent); // Para que muestre la otra view
        finish(); // terminamos esta actividad*/
    }

    @Override
    public void showProducts(List<Product> products) {

    }

    @Override
    public void showMessage(String message) {

    }
}