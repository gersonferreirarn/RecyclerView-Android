package br.com.caicosoft.recyclerview.activity.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.caicosoft.recyclerview.R;
import br.com.caicosoft.recyclerview.activity.model.Filme;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Filme> listaFilmes;

    public Adapter(List<Filme> lista) {
        listaFilmes = lista;
    }

    @NonNull
    @Override
    // eh chamado para ser possivel criar as nossas visualizações
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        //converter xml adapter_lista em um objeto do tipo VIew
        View itemLista = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.adapter_lista, viewGroup, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    // responsavel pela exibição dos itens
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        Filme filme = listaFilmes.get(i);
        myViewHolder.titulo.setText(filme.getTituloFilme());
        myViewHolder.genero.setText(filme.getGenero());
        myViewHolder.ano.setText(filme.getAno());
    }

    @Override
    // quantidade de itens a ser exibido
    public int getItemCount() {
        return listaFilmes.size();
    }

    // sera responsavel por guardar cada um dos dados antes que eles sejam exibido na tela

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView titulo;
        TextView ano;
        TextView genero;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            // localiza os componentes
            titulo = itemView.findViewById(R.id.tvTitulo);
            ano = itemView.findViewById(R.id.tvAno);
            genero = itemView.findViewById(R.id.tvGenero);
        }
    }

}
