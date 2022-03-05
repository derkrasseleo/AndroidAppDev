package at.htlkaindorf.android.bhmba17.traussnigg.quagl.GUI;

import androidx.annotation.IdRes;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

import at.htlkaindorf.android.bhmba17.traussnigg.quagl.R;
import at.htlkaindorf.android.bhmba17.traussnigg.quagl.calc.QuaEqCalculator;

public class ResultsActivity extends AppCompatActivity {

    private void formatValue(@IdRes final int tvId, @StringRes int strId, final double value)
    {
        final TextView textView = findViewById(tvId);
        final NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(4);
        textView.setText(String.format("%s: %s", getString(strId), numberFormat.format(value)));
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
        setContentView(R.layout.activity_results);
        final Intent intent = getIntent();
        ((TextView)findViewById(R.id.tvTitle)).setText(
                formatTitle(intent.getDoubleExtra("a", 0.0),
                        intent.getDoubleExtra("b", 0.0),
                        intent.getDoubleExtra("c", 0.0)));
        // Number of Results
        final int numberOfResults = intent.getIntExtra("numberOfResults", 0);
        ((TextView)findViewById(R.id.tvNumber)).setText(String.format(new String(Character.toChars(0x1F600))+"%s: %d",
                getString(R.string.numberofresults), numberOfResults));
        // x1
        if(intent.hasExtra("x1"))
            formatValue(R.id.tvX1, R.string.x1, intent.getDoubleExtra("x1", 0));
        else
        {
            findViewById(R.id.cvX1).setVisibility(View.GONE);
        }
        // x2
        if(intent.hasExtra("x2"))
        {
            formatValue(R.id.tvX2, R.string.x2, intent.getDoubleExtra("x2", 0));
        }
        else
        {
            findViewById(R.id.cvX2).setVisibility(View.GONE);
        }

    }
}