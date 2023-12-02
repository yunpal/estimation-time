public class Truck extends Vehicle 
{
 private int weight;
 private double weightRate;
 public Truck(int number,int distanceRate,int fare,int w) 
 { 
   super(number,distanceRate,fare); 
   weight = w; 
 }
 public int calcToll() // 통행료 계산
 { 
 if(weight>=4){ weightRate=1.2;}
 else if(weight<4 && weight>=2)
 {weightRate=1;}
 if(weight<2)
 {weightRate=0.8;}
 int toll = (int) ( getFare() + getDistance()*getDistanceRate() * weightRate );
 return toll;
 }
 public double getDistance(){return super.getDistance(); }
 public double getDistanceRate(){return super.getDistanceRate(); }
 public int getFare() { return super.getFare(); }
 public int getVolume(){return weight; }
//  public void setVelocity(int v) { super.setVelocity(v); }
//  public void setDistance(int d){super.setDistance(d);}
}
