package at.htlkaindorf.android.bhmba17.traussnigg.quagl.GUI;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.text.NumberFormat;

import at.htlkaindorf.android.bhmba17.traussnigg.quagl.R;

public class RecyclerResultsActivity extends AppCompatActivity {

    private String formatValue(@StringRes int strId, final double value)
    {
        final NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(4);
        return String.format("%s: %s", getString(strId), numberFormat.format(value));
    }
    private String formatAbc(double value, boolean prefixPlus)
    {
        final NumberFormat numberFormat = NumberFormat.getInstance();
        return value>=0 && prefixPlus
                ? "+"+numberFormat.format(value)
                : numberFormat.format(value);
    }
    private String formatTitle(double a, double b, double c)
    {
        return formatAbc(a, false) + "x² "+
                formatAbc(b, true) + "x " +
                formatAbc(c, true) + " = 0";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // RecyclerView erzeugen

        final RecyclerView recyclerView = new RecyclerView(this);
        recyclerView.setBackground(getDrawable(R.drawable.background));

        // Layoutmanager setzen
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Adapter erzeugen
        final CardAdapter cardAdapter = new CardAdapter();
        recyclerView.setAdapter(cardAdapter);
        // Cardadapter befüllen

        setContentView(R.layout.card);
        final Intent intent = getIntent();
        // Titel

        cardAdapter.add(formatTitle(
                        intent.getDoubleExtra("a", 0.0),
                        intent.getDoubleExtra("b", 0.0),
                        intent.getDoubleExtra("c", 0.0)), null);


        // RecyclerView als "Hauptview" setzen
        setContentView(recyclerView);

        // x1
        if(intent.hasExtra("x1"))
            cardAdapter.add(
                    formatValue(R.string.x1, intent.getDoubleExtra("x1", 0)),
                    getDrawable(R.drawable.checkmark));
        // x2
        if(intent.hasExtra("x2"))
        {
            cardAdapter.add(
                formatValue(R.string.x2, intent.getDoubleExtra("x2", 0)),
                    getDrawable(R.drawable.checkmark));
        }

        // Number of Results
        final int numberOfResults = intent.getIntExtra("numberOfResults", 0);
        cardAdapter.add(String.format(new String(Character.toChars(0x1F600))+"%s: %d",
                getString(R.string.numberofresults), numberOfResults), getDrawable(R.drawable.checkmark));
    }

}