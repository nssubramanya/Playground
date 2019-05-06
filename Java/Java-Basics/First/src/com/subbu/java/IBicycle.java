package com.subbu.java;

interface IBicycle {
	public void changeCadence(int newValue);
	public void changeGear(int newValue);
	public void speedUp(int increment) throws Exception;
	public void applyBrakes(int decrement);
}
