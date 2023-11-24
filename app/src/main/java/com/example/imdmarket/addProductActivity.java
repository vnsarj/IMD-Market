package com.example.imdmarket;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.SharedPreferences;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class addProductActivity extends AppCompatActivity {


    EditText editTextCodigoProduto, editTextNomeProduto, editTextDescricaoProduto, editTextEstoque;
    Button buttonAddProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        editTextCodigoProduto = findViewById(R.id.editTextCodigoProduto2);
        editTextNomeProduto = findViewById(R.id.editTextNomeProduto2);
        editTextDescricaoProduto = findViewById(R.id.editTextDescricaoProduto2);
        editTextEstoque = findViewById(R.id.editTextEstoque2);
        buttonAddProduct = findViewById(R.id.buttonChange);

        buttonAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateForm()) {
                    Produto produto = new Produto(
                            Integer.parseInt(editTextCodigoProduto.getText().toString()),
                            editTextNomeProduto.getText().toString(),
                            editTextDescricaoProduto.getText().toString(),
                            Integer.parseInt(editTextEstoque.getText().toString())
                    );

                    saveProduct(produto);
                    Toast.makeText(addProductActivity.this, "Produto adicionado com sucesso!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(addProductActivity.this, menuActivity.class));
                } else {
                    Toast.makeText(addProductActivity.this, "Preencha todos os campos obrigatórios!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean validateForm() {
        return !editTextCodigoProduto.getText().toString().isEmpty() &&
                !editTextNomeProduto.getText().toString().isEmpty() &&
                !editTextDescricaoProduto.getText().toString().isEmpty() &&
                !editTextEstoque.getText().toString().isEmpty();
    }

    public static class SharedPrefManager {
        private static final String SHARED_PREF_NAME = "produtos";
        private static final String KEY_PRODUTOS = "produtos";
        public static void salvarProdutos(Context context, List<Produto> produtos) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();

            JSONArray jsonArray = new JSONArray();
            for (Produto produto : produtos) {
                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("codigo_produto", produto.getCodigo_produto());
                    jsonObject.put("nome_produto", produto.getNome_produto());
                    jsonObject.put("descricao_produto", produto.getDescricao_produto());
                    jsonObject.put("estoque", produto.getEstoque());
                    jsonArray.put(jsonObject);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            editor.putString(KEY_PRODUTOS, jsonArray.toString());
            editor.apply();
        }

        public static List<Produto> getProdutos(Context context) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
            String jsonString = sharedPreferences.getString(KEY_PRODUTOS, null);

            List<Produto> produtos = new ArrayList<>();
            if (jsonString != null) {
                try {
                    JSONArray jsonArray = new JSONArray(jsonString);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        Produto produto = new Produto(
                                jsonObject.getInt("codigo_produto"),
                                jsonObject.getString("nome_produto"),
                                jsonObject.getString("descricao_produto"),
                                jsonObject.getInt("estoque")
                        );
                        produtos.add(produto);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            return produtos;
        }
    }
    private void saveProduct(Produto produtoIndex) {
        List<Produto> listaProdutos = SharedPrefManager.getProdutos(this);
        listaProdutos.add(produtoIndex);
        SharedPrefManager.salvarProdutos(this, listaProdutos);
    }

}