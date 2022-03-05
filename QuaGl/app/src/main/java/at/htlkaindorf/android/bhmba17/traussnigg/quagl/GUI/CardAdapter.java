package at.htlkaindorf.android.bhmba17.traussnigg.quagl.GUI;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import at.htlkaindorf.android.bhmba17.traussnigg.quagl.GUI.recycler.CardViewHolder;
import at.htlkaindorf.android.bhmba17.traussnigg.quagl.GUI.recycler.TextAndIcon;
import at.htlkaindorf.android.bhmba17.traussnigg.quagl.R;

public class CardAdapter extends RecyclerView.Adapter<CardViewHolder>
{
    private final List<TextAndIcon> textAndIcons = new ArrayList<>();

    public void add(CharSequence text, Drawable icon)
    {
        textAndIcons.add(new TextAndIcon(text, icon));
    }
    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final CardView cardView = (CardView) LayoutInflater.from(parent.getContext()).inflate(
                R.layout.card, parent, false);
        return new CardViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        holder.bindTextandIcon(textAndIcons.get(position));
    }

    @Override
    public int getItemCount() {
        return textAndIcons.size();
    }
}
