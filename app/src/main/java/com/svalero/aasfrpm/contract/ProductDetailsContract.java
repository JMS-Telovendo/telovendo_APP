package com.svalero.aasfrpm.contract;

import android.util.Log;

import com.svalero.aasfrpm.domain.Product;

public interface ProductDetailsContract {

    interface Model {
        Product getProduct(long id);

        interface OnLoadProductListener {
            void onLoadProductSuccess(Product product);
            void onLoadProductError(String message);
        }
        void loadProduct(OnLoadProductListener listener, long id);

    }

    interface View {
        void showProduct(Product product);
        void showMessage(String message);
    }

    interface Presenter {
        void loadProduct(long id);
    }
}
