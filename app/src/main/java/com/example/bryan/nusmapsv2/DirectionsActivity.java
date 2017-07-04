package com.example.bryan.nusmapsv2;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class DirectionsActivity extends AppCompatActivity {

    private EditText editOrigin;
    private EditText editDestination;
    private Button btnWalk;
    public static final int test = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directions);

        editOrigin = (EditText) findViewById(R.id.startingPoint);
        editDestination = (EditText) findViewById(R.id.destination);
        btnWalk = (Button) findViewById(R.id.walk);

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

    public static class TimePickerFragment extends DialogFragment
            implements TimePickerDialog.OnTimeSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current time as the default values for the picker
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            // Create a new instance of TimePickerDialog and return it
            return new TimePickerDialog(getActivity(), this, hour, minute,
                    DateFormat.is24HourFormat(getActivity()));
        }

        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            // Do something with the time chosen by the user
        }
    }

    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }
}
