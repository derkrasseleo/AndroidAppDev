package at.htlkaindorf.android.bhmba17.traussnigg.quagl.GUI;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.Scanner;

import at.htlkaindorf.android.bhmba17.traussnigg.quagl.R;
import at.htlkaindorf.android.bhmba17.traussnigg.quagl.calc.QuaEqCalculator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private double readNumber(@IdRes final int idEditText)
    {
        final String text = ((EditText)findViewById(idEditText)).getText().toString();
        try
        {
            return new Scanner(text).nextDouble();
        }
        catch (Exception e)
        {
            return Double.parseDouble(text);
        }
    }
    private void showError(@NonNull final String errorMessage)
    {
        //Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
        Snackbar.make(findViewById(R.id.clMain), errorMessage, Snackbar.LENGTH_LONG).setAnimationMode(BaseTransientBottomBar.ANIMATION_MODE_FADE).setBackgroundTint(Color.MAGENTA).show();
    }

    public void onCalculate(View view)
    {
        try
        {
            final double
            a = readNumber(R.id.etA),
            b = readNumber(R.id.etB),
            c = readNumber(R.id.etC);

            //Rechnen
            final QuaEqCalculator calculator = new QuaEqCalculator(a,b,c);
            // Intent erzeugen
            final Intent intent = new Intent(this, RecyclerResultsActivity.class);
            // Ergebnisse an den Intent anhängen
            //final Intent intent = new Intent(this, ResultsActivity.class);

            Toast.makeText(this, String.format("numberOfResults: %d", calculator.getNumberOfResults()),
                    Toast.LENGTH_LONG).show();

            final int numberOfResults = calculator.getNumberOfResults();
            intent.putExtra("numberOfResults", numberOfResults);
            if (numberOfResults>=1)
                intent.putExtra("x1", calculator.getX1());
            if (numberOfResults>=2)
                intent.putExtra("x2", calculator.getX2());
            intent.putExtra("a", a);
            intent.putExtra("b", b);
            intent.putExtra("c", c);


            startActivity(intent);

        }
        catch (NumberFormatException ex)
        {
            showError(getString(R.string.wrongInput));
        }
        catch (IllegalArgumentException ex)
        {
            showError(getString(R.string.aMustNotBeZero));
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            showError("Fehleraufgetreten"+ex.getMessage());
        }
        //System.out.println(" ***** Danke fürs Drücken!");
        //Toast.makeText(this, "Danke fürs Drücken", Toast.LENGTH_LONG).show();

    }
}