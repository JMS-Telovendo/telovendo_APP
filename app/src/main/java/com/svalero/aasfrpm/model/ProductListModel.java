package com.svalero.aasfrpm.model;

import android.util.Log;

import com.svalero.aasfrpm.api.TeLoVendoApi;
import com.svalero.aasfrpm.api.TeLoVendoApiInterface;
import com.svalero.aasfrpm.contract.ProductListContract;
import com.svalero.aasfrpm.domain.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductListModel implements ProductListContract.Model {

    @Override
    public void loadAllProducts(OnLoadProductsListener listener) {
        TeLoVendoApiInterface telovendoApi = TeLoVendoApi.buildInstance();
        Call<List<Product>> callProducts = telovendoApi.getProducts();
        Log.d("products", "Llamada desde model list");
        callProducts.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                Log.d("products", "Llamada desde model list ok");
                List<Product> products = response.body();
                listener.onLoadProductsSuccess(products);
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Log.d("products", "Llamada desde model list error");
                t.printStackTrace();
                String message = "Error invocando a la operación";
                listener.onLoadProductsError(message);
            }
        });
    }

    @Override
    public List<Product> loadProductsByName(String product_name) {
        return null;
    }

}
