package at.htlkaindorf.bhmba17.traussnigg.meineersteandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;

public class ShowTextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        final TextView textview = new TextView(this);
        textview.setText("HALLO");
        textview.setGravity(Gravity.CENTER);
        textview.setTextSize(48);
        textview.setTextColor(Color.RED);
        textview.setBackgroundColor(0xFFFFFF00);
        setContentView(textview);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}