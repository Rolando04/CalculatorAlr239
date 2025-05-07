package com.example.calculatoralr239.model;

import java.util.LinkedList;

public class StackCalculator extends LinkedList<Integer> {

    public LinkedList<Integer> stack;

    public StackCalculator(){
        stack = new LinkedList<>();
    }

    public void add(){
        if(stack.size() < 2){
            throw new NotEnoughArgumentsException("Not Enough Arguments");
        }
        Integer source1 = stack.pop();
        Integer source2 = stack.pop();

        try{
            Integer sum = Math.addExact(source1,source2);
            stack.push(sum);
        }catch (ArithmeticException e){
            stack.push(source1);
            stack.push(source2);
            throw new OverflowException("Overflow Encountered");
        }
    }

    public void subtract(){
        if(stack.size() < 2){
            throw new NotEnoughArgumentsException("Not Enough Arguments");
        }
        Integer source2 = stack.pop();
        Integer source1 = stack.pop();

        try{
            Integer total = Math.subtractExact(source1,source2);
            stack.push(total);
        }catch (ArithmeticException e){
            stack.push(source1);
            stack.push(source2);
            throw new OverflowException("Overflow Encountered");
        }
    }

    public void multiply(){
        if(stack.size() < 2){
            throw new NotEnoughArgumentsException("Not Enough Arguments");
        }
        Integer source2 = stack.pop();
        Integer source1 = stack.pop();

        try{
            Integer total = Math.multiplyExact(source1,source2);
            stack.push(total);
        }catch (ArithmeticException e){
            stack.push(source1);
            stack.push(source2);
            throw new OverflowException("Overflow Encountered");
        }
    }

    public void divide(){
        if(stack.size() < 2){
            throw new NotEnoughArgumentsException("Not Enough Arguments");
        }
        Integer source2 = stack.pop();
        Integer source1 = stack.pop();
        if(source2 == 0){
            stack.push(source1);
            stack.push(source2);
            throw new DivisionByZeroException("Cannot Divide by 0");
        }

        try{
            Integer total = Math.divideExact(source1,source2);
            stack.push(total);
        }catch (ArithmeticException e){
            stack.push(source1);
            stack.push(source2);
            throw new OverflowException("Overflow Encountered");
        }

    }

    public void combine(){

    }

}
