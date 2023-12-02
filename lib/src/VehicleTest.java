import java.io.File;
import java.io.IOException;
import java.util.*;
public class VehicleTest
 {
 public static void main(String[] args) throws IOException 

 {
    int [][] array;
    int [] distance;
    int a=0;
    int b=0;
    int sum=0;
    array = new int[5][5];
    distance = new int[4];
    distance[0]=40;
    distance[1]=120;
    distance[2]=130;
    distance[3]=100;
    
    for(int i=0;i<5;i++)
    {
        for(int j=0;j<5;j++)
        {
            if(i==j)
            {
                array[i][j]=0;
            }
            else
            {
                a=i;
                b=j;
                while(a<b)
                {
                    sum+=distance[a];
                    a++;
                }
                array[i][j]=sum;
                sum=0;
            }
        } 
    }
    for(int i=0;i<5;i++)
    {
        for(int j=0;j<5;j++)
        {
            if(i==j)
            {
                array[i][j]=0;
            }
            else
            {
                a=i;
                b=j;
                while(a>b)
                {
                    sum+=distance[b];
                    b++;
                }
                array[i][j]+=sum;
                sum=0;
            }
        } 
    }
    //여기부터
    Scanner scanner1 = new Scanner(new File("/home/yh0326/workspace/3/hw_3/src/rates.txt"));
    Scanner scanner2 = new Scanner(new File("/home/yh0326/workspace/3/hw_3/src/vehicles.txt"));
    int[] rates=new int [6];
    int i=0;
    int k=0;
    int j=0;
    int p=0;
    while (scanner1.hasNext()) 
    {
        String str1 = scanner1.next();
        String str2 = scanner1.next();
        rates[i]=Integer.valueOf(str1);
        i++;
        rates[i]=Integer.valueOf(str2);
        i++;
    }
    String str=scanner2.next();
    int wholeCarNum=Integer.valueOf(str);
    Vehicle[] vs = new Vehicle[wholeCarNum];
    i=0;
    while (scanner2.hasNext()) 
    {
        String str1 = scanner2.next();
        String str2 = scanner2.next();
        int carNum=Integer.valueOf(str2);
        String str3 = scanner2.next();
        int criterion=Integer.valueOf(str3);
        if(str1.equals("c"))
        {
           vs[i]=new Car(carNum,rates[1],rates[0],criterion);
           vs[i].setCarType("c");
        }
        if(str1.equals("h"))
        {
            vs[i]=new HybridCar(carNum,rates[1],rates[0],criterion);
            vs[i].setCarType("h");
        }
        if(str1.equals("b"))
        {
            vs[i]=new Bus(carNum,rates[3],rates[2],criterion);
            vs[i].setCarType("b");
        }
        if(str1.equals("t"))
        {
            vs[i]=new Truck(carNum,rates[5],rates[4],criterion);
            vs[i].setCarType("t");
        }
        i++;
    }
    int year=0;
    int month=0;
    int day=0;
    int time=0;
    int minute=0;
    int first=0;
    while(true)
    {
        System.out.print(">");
        Scanner in = new Scanner(System.in);
        str=in.nextLine();
        String[] result = str.split(" ");
        if(result[0].equals("t"))
        {
            try
            {
            year= Integer.valueOf(result[1]);
            month= Integer.valueOf(result[2]);
            day= Integer.valueOf(result[3]);
            time= Integer.valueOf(result[4]);
            minute= Integer.valueOf(result[5]);
            for(i=0;i< wholeCarNum ;i++)
            {
                vs[i].setStartTime(year,month,day,time,minute);
                if(vs[i].getValid()==true)
                {
                vs[i].setFinished();
                }
                
            }
            }
            catch(NumberFormatException e1)
            {
                System.out.println("시간 정보에 오류가 있습니다.");
            }
            catch(ArrayIndexOutOfBoundsException e2)
            {
                System.out.println("입력이 잘못되었습니다.");
            }
            catch(DateException e3)
            {

            }
        }
        if(result[0].equals("n"))
        {
            try{
                int r=0;
                int u=0;
                int y=0;
            int carNum= Integer.valueOf(result[1]);
            if(carNum<1000||carNum>9999)
            {
                throw new CarException();
            }
            for(i=0;i< wholeCarNum ;i++)
            {
                if(vs[i].getCarNum()==carNum)
                {
                    r++;
                }
            }
            if(r==0)
            {
                throw new CarException2();
            }
            String enterPlace= result[2];
            if(enterPlace.equals("서울"))
            {
                u++;
            }
            if(enterPlace.equals("수원"))
            {
                u++;
            }
            if(enterPlace.equals("대전"))
            {
                u++;
            }
            if(enterPlace.equals("대구"))
            {
                u++;
            }
            if(enterPlace.equals("부산"))
            {
                u++;
            }
            if(u==0)
            {
                throw new enterPlaceException2();
            }
            String outPlace= result[3];
            if(outPlace.equals("서울"))
            {
                y++;
            }
            if(outPlace.equals("수원"))
            {
                y++;
            }
            if(outPlace.equals("대전"))
            {
                y++;
            }
            if(outPlace.equals("대구"))
            {
                y++;
            }
            if(outPlace.equals("부산"))
            {
                y++;
            }
            if(y==0)
            {
                throw new enterPlaceException3();
            }
            if(enterPlace.equals(outPlace))
            {
                throw new enterPlaceException();
            }
            i=0;
            int velocity= Integer.valueOf(result[4]);
            if(velocity<50||velocity>120)
            {
                throw new VelocityException();
            }
            
            for(i=0;i< wholeCarNum ;i++)
            {
                k=0;
                j=0;
                if(vs[i].getCarNum()==carNum)
                {
                    vs[i].setVelocity(velocity);
                    if(vs[i].getValid()==true)
                    {
                        throw new ValidException();
                    }
                    vs[i].setValid();
                    vs[i].setStart();
                        if(result[2].equals("서울"))
                        {
                            vs[i].setstartPlace(0);
                            k=0;
                        }
                        if(result[2].equals("수원"))
                        {
                            vs[i].setstartPlace(1);
                            k=1;
                        }
                        if(result[2].equals("대전"))
                        {
                            vs[i].setstartPlace(2);
                            k=2;
                        }
                        if(result[2].equals("대구"))
                        {
                            vs[i].setstartPlace(3);
                            k=3;
                        }
                        if(result[2].equals("부산"))
                        {
                            vs[i].setstartPlace(4);
                            k=4;
                        }
                        if(result[3].equals("서울"))
                        {
                            vs[i].setfinalPlace(0);
                            j=0;
                        }
                        if(result[3].equals("수원"))
                        {
                            vs[i].setfinalPlace(1);
                            j=1;
                        }
                        if(result[3].equals("대전"))
                        {
                            vs[i].setfinalPlace(2);
                            j=2;
                        }
                        if(result[3].equals("대구"))
                        {
                            vs[i].setfinalPlace(3);
                            j=3;
                        }
                        if(result[3].equals("부산"))
                        {
                            vs[i].setfinalPlace(4);
                            j=4;
                        }
                        vs[i].setDistance(array[k][j]);
                        vs[i].setDuration();
                        vs[i].printN();
                }
            }
        }
            catch(ArrayIndexOutOfBoundsException e2)
            {
                System.out.println("입력이 잘못되었습니다.");
            }
            catch(CarException e4)
            {
                System.out.println("차량 번호가 4자리 정수값이 아닙니다.");
            }
            catch(CarException2 e5)
            {
                System.out.println("해당 차량 번호를 가진 차량이 없습니다.");
            }
            catch(VelocityException e6)
            {
                System.out.println("차량 속도가 50~120을 벗어납니다.");
            }
            catch(enterPlaceException e7)
            {
                System.out.println("진입 진출 장소가 동일합니다.");
            }
            catch(enterPlaceException2 e8)
            {
                System.out.println("진입 장소가 잘못되었습니다.");
            }
            catch(enterPlaceException3 e9)
            {
                System.out.println("진출 장소가 잘못되었습니다.");
            }
            catch(ValidException e9)
            {
                System.out.println("해당 차량은 이미 고속도로 상에 존재 합니다.");
            }

        }
        if(result[0].equals("o"))
        {
            //sorting 하기
            Vehicle tmp;
            for(i=0;i<wholeCarNum ;i++)
            {
                if(vs[i].getTimetable()!=null)
                {
                for(j=i;j<wholeCarNum ;j++)
                {
                    if(vs[j].getTimetable()!=null)
                    {
                    if(vs[j].getStartTime()<vs[i].getStartTime())
                    {
                       tmp=vs[i];
                        vs[i]=vs[j];
                         vs[j]=tmp;
                    }
                    }
                }
            }
            }
            a=0;
            for(i=0;i<wholeCarNum ;i++)
            {
            if(vs[i].getTimetable()!=null)
            {    
            vs[i].setDifference();
            }
            }
            for(i=0;i<wholeCarNum ;i++)
            {
                if(vs[i].getCarType().equals("car"))
                {           
                    if(vs[i].getValid()==true)
                    {                 
                    System.out.print(a+1+". ");   
                    System.out.println(vs[i].getCarType()+" "+vs[i].getCarNum()+" "+vs[i].getVolume()+"cc "+vs[i].getFirstDate(vs[i].getFinished())+" "+vs[i].getStartPlace()+"-> "+vs[i].getFinalPlace()+" 시속:"+vs[i].getVelocity()+" km 위치:"+vs[i].getCurrentPlace()+"km");
                    a++;
                    }
                }
            }
            for(i=0;i<wholeCarNum ;i++)
            {
                if(vs[i].getCarType().equals("hybrid car"))
                {                
                    if(vs[i].getValid()==true)
                    {
                    System.out.print(a+1+". ");   
                    System.out.println(vs[i].getCarType()+" "+vs[i].getCarNum()+" "+vs[i].getVolume()+"cc "+vs[i].getFirstDate(vs[i].getFinished())+" "+vs[i].getStartPlace()+"-> "+vs[i].getFinalPlace()+" 시속:"+vs[i].getVelocity()+" km 위치:"+vs[i].getCurrentPlace()+"km");
                    a++;
                    }
                }
            }
            for(i=0;i<wholeCarNum ;i++)
            {
                if(vs[i].getValid()==true)
                {
                if(vs[i].getCarType().equals("bus"))
                {                
                    System.out.print(a+1+". ");   
                    System.out.println(vs[i].getCarType()+" "+vs[i].getCarNum()+" "+vs[i].getVolume()+"인승 "+vs[i].getFirstDate(vs[i].getFinished())+" "+vs[i].getStartPlace()+"-> "+vs[i].getFinalPlace()+" 시속:"+vs[i].getVelocity()+" km 위치:"+vs[i].getCurrentPlace()+"km");
                    a++;
                }
                }
            }
            for(i=0;i<wholeCarNum ;i++)
            {
                if(vs[i].getValid()==true)
                {
                if(vs[i].getCarType().equals("truck"))
                {                
                    System.out.print(a+1+". ");   
                    System.out.println(vs[i].getCarType()+" "+vs[i].getCarNum()+" "+vs[i].getVolume()+"ton "+vs[i].getFirstDate(vs[i].getFinished())+" "+vs[i].getStartPlace()+"-> "+vs[i].getFinalPlace()+" 시속:"+vs[i].getVelocity()+" km 위치:"+vs[i].getCurrentPlace()+"km");
                    a++;
                }
                }
            }
            if(a==0)
            {
                System.out.println("통행 차량이 없습니다!");
            }
        }
        if(result[0].equals("x"))
        {
            try{
            ArraysAlg.sort(vs);
            }
            catch(ArrayIndexOutOfBoundsException e13)
            {
                System.out.println("진출한 차량이 없습니다..");
                continue;
            }
            a=0;
            for(i=0;i<wholeCarNum ;i++)
            {
                if(vs[i].getFinished()>0)
                {
                if(vs[i].getCarType().equals("car"))
                {
                    System.out.print(a+1+". ");   
                    System.out.println(vs[i].getCarType()+" "+vs[i].getCarNum()+" "+vs[i].getVolume()+"cc "+vs[i].getFirstDate(vs[i].getFinished()-1)+" "+vs[i].getStartPlace()+"-> "+vs[i].getFinalPlace()+" "+vs[i].getFinishedDate(vs[i].getFinished()-1)+" "+vs[i].calcToll()+"원");
                    a++;
                }
                }
            }
            for(i=0;i<wholeCarNum ;i++)
            {
                if(vs[i].getFinished()>0)
                {
                if(vs[i].getCarType().equals("hybrid car"))
                {         
                    System.out.print(a+1+". ");   
                    System.out.println(vs[i].getCarType()+" "+vs[i].getCarNum()+" "+vs[i].getVolume()+"cc "+vs[i].getFirstDate(vs[i].getFinished()-1)+" "+vs[i].getStartPlace()+"-> "+vs[i].getFinalPlace()+" "+vs[i].getFinishedDate(vs[i].getFinished()-1)+" "+vs[i].calcToll()+"원");
                    a++;
                }
                }
            }
            for(i=0;i<wholeCarNum ;i++)
            {
                if(vs[i].getFinished()>0)
                {
                if(vs[i].getCarType().equals("bus"))
                {                   
                    System.out.print(a+1+". ");   
                    System.out.println(vs[i].getCarType()+" "+vs[i].getCarNum()+" "+vs[i].getVolume()+"인승 "+vs[i].getFirstDate(vs[i].getFinished()-1)+" "+vs[i].getStartPlace()+"-> "+vs[i].getFinalPlace()+" "+vs[i].getFinishedDate(vs[i].getFinished()-1)+" "+vs[i].calcToll()+"원");
                    a++;
                }
                }
            }
            for(i=0;i<wholeCarNum ;i++)
            {
                if(vs[i].getFinished()>0)
                {
                if(vs[i].getCarType().equals("truck"))
                {                
                    System.out.print(a+1+". ");   
                    System.out.println(vs[i].getCarType()+" "+vs[i].getCarNum()+" "+vs[i].getVolume()+"ton "+vs[i].getFirstDate(vs[i].getFinished()-1)+" "+vs[i].getStartPlace()+"-> "+vs[i].getFinalPlace()+" "+vs[i].getFinishedDate(vs[i].getFinished()-1)+" "+vs[i].calcToll()+"원");
                    a++;
                }
            }
            }
            if(a==0)
            {
                System.out.println("진출한 차량이 없습니다!");
            }
        }
        if(result[0].equals("c"))
        {
            System.out.println(vs[0].getCurrentDate());
        }
        if(result[0].equals("q"))
        {
            break;
        }
    }
 }//main 끝
}//class 끝
