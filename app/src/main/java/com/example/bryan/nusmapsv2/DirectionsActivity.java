package com.example.bryan.nusmapsv2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DirectionsActivity extends AppCompatActivity {

    private EditText editOrigin;
    private EditText editDestination;
    private Button btnWalk;
    public static final int test = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directions);

        editOrigin = (EditText) findViewById(R.id.editFrom);
        editDestination = (EditText) findViewById(R.id.editTo);
        btnWalk = (Button) findViewById(R.id.buttonWalk);

        btnWalk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ("".equals(editOrigin.getText().toString().trim())) {
                    Toast.makeText(DirectionsActivity.this, "Enter the starting point", Toast.LENGTH_SHORT).show();
                }
                else if ("".equals(editDestination.getText().toString().trim())) {
                    Toast.makeText(DirectionsActivity.this, "Enter the destination point", Toast.LENGTH_SHORT).show();
                }
                else {
                    final Intent intent = new Intent(DirectionsActivity.this, MapsActivity.class); //if both starting point and destination not empty, create intent to mapsactivity
                    intent.putExtra("FROM", editOrigin.getText().toString().trim());
                    intent.putExtra("TO", editDestination.getText().toString().trim());
                    intent.putExtra("TEST", test);

                    DirectionsActivity.this.startActivity(intent);
                }
            }
        });
    }
}
