package com.svalero.aasfrpm.presenter;

import android.content.Context;
import android.util.Log;

import com.svalero.aasfrpm.contract.ProductDetailsContract;
import com.svalero.aasfrpm.domain.Product;
import com.svalero.aasfrpm.model.ProductDetailsModel;

public class ProductDetailsPresenter implements ProductDetailsContract.Presenter,
        ProductDetailsContract.Model.OnLoadProductListener {

    private ProductDetailsModel model;
    private ProductDetailsContract.View view;
    private Context context;
    private long id;
    private Product product;

    public ProductDetailsPresenter(ProductDetailsContract.View view) {
        this.view = view;
        this.model = new ProductDetailsModel(context);
    }


    @Override
    public void loadProduct(long id) {
        Log.d("product details presenter", "pinto loadProduct" + id);
        model.loadProduct(this, id);
    }

    @Override
    public void onLoadProductSuccess(Product product) {
        view.showProduct(product);
    }

    @Override
    public void onLoadProductError(String message) {
        view.showMessage(message);
    }


}
