package com.subbu.java;

class BicycleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IBicycle b = new ACMEBicycle();
		try {
			b.speedUp(50);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(b.toString());
	}

}

// Data Types
// boolean, byte, short, int, long, float, double, char
// java.lang.String
