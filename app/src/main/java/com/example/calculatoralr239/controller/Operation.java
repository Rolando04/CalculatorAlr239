package com.example.calculatoralr239.controller;

import com.example.calculatoralr239.model.DivisionByZeroException;
import com.example.calculatoralr239.model.OverflowException;
import com.example.calculatoralr239.model.NotEnoughArgumentsException;

public interface Operation {
    void apply() throws NotEnoughArgumentsException, OverflowException, DivisionByZeroException;
}
