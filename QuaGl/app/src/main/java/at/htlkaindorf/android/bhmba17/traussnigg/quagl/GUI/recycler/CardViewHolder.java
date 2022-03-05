package at.htlkaindorf.android.bhmba17.traussnigg.quagl.GUI.recycler;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import at.htlkaindorf.android.bhmba17.traussnigg.quagl.R;

public class CardViewHolder extends RecyclerView.ViewHolder {

    private final CardView cardView;
    private final TextView textView;
    private final ImageView imageView;

    public CardViewHolder(@NonNull CardView itemView) {
        super(itemView);
        cardView = itemView;
        textView = cardView.findViewById(R.id.idRvText);
        imageView = cardView.findViewById(R.id.idRvIcon);
    }

    public void bindText(CharSequence text)
    {
        textView.setText(text);
    }

    public void bindImage(Drawable drawable)
    {
        imageView.setImageDrawable(drawable);
    }

    public void bindTextandIcon(TextAndIcon textAndIcon)
    {
        final CharSequence text = textAndIcon.getText();
        bindText(text!=null ? text : "");
        bindImage(textAndIcon.getDrawable());
    }
}
