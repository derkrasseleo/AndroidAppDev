package at.htlkaindorf.bhmba17.traussnigg.meineersteandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLOutput;

import at.htlkaindorf.bhmba17.traussnigg.meineersteandroidapp.R;
import at.htlkaindorf.bhmba17.traussnigg.meineersteandroidapp.ShowTextActivity;

public class MainActivity extends AppCompatActivity {

    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSenden(View view) // View=Controll
    {
        final EditText editText = findViewById(R.id.etEingabe);
        final String text = editText.getText().toString();
        //System.out.println("******HALLO!!!!");
        Toast
                .makeText(this, "Danke fürs drücken:)",Toast.LENGTH_LONG).show();
        final Intent intent = new Intent(this, ShowTextActivity.class);
    }
}