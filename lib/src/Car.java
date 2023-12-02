class Car extends Vehicle
 { 
 private int volume; // 차량 배기량
 private double volumeRate;
 public Car(int number,int distanceRate,int fare, int v) 
 { 
   super(number,distanceRate,fare); 
   volume = v; 
}

 public int calcToll() // 통행료 계산
 { 
 if(volume>=2400)
 { volumeRate=1.2;}
 else if(volume<2400 && volume>=1000)
 {volumeRate=1;}
 if(volume<1000)
 {volumeRate=0.8;}
 int toll = (int) ( getFare() + getDistance()*getDistanceRate() * volumeRate );
 return toll;
 }
 public double getDistance(){return super.getDistance(); }
 public int getVolume(){return volume; }
 public double getDistanceRate(){return super.getDistanceRate(); }
 public double getTime()
 {
  double time=super.getTime();
 return time;
 }
//public date getStartTime(){return startTime[start]; }
//  public void setVelocity(int v) { super.setVelocity(v); }
//  public void setDistance(int d){super.setDistance(d);}
 }
