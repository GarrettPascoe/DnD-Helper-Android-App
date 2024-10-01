package com.example.garrettp.myfinalproject;

import java.text.NumberFormat;
import java.security.SecureRandom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.design.widget.Snackbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements OnEditorActionListener, OnClickListener {

    // define variables for the widgets
    private TextView DefStat;
    private TextView StrStat;
    private TextView DexStat;
    private TextView ConStat;
    private TextView IntStat;
    private TextView WisStat;
    private TextView ChaStat;
    private ImageButton   DefUpButton;
    private ImageButton   DefDownButton;
    private ImageButton   StrUpButton;
    private ImageButton   StrDownButton;
    private ImageButton   DexUpButton;
    private ImageButton   DexDownButton;
    private ImageButton   ConUpButton;
    private ImageButton   ConDownButton;
    private ImageButton   IntUpButton;
    private ImageButton   IntDownButton;
    private ImageButton   WisUpButton;
    private ImageButton   WisDownButton;
    private ImageButton   ChaUpButton;
    private ImageButton   ChaDownButton;
    private Button   TapButton1;
    private Button   TapButton2;
    private Button   TapButton3;
    private Button   TapButton4;
    private Button   TapButton5;
    private Button   TapButton6;
    private Button   TapButton7;


    // define the SharedPreferences object
    private SharedPreferences savedValues;
    
    private int DefValue = 0;
    private int StrValue = 0;
    private int DexValue = 0;
    private int ConValue = 0;
    private int IntValue = 0;
    private int WisValue = 0;
    private int ChaValue = 0;

    private int placeholder = 0;
    private String result = "";

    SecureRandom randomNumbers = new SecureRandom();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get references to the widgets
        DefStat = (TextView) findViewById(R.id.DefStat);
        StrStat = (TextView) findViewById(R.id.StrStat);
        DexStat = (TextView) findViewById(R.id.DexStat);
        ConStat = (TextView) findViewById(R.id.ConStat);
        IntStat = (TextView) findViewById(R.id.IntStat);
        WisStat = (TextView) findViewById(R.id.WisStat);
        ChaStat = (TextView) findViewById(R.id.ChaStat);
        DefUpButton = (ImageButton) findViewById(R.id.DefUpButton);
        DefDownButton = (ImageButton) findViewById(R.id.DefDownButton);
        StrUpButton = (ImageButton) findViewById(R.id.StrUpButton);
        StrDownButton = (ImageButton) findViewById(R.id.StrDownButton);
        DexUpButton = (ImageButton) findViewById(R.id.DexUpButton);
        DexDownButton = (ImageButton) findViewById(R.id.DexDownButton);
        ConUpButton = (ImageButton) findViewById(R.id.ConUpButton);
        ConDownButton = (ImageButton) findViewById(R.id.ConDownButton);
        IntUpButton = (ImageButton) findViewById(R.id.IntUpButton);
        IntDownButton = (ImageButton) findViewById(R.id.IntDownButton);
        WisUpButton = (ImageButton) findViewById(R.id.WisUpButton);
        WisDownButton = (ImageButton) findViewById(R.id.WisDownButton);
        ChaUpButton = (ImageButton) findViewById(R.id.ChaUpButton);
        ChaDownButton = (ImageButton) findViewById(R.id.ChaDownButton);
        TapButton1 = (Button) findViewById(R.id.TapButton1);
        TapButton2 = (Button) findViewById(R.id.TapButton2);
        TapButton3 = (Button) findViewById(R.id.TapButton3);
        TapButton4 = (Button) findViewById(R.id.TapButton4);
        TapButton5 = (Button) findViewById(R.id.TapButton5);
        TapButton6 = (Button) findViewById(R.id.TapButton6);
        TapButton7 = (Button) findViewById(R.id.TapButton7);

        // set the listeners
        DefUpButton.setOnClickListener(this);
        DefDownButton.setOnClickListener(this);
        StrUpButton.setOnClickListener(this);
        StrDownButton.setOnClickListener(this);
        DexUpButton.setOnClickListener(this);
        DexDownButton.setOnClickListener(this);
        ConUpButton.setOnClickListener(this);
        ConDownButton.setOnClickListener(this);
        IntUpButton.setOnClickListener(this);
        IntDownButton.setOnClickListener(this);
        WisUpButton.setOnClickListener(this);
        WisDownButton.setOnClickListener(this);
        ChaUpButton.setOnClickListener(this);
        ChaDownButton.setOnClickListener(this);
        TapButton1.setOnClickListener(this);
        TapButton2.setOnClickListener(this);
        TapButton3.setOnClickListener(this);
        TapButton4.setOnClickListener(this);
        TapButton5.setOnClickListener(this);
        TapButton6.setOnClickListener(this);
        TapButton7.setOnClickListener(this);

        savedValues = getSharedPreferences("SavedValues", MODE_PRIVATE);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.xml, menu);
        return true;
    }

    @Override
    public void onPause() {
        Editor editor = savedValues.edit();
        editor.putInt("DefValue", DefValue);
        editor.putInt("StrValue", StrValue);
        editor.putInt("DexValue", DexValue);
        editor.putInt("ConValue", ConValue);
        editor.putInt("IntValue", IntValue);
        editor.putInt("WisValue", WisValue);
        editor.putInt("ChaValue", ChaValue);
        editor.commit();

        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();

        DefValue = savedValues.getInt("DefValue", DefValue);
        StrValue = savedValues.getInt("StrValue", StrValue);
        DexValue = savedValues.getInt("DexValue", DexValue);
        ConValue = savedValues.getInt("ConValue", ConValue);
        IntValue = savedValues.getInt("IntValue", IntValue);
        WisValue = savedValues.getInt("WisValue", WisValue);
        ChaValue = savedValues.getInt("ChaValue", ChaValue);

        DefStat.setText(String.valueOf(DefValue));
        StrStat.setText(String.valueOf(StrValue));
        DexStat.setText(String.valueOf(DexValue));
        ConStat.setText(String.valueOf(ConValue));
        IntStat.setText(String.valueOf(IntValue));
        WisStat.setText(String.valueOf(WisValue));
        ChaStat.setText(String.valueOf(ChaValue));

        calculateAndDisplay();
    }

    public void calculateAndDisplay() {

        DefStat.setText(String.valueOf(DefValue));
        StrStat.setText(String.valueOf(StrValue));
        DexStat.setText(String.valueOf(DexValue));
        ConStat.setText(String.valueOf(ConValue));
        IntStat.setText(String.valueOf(IntValue));
        WisStat.setText(String.valueOf(WisValue));
        ChaStat.setText(String.valueOf(ChaValue));
    }

    public void rollAndDisplay() {

        int rand = 1 + randomNumbers.nextInt(20);

        if (placeholder == 1)
            result = String.valueOf(rand + DefValue);
        else if (placeholder == 2)
            result = String.valueOf(rand + StrValue);
        else if (placeholder == 3)
            result = String.valueOf(rand + DexValue);
        else if (placeholder == 4)
            result = String.valueOf(rand + ConValue);
        else if (placeholder == 5)
            result = String.valueOf(rand + IntValue);
        else if (placeholder == 6)
            result = String.valueOf(rand + WisValue);
        else if (placeholder == 7)
            result = String.valueOf(rand + ChaValue);

        if (rand == 1)
            result = "Crit Fail!";
        else if (rand == 20)
            result = "Crit!";

        snackTime();
    }

    public void snackTime(){
        final Snackbar snackBar = Snackbar.make(findViewById(R.id.myCoordinatorLayout), result, Snackbar.LENGTH_INDEFINITE);
        snackBar.setAction("Dismiss", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snackBar.dismiss();
            }
        });
        snackBar.show();
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_DONE ||
                actionId == EditorInfo.IME_ACTION_UNSPECIFIED) {
            calculateAndDisplay();
        }
        return false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.DefUpButton:
                DefValue = DefValue + 1;
                calculateAndDisplay();
                break;
            case R.id.DefDownButton:
                DefValue = DefValue - 1;
                calculateAndDisplay();
                break;
            case R.id.StrUpButton:
                StrValue = StrValue + 1;
                calculateAndDisplay();
                break;
            case R.id.StrDownButton:
                StrValue = StrValue - 1;
                calculateAndDisplay();
                break;
            case R.id.DexUpButton:
                DexValue = DexValue + 1;
                calculateAndDisplay();
                break;
            case R.id.DexDownButton:
                DexValue = DexValue - 1;
                calculateAndDisplay();
                break;
            case R.id.ConUpButton:
                ConValue = ConValue + 1;
                calculateAndDisplay();
                break;
            case R.id.ConDownButton:
                ConValue = ConValue - 1;
                calculateAndDisplay();
                break;
            case R.id.IntUpButton:
                IntValue = IntValue + 1;
                calculateAndDisplay();
                break;
            case R.id.IntDownButton:
                IntValue = IntValue - 1;
                calculateAndDisplay();
                break;
            case R.id.WisUpButton:
                WisValue = WisValue + 1;
                calculateAndDisplay();
                break;
            case R.id.WisDownButton:
                WisValue = WisValue - 1;
                calculateAndDisplay();
                break;
            case R.id.ChaUpButton:
                ChaValue = ChaValue + 1;
                calculateAndDisplay();
                break;
            case R.id.ChaDownButton:
                ChaValue = ChaValue - 1;
                calculateAndDisplay();
                break;
            case R.id.TapButton1:
                placeholder = 1;
                rollAndDisplay();
                break;
            case R.id.TapButton2:
                placeholder = 2;
                rollAndDisplay();
                break;
            case R.id.TapButton3:
                placeholder = 3;
                rollAndDisplay();
                break;
            case R.id.TapButton4:
                placeholder = 4;
                rollAndDisplay();
                break;
            case R.id.TapButton5:
                placeholder = 5;
                rollAndDisplay();
                break;
            case R.id.TapButton6:
                placeholder = 6;
                rollAndDisplay();
                break;
            case R.id.TapButton7:
                placeholder = 7;
                rollAndDisplay();
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.Screen1:
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                return true;
            case R.id.Screen2:
                startActivity(new Intent(getApplicationContext(), Screen2.class));
                return true;
            case R.id.Screen3:
                startActivity(new Intent(getApplicationContext(), Screen3.class));
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
