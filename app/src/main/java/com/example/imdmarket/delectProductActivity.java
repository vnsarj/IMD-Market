package com.example.imdmarket;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class delectProductActivity extends AppCompatActivity {
    private Button btnExcluir;
    private EditText codigoExclusao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delect_product);

        btnExcluir = findViewById(R.id.buttonDelProduct);
        codigoExclusao = findViewById(R.id.editTextDelProduct);

    }
}