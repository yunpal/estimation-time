import java.time.*;
abstract class Vehicle implements Comparable
{
private int number;
private String carType;
private double distance;
private int distanceRate;
private int fare;
private int velocity;
private date [][]startTime=new date[100][100];
private int startPlace;
private int finalPlace;
private double differTime;
private double finishedInterTime;
private int currentDistance;
private int count=0;
private int[] start=new int[100];
private date[] finishedTime=new date[100];
private double due=0;
private boolean valid=false;
private int finished=0;
private int checked=0;
private date firstDate=new date(2023,5,12,0,0);
//valid finished 이전 시간 들어온거 check

public double compareTo(Vehicle other)
{
   if(other.getTimetable()==null)
   return 0;
   else
   return this.getTime()-other.getTime();
}
public double getTime()
{
return this.startTime[finished-1][start[finished-1]].getInitialTime();
}
public Vehicle(int number,int distanceRate,int fare)
{
this.number=number;
this.distanceRate=distanceRate;
this.fare= fare;
distance=0;
velocity=0;
startPlace=0;
finalPlace=0;
}
public double getStartTime(){return startTime[finished][start[finished]].getInitialTime();}
public date getTimetable(){return startTime[finished][start[finished]];}
public void setValid()
{
   valid=true;
}
public boolean getValid()
{
   return valid;
}
public void setDifferTime(int d)
{
   differTime=d;
}
public void setFinished()
{
   if(finishedTime[finished].sub(startTime[finished][count])>=0)
   {
      finished++;
      
      start[finished]=0;
      startTime[finished][1] =new date(0,0,0,0,0);
      startTime[finished][1]= startTime[finished-1][count];
      count=1;
      valid=false;
   }
}
public int getFinished()
{
   return finished;
}
public abstract int calcToll();
public int getCarNum() { return number; }
public double getDistanceRate() { return distanceRate; }
public int getFare() { return fare; }
public int getVelocity() { return velocity; }
public double getDistance(){return distance;}
public String getCarType() { return carType; }
public void setVelocity(int v) { velocity=v; }
public void setDuration()
{
   due= (distance/velocity)*60;
   int addTime=(int)(due/60);
   int addMin=(int)(due-addTime*60);
   finishedTime[finished]=startTime[finished][start[finished]].finalday(addTime,addMin);
   finishedInterTime=startTime[finished][start[finished]].sub(finishedTime[finished]);
   finishedInterTime=differTime/(1000*60*60);
}
public void setDifference()
{
   if(start[finished]==(count))
   {
      differTime=0;
   }
   differTime=startTime[finished][start[finished]].sub(startTime[finished][count]);
   differTime=differTime/(1000*60*60);
}
public void setCarType(String c) 
{ 
   if(c.equals("c"))
   {
      carType="car";
   }
   if(c.equals("h"))
   {
      carType="hybrid car";
   } 
   if(c.equals("b"))
   {
      carType="bus";
   } 
   if(c.equals("t"))
   {
      carType="truck";
   }  
}
public void setDistance(int d){distance=d;}
public void setStartTime(int yy,int mm,int dd,int tt,int min)
{
   
   count++;
   if( startTime[finished][count-1]!=null)
   {
      checked++;
      startTime[finished][count-1].check(yy,mm,dd,tt,min);
   }
   startTime[finished][count] =new date(yy,mm,dd,tt,min);
   if(checked==0)
   {
      firstDate.check(startTime[finished][count].getYear(),startTime[finished][count].getMonth(),startTime[finished][count].getDay(),startTime[finished][count].getTime(),startTime[finished][count].getMinute());
   }
}
public void setstartPlace(int d){startPlace=d;}
public void setfinalPlace(int d){finalPlace=d;}

public void setStart()
{
   start[finished]=count;
}
public void printN()
{
   String str1=null;
   String str2=null;
   if(startPlace==0)
   {
      str1="서울";
   }
   if(startPlace==1)
   {
      str1="수원";
   }
   if(startPlace==2)
   {
      str1="대전";
   }
   if(startPlace==3)
   {
      str1="대구";
   }   if(startPlace==4)
   {
      str1="부산";
   }
   if(finalPlace==0)
   {
      str2="서울";
   }
   if(finalPlace==1)
   {
      str2="수원";
   }
   if(finalPlace==2)
   {
      str2="대전";
   }
   if(finalPlace==3)
   {
      str2="대구";
   }   
   if(finalPlace==4)
   {
      str2="부산";
   }
   System.out.println("승용차 "+ number+" 진입");
   System.out.println("진입시간: "+ startTime[finished][start[finished]].getYear()+"/"+startTime[finished][start[finished]].getMonth()+"/"+startTime[finished][start[finished]].getDay()+":"+startTime[finished][start[finished]].getTime()+":"+ startTime[finished][start[finished]].getMinute());
   System.out.println("진입장소: "+ str1 );
   System.out.println("진출장소: "+ str2 );
   System.out.println("시속: "+ velocity+"km");
}
public abstract int getVolume();
public String getFirstDate(int a)
{
   String str;
   if(startTime[a][start[a]].getMinute()<10)
   {
      str= startTime[a][start[a]].getYear()+"/"+startTime[a][start[a]].getMonth()+"/"+startTime[a][start[a]].getDay()+":"+startTime[a][start[a]].getTime()+":0"+ startTime[a][start[a]].getMinute();
   }
   else
   {
      str= startTime[a][start[a]].getYear()+"/"+startTime[a][start[a]].getMonth()+"/"+startTime[a][start[a]].getDay()+":"+startTime[a][start[a]].getTime()+":"+ startTime[a][start[a]].getMinute();
   }
   return str;
}
public String getFinishedDate(int a)
{
   String str;
   if( finishedTime[a].getMinute()<10)
   {
   str=finishedTime[a].getYear()+"/"+finishedTime[a].getMonth()+"/"+finishedTime[a].getDay()+":"+finishedTime[a].getTime()+":0"+ finishedTime[a].getMinute();
   }
   else
   {
      str=finishedTime[a].getYear()+"/"+finishedTime[a].getMonth()+"/"+finishedTime[a].getDay()+":"+finishedTime[a].getTime()+":"+ finishedTime[a].getMinute();
   }
   return str;
}
public String getCurrentDate()
{
   return startTime[finished][count].getYear()+"/"+startTime[finished][count].getMonth()+"/"+startTime[finished][count].getDay()+":"+startTime[finished][count].getTime()+":"+ startTime[finished][count].getMinute();
}
public String getStartPlace()
{
   String str1=null;
   if(startPlace==0)
   {
      str1="서울";
   }
   if(startPlace==1)
   {
      str1="수원";
   }
   if(startPlace==2)
   {
      str1="대전";
   }
   if(startPlace==3)
   {
      str1="대구";
   }   if(startPlace==4)
   {
      str1="부산";
   }
   return str1;
}
public String getFinalPlace()
{
   String str2=null;
   if(finalPlace==0)
   {
      str2="서울";
   }
   if(finalPlace==1)
   {
      str2="수원";
   }
   if(finalPlace==2)
   {
      str2="대전";
   }
   if(finalPlace==3)
   {
      str2="대구";
   }   
   if(finalPlace==4)
   {
      str2="부산";
   }
   return str2;
}
public int getCurrentPlace()
{
   if(startPlace==0)
   {
      currentDistance=(int)(differTime*velocity);
   }
   if(startPlace==1)
   {
      if(finalPlace<1)
      {
         currentDistance=(int)(40-differTime*velocity);
      }
      else
      {
         currentDistance=(int)(differTime*velocity+40);
      }
   }
   if(startPlace==2)
   {
      if(finalPlace<2)
      {
         currentDistance=(int)(40+120-differTime*velocity);
      }
      else
      {
         currentDistance=(int)(differTime*velocity+40+120);
      }
   }
   if(startPlace==3)
   {
      if(finalPlace<3)
      {
         currentDistance=(int)(40+120+130-differTime*velocity);
      }
      else
      {
         currentDistance=(int)(differTime*velocity+40+120+130);
      }
   }
   if(startPlace==4)
   {
      currentDistance=(int)(40+120+130+100-differTime*velocity);
   }
   return currentDistance;
}
}
