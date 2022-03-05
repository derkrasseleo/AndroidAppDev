package at.htlkaindorf.android.bhmba17.traussnigg.quagl.GUI.recycler;

import android.graphics.drawable.Drawable;

public class TextAndIcon
{
    private final CharSequence text;
    private final Drawable drawable;

    public TextAndIcon(CharSequence text, Drawable drawable) {
        this.text = text;
        this.drawable = drawable;
    }

    public CharSequence getText()
    {
        return text;
    }

    public Drawable getDrawable() {
        return drawable;
    }
}
