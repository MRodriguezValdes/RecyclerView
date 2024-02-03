package com.example.recyclerview;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;
    private final LinkedList<String> mWordList = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar la lista de palabras con algunos datos de ejemplo
        for (int i = 0; i < 20; i++) {
            mWordList.add("Word " + i);
        }

        // Obtener una referencia al RecyclerView
        mRecyclerView = findViewById(R.id.recyclerview);

        // Crear un adaptador y suministrar los datos a mostrar
        mAdapter = new WordListAdapter(this, mWordList);

        // Conectar el adaptador con el RecyclerView
        mRecyclerView.setAdapter(mAdapter);

        // Dar al RecyclerView un administrador de diseño predeterminado
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Configurar el botón flotante para agregar un nuevo elemento a la lista
        // Configurar el botón flotante para agregar un nuevo elemento a la lista
        FloatingActionButton fabAdd = findViewById(R.id.fab_add);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener el número de la última palabra en la lista
                int lastIndex = mWordList.size() - 1;
                String lastWord = mWordList.get(lastIndex);
                // Extraer el número de la última palabra
                String[] parts = lastWord.split(" ");
                int lastNumber = Integer.parseInt(parts[1]);
                // Incrementar el número
                int newNumber = lastNumber + 1;
                // Crear una nueva palabra con el número incrementado
                String newWord = "+Word " + newNumber;
                // Agregar la nueva palabra a la lista
                mWordList.addLast(newWord);
                // Notificar al adaptador sobre el cambio en los datos
                mAdapter.notifyItemInserted(mWordList.size() - 1);
                // Desplazarse hacia la nueva posición en la lista
                mRecyclerView.smoothScrollToPosition(mWordList.size() - 1);
            }
        });

    }
}
