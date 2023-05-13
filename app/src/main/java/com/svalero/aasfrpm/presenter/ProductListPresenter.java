package com.svalero.aasfrpm.presenter;

import com.svalero.aasfrpm.contract.ProductListContract;
import com.svalero.aasfrpm.domain.Product;
import com.svalero.aasfrpm.model.ProductListModel;

import java.util.List;

public class ProductListPresenter implements ProductListContract.Presenter,
        ProductListContract.Model.OnLoadProductsListener {


        private ProductListModel model;
        private ProductListContract.View view;

    public ProductListPresenter(ProductListContract.View view) {
            this.view = view;
            this.model = new ProductListModel();
        }

        @Override
        public void loadAllProducts() {
            model.loadAllProducts(this);
        }


        @Override
        public void onLoadProductsSuccess(List<Product> products) {
            view.showProducts(products);
        }

        @Override
        public void onLoadProductsError(String message) {
                view.showMessage(message);
            }
}
