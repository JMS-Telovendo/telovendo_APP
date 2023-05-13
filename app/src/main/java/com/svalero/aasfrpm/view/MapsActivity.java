package com.svalero.aasfrpm.view;

import androidx.appcompat.app.AppCompatActivity;


import com.mapbox.maps.MapView;
import com.mapbox.maps.plugin.annotation.generated.PointAnnotationManager;
import com.svalero.aasfrpm.contract.ProductListContract;
import com.svalero.aasfrpm.domain.Product;
import com.svalero.aasfrpm.presenter.ProductListPresenter;

import java.util.List;

public class MapsActivity extends AppCompatActivity implements ProductListContract.View
    {

    private MapView mapView;
    private PointAnnotationManager pointAnnotationManager;
    private ProductListPresenter productListPresenter;


        @Override
        public void showProducts(List<Product> products) {

        }

        @Override
        public void showMessage(String message) {

        }
    }
