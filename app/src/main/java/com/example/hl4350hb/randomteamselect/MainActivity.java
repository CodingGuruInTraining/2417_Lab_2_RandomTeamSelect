package com.example.hl4350hb.randomteamselect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button mSelectButton;
    EditText mTeam1Text;
    EditText mTeam2Text;
    TextView mResultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // References widgets.
        mTeam1Text = (EditText) findViewById(R.id.team1name);
        mTeam2Text = (EditText) findViewById(R.id.team2name);
        mSelectButton = (Button) findViewById(R.id.selectrandombutton);
        mResultTextView = (TextView) findViewById(R.id.resulttextview);

        // Creates a click event for button.
        mSelectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Grabs values from EditText widgets.
                String team1Value = mTeam1Text.getText().toString();
                String team2Value = mTeam2Text.getText().toString();

                // Compares values to see if any fields were left blank.
                if (team1Value == null || team2Value == null || team1Value.equals("") || team2Value.equals("")) {
                    // Displays Toast if a field is empty.
                    Toast.makeText(MainActivity.this, "You need two teams entered!", Toast.LENGTH_LONG).show();
                }
                else {
                    // Randomly selects a team and displays the results.
                    int random = new Random().nextInt(2);
                    switch (random) {
                        case 0:
                            mResultTextView.setText(team1Value);
                            break;
                        case 1:
                            mResultTextView.setText(team2Value);
                    }
                }
            }
        });
    }
}
