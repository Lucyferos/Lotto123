package com.example.lotto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public Button bOblicz;
    protected EditText dzien;
    protected EditText miesiac;
    protected EditText rok;
    public EditText Wylosowana1;
    public EditText Wylosowana2;
    public EditText Wylosowana3;
    public EditText Wylosowana4;
    public EditText Wylosowana5;
    public EditText Wylosowana6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bOblicz = findViewById(R.id.wylosuj);
        bOblicz.setOnClickListener(this);
        dzien = findViewById(R.id.dzien);
        miesiac = findViewById(R.id.miesiac);
        rok = findViewById(R.id.rok);
        Wylosowana1 = findViewById(R.id.wylosowana1);
        Wylosowana2 = findViewById(R.id.wylosowana2);
        Wylosowana3 = findViewById(R.id.wylosowana3);
        Wylosowana4 = findViewById(R.id.wylosowana4);
        Wylosowana5 = findViewById(R.id.wylosowana5);
        Wylosowana6 = findViewById(R.id.wylosowana6);
    }

    @Override
    public void onClick(View v) {
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.fadein);
        Animation animation1 = AnimationUtils.loadAnimation(this,R.anim.sample_anim);

     bOblicz.startAnimation(animation);
        if (TextUtils.isEmpty(dzien.getText().toString())) {
            Toast.makeText(MainActivity.this, "Wprowadź datę urodzin!",
                    Toast.LENGTH_SHORT).show();
        }
           else if (TextUtils.isEmpty(miesiac.getText().toString())) {
            Toast.makeText(MainActivity.this, "Wprowadź datę urodzin!",
                    Toast.LENGTH_SHORT).show();
        }
           else  if (TextUtils.isEmpty(rok.getText().toString())) {
            Toast.makeText(MainActivity.this, "Wprowadź datę urodzin!",
                    Toast.LENGTH_SHORT).show();
        }
    Random generator = new Random();


    String bc;
    String Srok = rok.getText().toString().trim();

         String a = Srok.substring(0,2);
           Double aliczba= Double.parseDouble(a);
             int aliczbaInt = aliczba.intValue();


        String b = Srok.substring(2,4);
          Double bliczba =Double.parseDouble(b);
            int bliczbaInt = bliczba.intValue();


    if(aliczbaInt == bliczbaInt){
        while(aliczbaInt != 0){
            aliczbaInt = generator.nextInt(50);
        }
        String awynik = String.valueOf(aliczbaInt);
        Wylosowana1.setText(awynik);
        Wylosowana1.startAnimation(animation1);
    }
    else {
        String awynik = String.valueOf(aliczbaInt);
        Wylosowana1.setText(awynik);
        Wylosowana1.startAnimation(animation1);
    }


     if(bliczbaInt <= 49)
     {
         if(bliczba==0){
             while(bliczbaInt !=0){
                 bliczbaInt = generator.nextInt(50);
             }
             String bwynik = String.valueOf(bliczbaInt);
             Wylosowana2.setText(bwynik);
             Wylosowana2.startAnimation(animation1);
         }
         else {
             String bwynik = String.valueOf(bliczbaInt);
             Wylosowana2.setText(bwynik);
             Wylosowana2.startAnimation(animation1);
         }
     }
     else {
         while(bliczbaInt != 0) {
             bliczbaInt = generator.nextInt(50);
         }
         String bwynik = String.valueOf(bliczbaInt);
         Wylosowana2.setText(bwynik);
         Wylosowana2.startAnimation(animation1);
     }

       String sdzien = dzien.getText().toString().trim();
       int intDzien = Integer.valueOf(sdzien);
       if(intDzien == bliczbaInt&& intDzien !=0 ){
               intDzien = generator.nextInt(50);

       }
       String Sdzien = String.valueOf(intDzien);
       Wylosowana3.setText(Sdzien);
        Wylosowana3.startAnimation(animation1);
       String smiesiac = miesiac.getText().toString().trim();
       Double Dmiesiac = Double.parseDouble(smiesiac);
       int Intmiesiac = Dmiesiac.intValue();
       if(Intmiesiac == intDzien)
       {
           while(Intmiesiac !=0 ) {
               Intmiesiac = generator.nextInt(50);
           }
       }
       else if(Intmiesiac == aliczbaInt){
           while( Intmiesiac != 0){
               Intmiesiac = generator.nextInt(50);
           }
       }
       String Smiesiac = String.valueOf(Intmiesiac);
       Wylosowana4.setText(Smiesiac);
        Wylosowana4.startAnimation(animation1);
        //wypelniam pozostałe wartości losowymi liczbami
        int A =generator.nextInt(50),B;
        for(int z = 0 ;z<100;z++) {
            if (A != 0 && A != aliczbaInt && A != Intmiesiac && A != bliczbaInt && A != intDzien) {
                A = generator.nextInt(50);

                String sA = String.valueOf(A);
                Wylosowana5.setText(sA);
                Wylosowana5.startAnimation(animation1);
                break;
            }
        }
    for(int i =0;i<100;i++) {
        B = generator.nextInt(50);
        if (B != 0 && B != A && B != intDzien && B != Intmiesiac && B != aliczbaInt && B != bliczbaInt) {
            String sB = String.valueOf(B);
            Wylosowana6.setText(sB);
            Wylosowana6.startAnimation(animation1);
            break;
        }
    }

        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
    }
}

