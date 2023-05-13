package com.svalero.aasfrpm.api;
import com.svalero.aasfrpm.domain.Product;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TeLoVendoApiInterface {

    @GET("products")
    Call<List<Product>> getProducts();

    @GET("product/{id}")
    Call<Product> getProduct(@Path("id") long id);

}
