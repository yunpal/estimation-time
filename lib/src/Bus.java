class Bus extends Vehicle
 {
 private int noOfPassengers; // 승객수
 private double passengerRate;
 public Bus(int number,int distanceRate,int fare,int p) 
 { 
   super(number,distanceRate,fare); 
   noOfPassengers = p; 
 }
 public int calcToll() // 통행료 계산
 { 
 if(noOfPassengers>=40){ passengerRate=1.2;}
 else if(noOfPassengers<40 && noOfPassengers>=20)
 {passengerRate=1;}
 if(noOfPassengers<20)
 {passengerRate=0.8;}
 int toll = (int) ( getFare() + getDistance()*getDistanceRate() * passengerRate );
 return toll;
 }
 public double getDistance(){return super.getDistance(); }
 public double getDistanceRate(){return super.getDistanceRate(); }
 public int getFare() { return super.getFare(); }
 public int getVolume(){return noOfPassengers; }
//  public void setVelocity(int v) { super.setVelocity(v); }
//  public void setDistance(int d){super.setDistance(d);}
 }

 