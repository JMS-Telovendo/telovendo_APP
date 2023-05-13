package com.svalero.aasfrpm.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.svalero.aasfrpm.R;
import com.svalero.aasfrpm.contract.ProductDetailsContract;
import com.svalero.aasfrpm.domain.Product;
import com.svalero.aasfrpm.presenter.ProductDetailsPresenter;

public class ProductDetailsView extends AppCompatActivity implements ProductDetailsContract.View {

    private ProductDetailsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        presenter = new ProductDetailsPresenter(this);

        Intent intent = getIntent();
        Long idLong = intent.getLongExtra("id", 1);  // Cambia el nombre de la variable para evitar conflictos con la cadena "id"
        String id = String.valueOf(idLong);  // Convierte el Long a String

        /*Intent intent = getIntent();
        String id = intent.getStringExtra("id");*/
        Log.d("sandra", "pinta desde view " + id);
        if (id == null)
            return;

        presenter.loadProduct(Long.parseLong(id));
    }


    @Override
    public void showProduct(Product product) {


        Log.d("sandra", "pinta desde showproduct " + product);
        TextView tvName = findViewById(R.id.tv_product_name);
        TextView tvCategory = findViewById(R.id.tv_product_category);
        TextView tvPrice = findViewById(R.id.tv_product_price);


        Log.d("showProduct", "he llegado aqui "); //TODO: el programa explota aqui (get name apunta a un null)
        tvName.setText(product.getName());
        Log.d("showProduct", "he llegado aqui 2");
        tvCategory.setText(product.getCategory());
        tvPrice.setText(String.valueOf(product.getPrice()));
    }

    @Override
    public void showMessage(String message) {

    }
}
