package com.example.garrettp.myfinalproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.view.Menu;
import android.view.MenuItem;

public class Screen3 extends AppCompatActivity {

    private TextView level1;
    private TextView level2;
    private TextView level3;
    private TextView level4;
    private TextView level5;
    private TextView level6;
    private TextView level7;
    private TextView level8;
    private TextView level9;
    private TextView level10;
    int counter1 = 0;
    int counter2 = 0;
    int counter3 = 0;
    int counter4 = 0;
    int counter5 = 0;
    int counter6 = 0;
    int counter7 = 0;
    int counter8 = 0;
    int counter9 = 0;
    int counter10 = 0;

    private SharedPreferences savedValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen3);


        level1 = (TextView) findViewById(R.id.level1);
        level2 = (TextView) findViewById(R.id.level2);
        level3 = (TextView) findViewById(R.id.level3);
        level4 = (TextView) findViewById(R.id.level4);
        level5 = (TextView) findViewById(R.id.level5);
        level6 = (TextView) findViewById(R.id.level6);
        level7 = (TextView) findViewById(R.id.level7);
        level8 = (TextView) findViewById(R.id.level8);
        level9 = (TextView) findViewById(R.id.level9);
        level10 = (TextView) findViewById(R.id.level10);

        savedValues = getSharedPreferences("SavedValues", MODE_PRIVATE);
    }

    @Override
    public void onPause() {
        SharedPreferences.Editor editor = savedValues.edit();
        editor.putInt("counter1", counter1);
        editor.putInt("counter2", counter2);
        editor.putInt("counter3", counter3);
        editor.putInt("counter4", counter4);
        editor.putInt("counter5", counter5);
        editor.putInt("counter6", counter6);
        editor.putInt("counter7", counter7);
        editor.putInt("counter8", counter8);
        editor.putInt("counter9", counter9);
        editor.putInt("counter10", counter10);
        editor.commit();

        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();

        counter1 = savedValues.getInt("counter1", counter1);
        counter2 = savedValues.getInt("counter2", counter2);
        counter3 = savedValues.getInt("counter3", counter3);
        counter4 = savedValues.getInt("counter4", counter4);
        counter5 = savedValues.getInt("counter5", counter5);
        counter6 = savedValues.getInt("counter6", counter6);
        counter7 = savedValues.getInt("counter7", counter7);
        counter8 = savedValues.getInt("counter8", counter8);
        counter9 = savedValues.getInt("counter9", counter9);
        counter10 = savedValues.getInt("counter10", counter10);

        level1.setText(String.valueOf(counter1));
        level2.setText(String.valueOf(counter2));
        level3.setText(String.valueOf(counter3));
        level4.setText(String.valueOf(counter4));
        level5.setText(String.valueOf(counter5));
        level6.setText(String.valueOf(counter6));
        level7.setText(String.valueOf(counter7));
        level8.setText(String.valueOf(counter8));
        level9.setText(String.valueOf(counter9));
        level10.setText(String.valueOf(counter10));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.xml, menu);
        return true;
    }

    public void countP1(View view) {
        counter1++;
        level1.setText(Integer.toString(counter1));
    }

    public void countM1(View view) {
        if (counter1 > 0)
            counter1--;
        level1.setText(Integer.toString(counter1));
    }

    public void countP2(View view) {
        counter2++;
        level2.setText(Integer.toString(counter2));
    }

    public void countM2(View view) {
        if (counter2 > 0)
            counter2--;
        level2.setText(Integer.toString(counter2));
    }

    public void countP3(View view) {
        counter3++;
        level3.setText(Integer.toString(counter3));
    }

    public void countM3(View view) {
        if (counter3 > 0)
            counter3--;
        level3.setText(Integer.toString(counter3));
    }

    public void countP4(View view) {
        counter4++;
        level4.setText(Integer.toString(counter4));
    }

    public void countM4(View view) {
        if (counter4 > 0)
            counter4--;
        level4.setText(Integer.toString(counter4));
    }

    public void countP5(View view) {
        counter5++;
        level5.setText(Integer.toString(counter5));
    }

    public void countM5(View view) {
        if (counter5 > 0)
            counter5--;
        level5.setText(Integer.toString(counter5));
    }

    public void countP6(View view) {
        counter6++;
        level6.setText(Integer.toString(counter6));
    }

    public void countM6(View view) {
        if (counter6 > 0)
            counter6--;
        level6.setText(Integer.toString(counter6));
    }

    public void countP7(View view) {
        counter7++;
        level7.setText(Integer.toString(counter7));
    }

    public void countM7(View view) {
        if (counter7 > 0)
            counter7--;
        level7.setText(Integer.toString(counter7));
    }

    public void countP8(View view) {
        counter8++;
        level8.setText(Integer.toString(counter8));
    }

    public void countM8(View view) {
        if (counter8 > 0)
            counter8--;
        level8.setText(Integer.toString(counter8));
    }

    public void countP9(View view) {
        counter9++;
        level9.setText(Integer.toString(counter9));
    }

    public void countM9(View view) {
        if (counter9 > 0)
            counter9--;
        level9.setText(Integer.toString(counter9));
    }

    public void countP10(View view) {
        counter10++;
        level10.setText(Integer.toString(counter10));
    }

    public void countM10(View view) {
        if (counter10 > 0)
            counter10--;
        level10.setText(Integer.toString(counter10));
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
