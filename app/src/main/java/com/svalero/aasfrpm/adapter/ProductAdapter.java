package com.svalero.aasfrpm.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.StringRes;
import androidx.recyclerview.widget.RecyclerView;

import com.svalero.aasfrpm.R;
import com.svalero.aasfrpm.domain.Product;
import com.svalero.aasfrpm.view.ProductDetailsView;

import java.util.List;

import lombok.ToString;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductHolder> {

    private Context context;
    private List<Product> productList;
    private View snackBarView;

    public ProductAdapter(Context context, List<Product> dataList) {
        this.context = context;
        this.productList = dataList;
    }

    public Context getContext() {
        return context;
    }

    @Override
    public ProductHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_item, parent, false);
        return new ProductHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductHolder holder, int position) {
        holder.productName.setText(productList.get(position).getName());
        holder.productCategory.setText(productList.get(position).getCategory());
        holder.productId.setText(String.valueOf(productList.get(position).getId()));
        holder.productDone.setChecked(productList.get(position).isAvailable());
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    /*@Override
    public void showError(String errorMessage) {
        Snackbar.make(snackBarView, errorMessage,
                BaseTransientBottomBar.LENGTH_LONG).show();
    }

    @Override
    public void showMessage(String message) {
        Snackbar.make(snackBarView, message,
                BaseTransientBottomBar.LENGTH_LONG).show();
    }*/

        public class ProductHolder extends RecyclerView.ViewHolder {
            public TextView productName;
            public TextView productCategory;
            public TextView productId;
            public CheckBox productDone;
            public Button favProductButton;
            public Button seeDetailsButton;

            public View parentView;

            public ProductHolder(View view) {
                super(view);
                parentView = view;
                snackBarView = parentView;

                productName = view.findViewById(R.id.product_name);
                productCategory = view.findViewById(R.id.product_category);
                productId = view.findViewById(R.id.product_id);
                productDone = view.findViewById(R.id.check_product_fav);
                favProductButton = view.findViewById(R.id.buttonFav);
                seeDetailsButton = view.findViewById(R.id.see_details_button);

                // Marcar producto como favorito
                favProductButton.setOnClickListener(v -> doFav(getAdapterPosition()));
                // Ver detalles de la tarea
                seeDetailsButton.setOnClickListener(v -> seeDetails(getAdapterPosition()));

            }
        }

        private void doFav(int position) {
            Product product = productList.get(position);
            product.setAvailable(true);
            // TODO Invocar a la API para actualizar la base de datos

            notifyItemChanged(position);
        }

        private void seeDetails(int position) {
            Product product = productList.get(position);

            Intent intent = new Intent(context, ProductDetailsView.class);
            intent.putExtra("id", product.getId());
            Log.d("sandra", "pinta desde adapter " + product.getId());

            context.startActivity(intent);
        }
    }
