package com.svalero.aasfrpm.model;

import android.content.Context;
import android.util.Log;

import com.svalero.aasfrpm.api.TeLoVendoApi;
import com.svalero.aasfrpm.api.TeLoVendoApiInterface;
import com.svalero.aasfrpm.contract.ProductDetailsContract;
import com.svalero.aasfrpm.domain.Product;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductDetailsModel  implements ProductDetailsContract.Model {
    private Context context;
    private long id;

    public ProductDetailsModel(Context context) {
        this.context = context;
    }

    @Override
    public void loadProduct(OnLoadProductListener listener, long id) {

        //TODO conectar con la api
        TeLoVendoApiInterface telovendoApi = TeLoVendoApi.buildInstance();
        Call<Product> callProduct = telovendoApi.getProduct(id);
        Log.d("products", "Llamada desde model details" + id);
        callProduct.enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                Log.d("products", "Llamada desde model details ok");
                Product product = response.body();
                Log.d("products", "Llamada desde model details ok 1" + product);
                listener.onLoadProductSuccess(product);
            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {
                Log.d("products", "Llamada desde model details error");
                t.printStackTrace();
                String message = "Error invocando a la operación";
                listener.onLoadProductError(message);
            }
        });
    }


    @Override
    public Product getProduct(long id) {
        Log.d("productDetails model", "si me usan");
        return null;}


  /*  @Override
    public void getProduct(String product_name, ProductListContract.Model.OnLoadProductsListener listener) {
        TeLoVendoApiInterface telovendoApi = TeLoVendoApi.buildInstance();
        Call<List<Product>> callProducts = telovendoApi.getProducts();
        Log.d("products", "Llamada desde model");
        callProducts.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                Log.d("products", "Llamada desde model ok");
                List<Product> products = response.body();
                if (products != null) {
                    for (Product product : products) {
                        if (product.getName().equals(product_name)) {
                            listener.onLoadProductsSuccess((List<Product>) product);
                            return;
                        }
                    }
                }
                String message = "No se encontró el producto: " + product_name;
                listener.onLoadProductsError(message);
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Log.d("products", "Llamada desde model error");
                t.printStackTrace();
                String message = "Error invocando a la operación";
                listener.onLoadProductsError(message);
            }
        });
    }*/
}
