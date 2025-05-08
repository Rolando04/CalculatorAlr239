package com.example.calculatoralr239.view;

import android.widget.Button;
import android.widget.TextView;

public class CalculatorView {

    private Button[][] numberPad;
    private Button[] symbols;
    private TextView stackNums;
    private TextView current;


    public CalculatorView(Button[][] numberPad, Button[] symbols, TextView stackNums, TextView current){

        this.numberPad = numberPad;
        this.symbols = symbols;
        this.stackNums = stackNums;
        this.current = current;

        int count = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++) {

                count++;
                this.numberPad[i][j].setText(count);

            }
        }

        this.numberPad[3][0].setText("+/-");
        this.numberPad[3][1].setText("0");
        this.numberPad[3][2].setText("Enter");

        this.symbols[0].setText("Clear");
        this.symbols[1].setText("+");
        this.symbols[2].setText("-");
        this.symbols[3].setText("X");
        this.symbols[4].setText("/");

    }

    public void clear(){

    }

}


