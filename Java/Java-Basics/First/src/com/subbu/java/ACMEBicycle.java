package com.subbu.java;

 class ACMEBicycle implements IBicycle {
	static final int MAX_SPEED = 40;
	 
	int cadence = 0;
	int speed = 0;
	int gear = 1;
	

	@Override
	public
	 void changeCadence(int newValue) {
		// TODO Auto-generated method stub
		this.cadence = newValue;

	}

	@Override
	public
	 void changeGear(int newValue) {
		// TODO Auto-generated method stub
		this.gear = newValue;

	}

	@Override
	public
	 void speedUp(int increment) throws Exception {
		// TODO Auto-generated method stub
		if ((this.speed + increment) > MAX_SPEED) {
			throw new Exception("Max Speed Reached");
		}
		this.speed += increment;
	}

	@Override
	public
	 void applyBrakes(int decrement) {
		// TODO Auto-generated method stub
		this.speed -= decrement;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[Bicycle: Gear=" + this.gear + 
				" Cadence=" + this.cadence + 
				" Speed=" + this.speed + "]";
	}

}
