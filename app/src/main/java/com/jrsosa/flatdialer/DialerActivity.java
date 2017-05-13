package com.jrsosa.flatdialer;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class DialerActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {

    private static final int REQUEST_CALL_PHONE = 200;
    TextView input;
    FloatingActionButton makeCallButton, one, two, three, four, five, six, seven, eight, nine, zero;
    ImageButton delete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialer);

        bindViews();
        setListeners();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dialer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private void bindViews() {
        input = (TextView) findViewById(R.id.input_text_view);
        makeCallButton = (FloatingActionButton) findViewById(R.id.make_call_button);
        one = (FloatingActionButton) findViewById(R.id.number_one_button);
        two = (FloatingActionButton) findViewById(R.id.number_two_button);
        three = (FloatingActionButton) findViewById(R.id.number_three_button);
        four = (FloatingActionButton) findViewById(R.id.number_four_button);
        five = (FloatingActionButton) findViewById(R.id.number_five_button);
        six = (FloatingActionButton) findViewById(R.id.number_six_button);
        seven = (FloatingActionButton) findViewById(R.id.number_seven_button);
        eight = (FloatingActionButton) findViewById(R.id.number_eight_button);
        nine = (FloatingActionButton) findViewById(R.id.number_nine_button);
        zero = (FloatingActionButton) findViewById(R.id.number_zero_button);
        delete = (ImageButton) findViewById(R.id.delete_button);
    }

    private void setListeners() {
        makeCallButton.setOnClickListener(this);
        delete.setOnClickListener(this);
        delete.setOnLongClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        zero.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        try {

            if (id == delete.getId()) {
                deleteLastCharFromInputAndSetNewValue();
            } else if (id == one.getId())
                input.append("1");
            else if (id == two.getId())
                input.append("2");
            else if (id == three.getId())
                input.append("3");
            else if (id == four.getId())
                input.append("4");
            else if (id == five.getId())
                input.append("5");
            else if (id == six.getId())
                input.append("6");
            else if (id == seven.getId())
                input.append("7");
            else if (id == eight.getId())
                input.append("8");
            else if (id == nine.getId())
                input.append("9");
            else if (id == zero.getId())
                input.append("0");
            else if (id == makeCallButton.getId()) {
                checkIfWeHaveMinPermissionsAndCall();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void checkIfWeHaveMinPermissionsAndCall() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    REQUEST_CALL_PHONE);

        }
    }

    @SuppressWarnings("MissingPermission")
    private void makeCallWithAvailableInput() {
        try {

            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel: " + input.getText().toString().trim()));
            startActivity(intent);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CALL_PHONE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    makeCallWithAvailableInput();

                } else {
                    Toast.makeText(this, "We need permission to call other phones from this dialer",
                            Toast.LENGTH_SHORT).show();
                }
                return;
            }
        }
    }


    private void deleteLastCharFromInputAndSetNewValue() {

        int curLength = input.getText().length();

        if (curLength == 0)
            return;

        input.setText(input.getText().toString().substring(0, curLength - 1));
    }

    @Override
    public boolean onLongClick(View v) {

        if (v.getId() == delete.getId())
            input.setText("");

        return true;
    }
}
