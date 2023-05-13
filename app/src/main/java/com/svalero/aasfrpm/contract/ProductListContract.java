package com.svalero.aasfrpm.contract;

import com.svalero.aasfrpm.domain.Product;

import java.util.List;

public interface ProductListContract {

    interface Model {
        interface OnLoadProductsListener {
            void onLoadProductsSuccess(List<Product> products);
            void onLoadProductsError(String message);
        }
        void loadAllProducts(OnLoadProductsListener listener);
        List<Product> loadProductsByName(String name);
    }

    interface View {
        void showProducts(List<Product> products);
        void showMessage(String message);
    }

    interface Presenter {
        void loadAllProducts();
    }
}
