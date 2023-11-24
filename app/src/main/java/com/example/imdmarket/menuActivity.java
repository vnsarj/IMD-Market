package com.example.imdmarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class menuActivity extends AppCompatActivity {

    private Button addProductButton;
    private Button showProductButton;
    private Button changeProductButton;
    private Button delProduct;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        addProductButton = findViewById(R.id.cadastrarProduto);
        showProductButton = findViewById(R.id.listarProduto);
        delProduct = findViewById(R.id.deletarProduto);
        changeProductButton = findViewById(R.id.alterarProduto);


        addProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(menuActivity.this, addProductActivity.class);
                startActivity(intent);
            }
        });

        showProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(menuActivity.this, showProductActivity.class);
                startActivity(intent);
            }
        });

        delProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(menuActivity.this, delectProductActivity.class);
                startActivity(intent);
            }
        });

        changeProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(menuActivity.this, changeProduct.class);
                startActivity(intent);
            }
        });


    }
}