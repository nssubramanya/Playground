package com.subbu.java;

public class Calculator implements ICalculator {

	@Override
	public double add(double a, double b) {
		// TODO Auto-generated method stub
		return a+b;
	}

	@Override
	public double subtract(double a, double b) {
		// TODO Auto-generated method stub
		return a-b;
	}

	@Override
	public double multiple(double a, double b) {
		// TODO Auto-generated method stub
		return a*b;
	}

	@Override
	public double divide(double a, double b) {
		if (b == 0) {
			throw new IllegalArgumentException("Divisor is Zero");
		}
		// TODO Auto-generated method stub
		return a/b;
	}

}
