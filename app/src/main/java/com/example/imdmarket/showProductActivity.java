package com.example.imdmarket;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class showProductActivity extends AppCompatActivity {

    private ListView listViewProdutos;
    private List<Produto> produtos;
    private ArrayAdapter<Produto> produtosAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_product);

        listViewProdutos = findViewById(R.id.listViewProdutos);

        produtos = addProductActivity.SharedPrefManager.getProdutos(this);
        produtosAdapter = new ProdutoAdapter(this, produtos);

        listViewProdutos.setAdapter(produtosAdapter);

        listViewProdutos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Produto produtoSelecionado = produtos.get(position);
                exibirAlert(produtoSelecionado);
            }
        });
    }

    private void exibirAlert(Produto produto) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(produto.getNome_produto());
        builder.setMessage("Código do Produto: " + produto.getCodigo_produto() + "\n" +
                "Descrição do Produto: " + produto.getDescricao_produto() + "\n" +
                "Estoque: " + produto.getEstoque());
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    private class ProdutoAdapter extends ArrayAdapter<Produto> {

        public ProdutoAdapter(Context context, List<Produto> objects) {
            super(context, 0, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Reutilizar o view, se possível
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
            }

            // Obter o item atual
            Produto produto = getItem(position);

            // Atualizar a visualização do item
            TextView textView = convertView.findViewById(android.R.id.text1);
            textView.setText(produto.getNome_produto());

            return convertView;
        }
    }
}

