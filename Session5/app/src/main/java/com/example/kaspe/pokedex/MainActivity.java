package com.example.kaspe.pokedex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PokemonAdapter.OnListItemClickListener {

    RecyclerView mPokemonList;
    RecyclerView.Adapter mPokemonAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPokemonList = findViewById(R.id.rv);
        mPokemonList.hasFixedSize();
        mPokemonList.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(new Pokemon("Bulbasaur", R.drawable.p1));
        pokemons.add(new Pokemon("Ivysaur", R.drawable.p2));
        pokemons.add(new Pokemon("Venusaur", R.drawable.p3));
        pokemons.add(new Pokemon("Charmander", R.drawable.p4));
        pokemons.add(new Pokemon("Charmeleon", R.drawable.p5));
        pokemons.add(new Pokemon("Charizard", R.drawable.p6));
        pokemons.add(new Pokemon("Squirtle", R.drawable.p7));
        pokemons.add(new Pokemon("Wartortle", R.drawable.p8));
        pokemons.add(new Pokemon("Blastoise", R.drawable.p9));
        pokemons.add(new Pokemon("Caterpie", R.drawable.p10));
        pokemons.add(new Pokemon("Metapod", R.drawable.p11));
        pokemons.add(new Pokemon("Butterfree", R.drawable.p12));

        mPokemonAdapter = new PokemonAdapter(pokemons, this);
        mPokemonList.setAdapter(mPokemonAdapter);
    }

    @Override
    public void onListItemClick(int clickedItemIndex) {
        int pokemonNumber = clickedItemIndex + 1;
        Toast.makeText(this, "Pokemon Number: " + pokemonNumber, Toast.LENGTH_SHORT).show();
    }
}
