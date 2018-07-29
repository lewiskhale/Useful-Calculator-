package com.khalelewis.android.simplecalculator;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView display;
    Button button1,button2,button3,button4,button5,button6,button7,button8,button9,button0,buttonCancel,buttonEqual,buttonplus,buttonminus,buttontimes,buttondiv,buttonpoint;
    private double firstAmount, secondAmount;
    private String sign;
    private boolean hasPoint = false;

    @Override
    public void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Start of id for buttons
        display = (TextView) findViewById(R.id.display);

        button0 = (Button) findViewById(R.id.b0);
        button1 = (Button) findViewById(R.id.b1);
        button2 = (Button) findViewById(R.id.b2);
        button3 = (Button) findViewById(R.id.b3);
        button4 = (Button) findViewById(R.id.b4);
        button5 = (Button) findViewById(R.id.b5);
        button6 = (Button) findViewById(R.id.b6);
        button7 = (Button) findViewById(R.id.b7);
        button8 = (Button) findViewById(R.id.b8);
        button9 = (Button) findViewById(R.id.b9);
        buttonCancel = (Button) findViewById(R.id.clear);
        buttonEqual = (Button) findViewById(R.id.equal);
        buttonplus = (Button) findViewById(R.id.plus);
        buttonminus = (Button) findViewById(R.id.minus);
        buttontimes = (Button) findViewById(R.id.times);
        buttondiv = (Button) findViewById(R.id.divide);
        buttonpoint = (Button) findViewById(R.id.point);

        //End of id for buttons

        //Start of Numbered Button Function

    }

    public void onResume(){
        super.onResume();

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText()+"0");
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText()+"1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText()+"2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText()+"3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText()+"4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText()+"5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText()+"6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText()+"7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText()+"8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText()+"9");
            }
        });

        //End of Numbered Button Function


        //Start other button functions
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstAmount = 0;
                secondAmount = 0;
                display.setText("");
                hasPoint = false;
                sign = "";
            }
        });

        buttondiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!display.getText().toString().equals("")) {
                    firstAmount = Double.parseDouble(display.getText().toString());
                    display.setText("");
                    sign = "/";
                    hasPoint = false;
                }
            }
        });

        buttonplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!display.getText().toString().equals("")) {
                    firstAmount = Double.parseDouble(display.getText().toString());
                    display.setText("");
                    sign = "+";
                }
            }
        });

        buttonpoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!display.getText().toString().equals("")) {
                    if (hasPoint == false)
                        display.setText(display.getText() + ".");
                }
                hasPoint = true;
            }
        });

        buttontimes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!display.getText().toString().equals("")) {
                    firstAmount = Double.parseDouble(display.getText().toString());
                    display.setText("");
                    sign = "*";
                }
            }
        });

        buttonminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!display.getText().toString().equals("")) {
                    firstAmount = Double.parseDouble(display.getText().toString());
                    display.setText("");
                    sign = "-";
                }
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!display.getText().toString().equals("")) {
                    secondAmount = Double.parseDouble(display.getText().toString());
                    if (sign != null) {
                        Calculate();
                    }
                }
            }
        });
        //End of Other Button Functions
    }

    public void Calculate(){
        double answer;
        switch(sign){
            case "+":
                 answer = firstAmount + secondAmount;
                if(isInteger(answer))
                    display.setText((int) answer+"");
                else
                    display.setText(answer+"");
                break;

            case "-":
                answer = firstAmount - secondAmount;
                if(isInteger(answer))
                    display.setText((int) answer+"");
                else
                    display.setText(answer+"");
                break;

            case "*":
                answer = firstAmount * secondAmount;
                if(isInteger(answer))
                    display.setText((int) answer+"");
                else
                    display.setText(answer+"");
                break;

            case "/":
                answer = firstAmount/secondAmount;
                if(isInteger(answer))
                    display.setText((int) answer+"");
                else
                    display.setText(answer+"");
                break;
        }
    }

    public boolean isInteger(double answer){
        if(answer == (int) answer)
            return true;
        return false;
    }
}
