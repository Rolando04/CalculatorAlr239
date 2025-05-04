package com.example.calculatoralr239.controller;

import android.view.View;
import android.widget.Button;

public class ButtonListener implements View.OnClickListener {

    Button curButton;
    String buttonString;

    public ButtonListener(Button curButton, String buttonString) {
        this.curButton = curButton;
        this.buttonString = buttonString;
    }

    @Override
    public void onClick(View v) {
        if(buttonString.equals("+")){ //Pushes to stack

        }else if(buttonString.equals("-")){ //Pushes to stack

        }else if(buttonString.equals("*")){ //Pushes to stack

        }else if(buttonString.equals("/")){ //Pushes to stack

        }else if(buttonString.equals("Enter")){ //Calls a calculate method

        }else if(buttonString.equals("Clear")){ // Empties the entirety of the stack

        }else if(buttonString.equals("+/-")){ //Multiplies the value by -1

        }else{ //Pushes a number to the stack or makes a new string for a value

        }
    }
}
