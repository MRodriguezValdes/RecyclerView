package com.example.recyclerview;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView wordItemView; // Declaración de TextView
    private final WordListAdapter mAdapter;

    public WordViewHolder(View itemView, WordListAdapter adapter) {
        super(itemView);
        wordItemView = itemView.findViewById(R.id.word); // Inicialización de wordItemView
        this.mAdapter = adapter;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // Manejar el evento de clic
        wordItemView.setText("Clicked! " + wordItemView.getText());
    }
}
