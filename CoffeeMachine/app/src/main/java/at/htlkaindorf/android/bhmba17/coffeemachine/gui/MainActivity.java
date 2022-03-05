package at.htlkaindorf.android.bhmba17.coffeemachine.gui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import at.htlkaindorf.android.bhmba17.coffeemachine.data.Credits;
import at.htlkaindorf.android.bhmba17.coffeemachine.R;
import at.htlkaindorf.android.bhmba17.coffemachine.data.Coffee;

public class MainActivity extends AppCompatActivity
{
    private Credits credits = null;
    private void createRadioButtons()
    {
        final RadioGroup radioGroup = findViewById(R.id.radioGroup);
        for(Coffee coffee: Coffee.values())
        {
            final RadioButton radioButton = new RadioButton(this);
            radioButton.setText(coffee.getText());
            radioGroup.addView(radioButton);

            if(coffee.ordinal()==0)
                radioButton.setChecked(true);
        }
    }
    private void updateCredits()
    {
        final TextView tv0000 = findViewById(R.id.tv0000);
        tv0000.setText(String.format("%05.2f", credits.getCreditsInCents()/100.0));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createRadioButtons();
        credits = new Credits();
        credits.load(this);
        updateCredits();
    }

    // Handlermethode für Buttons
    public void onCoin(View view)
    {
        System.out.println("***** tag="+view.getTag().toString());
        final int coin = Integer.parseInt(view.getTag().toString());
        credits.addCreditsInCents(coin);
        updateCredits();
    }
}