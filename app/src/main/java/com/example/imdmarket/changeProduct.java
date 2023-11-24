package com.example.imdmarket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class changeProduct extends AppCompatActivity {

    EditText editTextCodigoProduto, editTextNomeProduto, editTextDescricaoProduto, editTextEstoque;
    Button buttonChangeProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_product);

        editTextCodigoProduto = findViewById(R.id.editTextCodigoProduto2);
        editTextNomeProduto = findViewById(R.id.editTextNomeProduto2);
        editTextDescricaoProduto = findViewById(R.id.editTextDescricaoProduto2);
        editTextEstoque = findViewById(R.id.editTextEstoque2);
        buttonChangeProduct = findViewById(R.id.buttonChange);

    }
}