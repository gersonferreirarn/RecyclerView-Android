package br.com.caicosoft.recyclerview.activity.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.caicosoft.recyclerview.R;
import br.com.caicosoft.recyclerview.activity.RecyclerItemClickListener;
import br.com.caicosoft.recyclerview.activity.adapter.Adapter;
import br.com.caicosoft.recyclerview.activity.model.Filme;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvListagem;
    List<Filme> listaFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvListagem = findViewById(R.id.rvListagem);

        // Listagem de filmes
        criarFilmes();

        // Configurar adapter
        Adapter adapter = new Adapter(listaFilmes);

        // Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext()); //gerenciador de layout
        rvListagem.setLayoutManager(layoutManager);
        rvListagem.setHasFixedSize(true); // tamanho fixo do RV para ficar otimizado
        rvListagem.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL)); // cri divisor para linear vertical
        rvListagem.setAdapter(adapter);

        // Evento de click
        rvListagem.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        rvListagem,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {

                                Filme filme = listaFilmes.get(position);

                                Toast.makeText(
                                        getApplicationContext(),
                                        "Item Pressionado: "+filme.getTituloFilme(),
                                        Toast.LENGTH_SHORT
                                ).show();
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {

                                Filme filme = listaFilmes.get(position);

                                Toast.makeText(
                                        getApplicationContext(),
                                        "Click Longo: "+filme.getTituloFilme(),
                                        Toast.LENGTH_SHORT
                                ).show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                )
        );
    }

    public void criarFilmes(){
        Filme filme = new Filme("Brexit", "Drama", "2019");
        listaFilmes.add(filme);

        filme = new Filme("Cinderela Pop", "Aventura / Romance", "2019");
        listaFilmes.add(filme);

        filme = new Filme("Shazam!", "Ação / Aventura / Ficção", "2019");
        listaFilmes.add(filme);

        filme = new Filme("Maligno", "Terror", "2019");
        listaFilmes.add(filme);

        filme = new Filme("Como Treinar o Seu Dragão 3", "Animação / Ação / Aventura", "2019");
        listaFilmes.add(filme);

        filme = new Filme("Alita - Anjo de Combate", "Ação / Aventura / Romance", "2019");
        listaFilmes.add(filme);

        filme = new Filme("Dumbo", "Ação", "2019");
        listaFilmes.add(filme);

        filme = new Filme("O Menino que Descobriu o Vento", "Drama", "2019");
        listaFilmes.add(filme);

        filme = new Filme("Vidro", "Suspense", "2019");
        listaFilmes.add(filme);

        filme = new Filme("Calmaria", "Drama / Suspense", "2019");
        listaFilmes.add(filme);

        filme = new Filme("Minha Fama de Mau", "Drama", "2019");
        listaFilmes.add(filme);
    }
}
