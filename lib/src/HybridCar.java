class HybridCar extends Car
 {
 public HybridCar(int number,int distanceRate,int fare,int v) 
 { 
   super(number,distanceRate,fare,v); 
 }
 public int calcToll(){return super.calcToll()/2;}
 }
