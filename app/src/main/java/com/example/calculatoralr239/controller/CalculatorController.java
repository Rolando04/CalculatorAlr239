package com.example.calculatoralr239.controller;

import com.example.calculatoralr239.model.StackCalculator;
import com.example.calculatoralr239.model.NotEnoughArgumentsException;
import com.example.calculatoralr239.model.DivisionByZeroException;
import com.example.calculatoralr239.model.OverflowException;
import android.widget.TextView;

public class CalculatorController {

    private StackCalculator calculator;
    private TextView stackView;
    private TextView displayView;
    private DisplayState state;

    private enum DisplayState {
        INPUT, STACK, ERROR
    }

    public CalculatorController(StackCalculator calculator, TextView stackView, TextView displayView) {
        this.calculator = calculator;
        this.displayView = displayView;
        this.state = DisplayState.INPUT;
    }

    //controls the digits "0-9"
    public void onDigit(int digit){
        //checks if calculator is in INPUT state, if it is not, it clears the displayView and changes state to INPUT
        if (state != DisplayState.INPUT){
            displayView.setText("");
            state = DisplayState.INPUT;
        }
        //gets the current display
        String text = displayView.getText().toString().replace("_", "");

        //changes the text to an empty string if the first digits are 0
        if (text.equals("0")){
            text = "";
        }

        //adds the numbers together and updates the view
        text += digit;
        displayView.setText(text + "_");
    }

    //controls the "+/-" button
    public void onToggleSign(){
        //checks if the state is not in INPUT
        if (state != DisplayState.INPUT){
            //if there are no numbers, it does nothing
            if (calculator.isEmpty()){
                return;
            }
            //gets the last number, updates the view, and changes the state to INPUT
            displayView.setText(calculator.getLast() + "_");
            state = DisplayState.INPUT;
        }

        //If the state is in INPUT, gets the current display
        String text = displayView.getText().toString();
        //gets rid of the ending "_"
        if (text.endsWith("_")){
            text = text.substring(0, text.length() - 1);
        }

        //checks if the input is negative. If it is, changes the value to positive. If it is positive, adds a "-"
        if (text.startsWith("-")){
            text = text.substring(1);
        }
        else {
            text = "-" + text;
        }
        //updates the view
        displayView.setText(text + "_");
    }

    //controls the Enter button
    public void onEnter() {
        //checks if the state is in INPUT
        if (state == DisplayState.INPUT){
            //gets the current displayView, and gets rid of the ending "_" if any.
            String text = displayView.getText().toString();
            if (text.endsWith("_")){
                text = text.substring(0, text.length()-1);
            }

            //converts the test into an integer, adds it to the stack, changes the state to STACK
            try {
                int value = Integer.parseInt(text);
                calculator.addLast(value);
                state = DisplayState.STACK;
                updateViews();
                //if it could not change the input to an integer, throw an error
            } catch (NumberFormatException e){
                state = DisplayState.ERROR;
                displayView.setText("Overflow");
            }
            //if the state was in STACK mode, adds the last number in the stack again
        } else if (state == DisplayState.STACK){
            int top = calculator.getLast();
            calculator.addLast(top);
            updateViews();
        }
    }

    //controls the clear button, clears the stack, updates the views
    public void onClear(){
        calculator.clear();
        state = DisplayState.INPUT;
        stackView.setText("");
        displayView.setText("0_");
    }

    public void performOperation(Operation op) {
        if (state == DisplayState.INPUT) {
            try {
                int value = Integer.parseInt(displayView.getText().toString().replace("_", ""));
                calculator.push(value);
            } catch (NumberFormatException e) {
                displayView.setText("Overflow");
                state = DisplayState.ERROR;
                return;
            }
        }

        try {
            op.apply();
            displayView.setText(String.valueOf(calculator.peek()));
            state = DisplayState.STACK;
        } catch (NotEnoughArgumentsException e) {
            displayView.setText("Not enough args");
            state = DisplayState.ERROR;
        } catch (OverflowException e) {
            displayView.setText("Overflow");
            state = DisplayState.ERROR;
        } catch (DivisionByZeroException e) {
            displayView.setText("Division by 0");
            state = DisplayState.ERROR;
        }
    }

    //updates the displayView
    private void updateViews() {
        String text = "";
        //creates a string with all the values in the stack, with a whitespace between them
        for (Integer val : calculator) {
            text = text + val + " ";
        }
        //gets rid of the last space
        stackView.setText(text.trim());
        //if the calculator was is STACK mode and the calculator was not empty, change the display to the last number in the stack
        if (state == DisplayState.STACK && !calculator.isEmpty()) {
            displayView.setText(calculator.getLast());
        }
    }
}



