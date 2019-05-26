package com.ericlam.mc.bungee.hnmc.builders;

import com.ericlam.mc.bungee.hnmc.builders.function.Calculation;

public class CalculationBuilder {
    private double result;

    public CalculationBuilder(double result) {
        this.result = result;
    }

    public CalculationBuilder add(double add) {
        this.result += add;
        return this;
    }

    public CalculationBuilder minus(double minus) {
        this.result -= minus;
        return this;
    }

    public CalculationBuilder multiply(double multiply) {
        this.result *= multiply;
        return this;
    }

    public CalculationBuilder divide(double divide) {
        this.result /= divide;
        return this;
    }

    public CalculationBuilder pow(double pow) {
        this.result = Math.pow(this.result, pow);
        return this;
    }

    public CalculationBuilder sqrt() {
        this.result = Math.sqrt(this.result);
        return this;
    }

    public CalculationBuilder pi() {
        this.result *= Math.PI;
        return this;
    }

    public CalculationBuilder roundDown() {
        this.result = Math.floor(this.result);
        return this;
    }

    public CalculationBuilder round() {
        this.result = Math.round(this.result);
        return this;
    }

    public CalculationBuilder roundUp() {
        this.result = Math.ceil(this.result);
        return this;
    }

    public CalculationBuilder doOther(Calculation calculate) {
        this.result = calculate.cal(this.result);
        return this;
    }


    public double getResult() {
        return result;
    }
}
