package com.example.garrettp.myfinalproject;

import java.util.Random;
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
import android.support.design.widget.Snackbar;
import android.view.Menu;
import android.view.MenuItem;

public class Screen2 extends AppCompatActivity implements OnEditorActionListener, OnClickListener {

    int totalD3;
    int numD3;

    int totalD6;
    int numD6;

    int totalD8;
    int numD8;

    int totalD10;
    int numD10;

    int totalD12;
    int numD12;

    int numMod;

    int totalSum;
    String finalTotal = "";

    private Button Roll;
    private Button Reset;

    private ImageButton d3Up;
    private ImageButton d3Down;

    private ImageButton d6Up;
    private ImageButton d6Down;

    private ImageButton d8Up;
    private ImageButton d8Down;

    private ImageButton d10Up;
    private ImageButton d10Down;

    private ImageButton d12Up;
    private ImageButton d12Down;

    private ImageButton modUp;
    private ImageButton modDown;

    private TextView d3Dice;
    private TextView d6Dice;
    private TextView d8Dice;
    private TextView d10Dice;
    private TextView d12Dice;
    private TextView mod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);

        d3Dice = (TextView) findViewById(R.id.d3Dice);
        d6Dice = (TextView) findViewById(R.id.d6Dice);
        d8Dice = (TextView) findViewById(R.id.d8Dice);
        d10Dice = (TextView) findViewById(R.id.d10Dice);
        d12Dice = (TextView) findViewById(R.id.d12Dice);
        mod = (TextView) findViewById(R.id.mod);

        Roll = (Button) findViewById(R.id.Roll);
        Reset = (Button) findViewById(R.id.Reset);

        d3Up = (ImageButton) findViewById(R.id.d3Up);
        d3Down = (ImageButton) findViewById(R.id.d3Down);

        d6Up = (ImageButton) findViewById(R.id.d6Up);
        d6Down = (ImageButton) findViewById(R.id.d6Down);

        d8Up = (ImageButton) findViewById(R.id.d8Up);
        d8Down = (ImageButton) findViewById(R.id.d8Down);

        d10Up = (ImageButton) findViewById(R.id.d10Up);
        d10Down = (ImageButton) findViewById(R.id.d10Down);

        d12Up = (ImageButton) findViewById(R.id.d12Up);
        d12Down = (ImageButton) findViewById(R.id.d12Down);

        modUp = (ImageButton) findViewById(R.id.modUp);
        modDown = (ImageButton) findViewById(R.id.modDown);

        Roll.setOnClickListener(this);
        Reset.setOnClickListener(this);

        d3Up.setOnClickListener(this);
        d3Down.setOnClickListener(this);

        d6Up.setOnClickListener(this);
        d6Down.setOnClickListener(this);

        d8Up.setOnClickListener(this);
        d8Down.setOnClickListener(this);

        d10Up.setOnClickListener(this);
        d10Down.setOnClickListener(this);

        d12Up.setOnClickListener(this);
        d12Down.setOnClickListener(this);

        modUp.setOnClickListener(this);
        modDown.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.xml, menu);
        return true;
    }

    public int roll(int rolls, int sides){

        int total = 0;
        int num = 0;
        Random rand = new Random();
        for (int x = 0; x < rolls; x++){
            num = rand.nextInt(sides);
            num+=1;
            total = total + num;
        }
        return total;
    }

    public void reset(){
        totalD3 = 0;
        totalD6 = 0;
        totalD8 = 0;
        totalD10 = 0;
        totalD12 = 0;
        numD3 = 0;
        numD12 = 0;
        numD6 = 0;
        numD8 = 0;
        numD10 = 0;
        numMod = 0;
        d3Dice.setText(String.valueOf(numD3));
        d6Dice.setText(String.valueOf(numD6));
        d8Dice.setText(String.valueOf(numD8));
        d10Dice.setText(String.valueOf(numD10));
        d12Dice.setText(String.valueOf(numD12));
        mod.setText("+0");
    }

    public void snackTime(){
        final Snackbar snackBar = Snackbar.make(findViewById(R.id.myCoordinatorLayout), finalTotal, Snackbar.LENGTH_INDEFINITE);
        snackBar.setAction("Dismiss", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snackBar.dismiss();
            }
        });
        snackBar.show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.d3Up:
                numD3 = numD3 + 1;
                d3Dice.setText(String.valueOf(numD3));
                break;
            case R.id.d3Down:
                numD3 = numD3 - 1;
                if (numD3 < 0)
                    numD3 = 0;
                d3Dice.setText(String.valueOf(numD3));
                break;
            case R.id.d6Up:
                numD6 = numD6 + 1;
                d6Dice.setText(String.valueOf(numD6));
                break;
            case R.id.d6Down:
                numD6 = numD6 - 1;
                if (numD6 < 0)
                    numD6 = 0;
                d6Dice.setText(String.valueOf(numD6));
                break;
            case R.id.d8Up:
                numD8 = numD8 + 1;
                d8Dice.setText(String.valueOf(numD8));
                break;
            case R.id.d8Down:
                numD8 = numD8 - 1;
                if (numD8 < 0)
                    numD8 = 0;
                d8Dice.setText(String.valueOf(numD8));
                break;
            case R.id.d10Up:
                numD10 = numD10 + 1;
                d10Dice.setText(String.valueOf(numD10));
                break;
            case R.id.d10Down:
                numD10 = numD10 - 1;
                if (numD10 < 0)
                    numD10 = 0;
                d10Dice.setText(String.valueOf(numD10));
                break;
            case R.id.d12Up:
                numD12 = numD12 + 1;
                d12Dice.setText(String.valueOf(numD12));
                break;
            case R.id.d12Down:
                numD12 = numD12 - 1;
                if (numD12 < 0)
                    numD12 = 0;
                d12Dice.setText(String.valueOf(numD12));
                break;
            case R.id.modUp:
                numMod = numMod + 1;
                mod.setText(String.valueOf(numMod));
                break;
            case R.id.modDown:
                numMod = numMod - 1;
                mod.setText(String.valueOf(numMod));
                break;
            case R.id.Roll:
                if (numD3 > 0) {
                    totalD3 = roll(numD3, 3);
                }
                if (numD6 > 0) {
                    totalD6 = roll(numD6, 6);
                }
                if (numD8 > 0) {
                    totalD8 = roll(numD8, 8);
                }
                if (numD10 > 0) {
                    totalD10 = roll(numD10, 10);
                }
                if (numD12 > 0) {
                    totalD12 = roll(numD12, 12);
                }
                totalSum = totalD3 + totalD6 + totalD8 + totalD10 + totalD12 + numMod;
                finalTotal = "D3: " + totalD3 + "   D6: " + totalD6 + "   D8: " + totalD8
                + "   D10: " + totalD10 + "   D12: " + totalD12 + "   + " + numMod + "   Total: " + totalSum;
                snackTime();
                break;
            case R.id.Reset:
                reset();
                break;
            }
        }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_DONE ||
                actionId == EditorInfo.IME_ACTION_UNSPECIFIED) {
        }
        return false;
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
