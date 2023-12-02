import java.util.GregorianCalendar;

import javax.lang.model.util.ElementScanner14;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class date {
    private int year;
    private int month;
    private int day;
    private int time;
    private int minute;
    public date(int yy,int mm, int dd,int tt,int min)
    {
        year=yy;
        month=mm;
        day=dd;
        time =tt;
        minute=min;
    }
    public date finalday(int tt,int min)
    {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR,this.getYear());
        cal.set(Calendar.MONTH,this.getMonth());
        cal.set(Calendar.DATE,this.getDay());
        cal.set(Calendar.HOUR_OF_DAY,this.getTime());
        cal.set(Calendar.MINUTE,this.getMinute());
        cal.set(Calendar.SECOND,0);
        cal.add(Calendar.HOUR_OF_DAY,tt);
        cal.add(Calendar.MINUTE,min);
        int yy=cal.get(Calendar.YEAR);
        int mm=cal.get(Calendar.MONTH);
        int dd=cal.get(Calendar.DATE);
        int t=cal.get(Calendar.HOUR_OF_DAY);
        int m=cal.get(Calendar.MINUTE);
        date n=new date(yy,mm,dd,t,m);
        return n;

    }
    public double sub(date d1)
    {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR,d1.getYear());
        cal.set(Calendar.MONTH,d1.getMonth());
        cal.set(Calendar.DATE,d1.getDay());
        cal.set(Calendar.HOUR_OF_DAY,d1.getTime());
        cal.set(Calendar.MINUTE,d1.getMinute());
        cal.set(Calendar.SECOND,0);
        Calendar cal1 = Calendar.getInstance();
        cal1.set(Calendar.YEAR,this.getYear());
        cal1.set(Calendar.MONTH,this.getMonth());
        cal1.set(Calendar.DATE,this.getDay());
        cal1.set(Calendar.HOUR_OF_DAY,this.getTime());
        cal1.set(Calendar.MINUTE,this.getMinute());
        cal1.set(Calendar.SECOND,0);
        double diff =cal.getTimeInMillis() - cal1.getTimeInMillis();
        return diff;
    }
    public double getInitialTime()
    {
        Calendar cal2 = Calendar.getInstance();
        cal2.set(Calendar.YEAR,this.getYear());
        cal2.set(Calendar.MONTH,this.getMonth());
        cal2.set(Calendar.DATE,this.getDay());
        cal2.set(Calendar.HOUR_OF_DAY,this.getTime());
        cal2.set(Calendar.MINUTE,this.getMinute());
        cal2.set(Calendar.SECOND,0);
        double diff =cal2.getTimeInMillis();
        return diff;
    }
    public int getYear()
    {
        return year;
    } 
    public int getMonth()
    {
        return month;
    }
    public int getDay()
    {
        return day;
    }  
    public int getTime()
    {
        return time;
    }
    public int getMinute()
    {
        return minute;
    }
    public void setYear(int yy)
    {
        year=yy;
    }
    public void setMonth(int mm)
    {
        month=mm;
    }
    public void setDay(int dd)
    {
        day=dd;
    }
    public void setTime(int tt)
    {
        time=tt;
    }
    public void setMinute(int min)
    {
        minute=min;
    }
    //exception 처리
    static GregorianCalendar gc = new GregorianCalendar();
    public void check(int year,int month, int day,int time,int min)
    {
        if(year<this.year)
        {
         System.out.println("연도를 잘못 입력하셨습니다.");
         throw new DateException();
        }
        else if(year==this.year)
        {
            if(month<0||(month<this.month)||month>12)
            {
                System.out.println("달을 잘못 입력하셨습니다.");
                throw new DateException();
            }
            else if(month==this.month)
            {
                if (gc.isLeapYear(year))
                {
                    if((month==1)||(month==3)||(month==5)||(month==7)||(month==8)||(month==10)||(month==11))
                    {
                        if((day<0)||(day>31)||day<this.day)
                        {
                            System.out.println("일을 잘못 입력하셨습니다.");
                            throw new DateException();
                        }
                        else if(day==this.day)
                        {
                            if((time<0)||time>24||time<this.time)
                            {
                                System.out.println("시간을 잘못 입력하셨습니다.");
                                throw new DateException();
                            }
                            else if(time==this.time)
                            {
                                if(min<0||min>60||min<this.minute)
                                {
                                    System.out.println("분을 잘못 입력하셨습니다.");
                                    throw new DateException();
                                }

                            }
                        }
                    }
                    else if(month==2)
                    {
                        if((day<0)||(day>29)||day<this.day)
                        {
                            System.out.println("일을 잘못 입력하셨습니다.");
                            throw new DateException();
                        }
                        else if(day==this.day)
                        {
                            if((time<0)||time>24||time<this.time)
                            {
                                System.out.println("시간을 잘못 입력하셨습니다.");
                                throw new DateException();
                            }
                            else if(time==this.time)
                            {
                                if(min<0||min>60)
                                {
                                    System.out.println("분을 잘못 입력하셨습니다.");
                                    throw new DateException();
                                }
                            }
                        }
                    }
                    else
                    {
                        if((day<0)||(day>30)||day<this.day)
                        {
                            System.out.println("일을 잘못 입력하셨습니다.");
                            throw new DateException();
                        }
    
                        else if(day==this.day)
                        {
                            if((time<0)||time>24||time<this.time)
                            {
                                System.out.println("시간을 잘못 입력하셨습니다.");
                                throw new DateException();
                            }
                            else if(time==this.time)
                            {
                                if(min<0||min>60||min<this.minute)
                                {
                                    System.out.println("분을 잘못 입력하셨습니다.");
                                    throw new DateException();
                                }
                            }
                        }
                    }
                }
                else
                {
                    if((month==1)||(month==3)||(month==5)||(month==7)||(month==8)||(month==10)||(month==11))
                    {
                        if((day<0)||(day>31)||day<this.day)
                        {
                            System.out.println("일을 잘못 입력하셨습니다.");
                            throw new DateException();
                        }
    
                        else if(day==this.day)
                        {
                            if((time<0)||time>24||time<this.time)
                            {
                                System.out.println("시간을 잘못 입력하셨습니다.");
                                throw new DateException();
                            }
                            else if(time==this.time)
                            {
                                if(min<0||min>60||min<this.minute)
                                {
                                    System.out.println("분을 잘못 입력하셨습니다.");
                                    throw new DateException();
                                }
                            }
                        }
                    }
                    else if(month==2)
                    {
                        if((day<0)||(day>28)||day<this.day)
                        {
                            System.out.println("일을 잘못 입력하셨습니다.");
                            throw new DateException();
                        }
                        else if(day==this.day)
                        {
                            if((time<0)||time>24||time<this.time)
                            {
                                System.out.println("시간을 잘못 입력하셨습니다.");
                                throw new DateException();
                            }
                            else if(time==this.time)
                            {
                                if(min<0||min>60||min<this.minute)
                                {
                                    System.out.println("분을 잘못 입력하셨습니다.");
                                    throw new DateException();
                                }
                            }
                        }
                    }
                    else
                    {
                        if((day<0)||(day>30)||day<this.day)
                        {
                            System.out.println("일을 잘못 입력하셨습니다.");
                            throw new DateException();
                        }
    
                        else if(day==this.day)
                        {
                            if((time<0)||time>24||time<this.time)
                            {
                                System.out.println("시간을 잘못 입력하셨습니다.");
                                throw new DateException();
                            }
                            else if(time ==this.time)
                            {
                                if(min<0||min>60||min<this.minute)
                                {
                                    System.out.println("분을 잘못 입력하셨습니다.");
                                    throw new DateException();
                                }
                            }
                            
                        }
                    }
                }
            }
            else
            {
                if (gc.isLeapYear(year))
                {
                    if((month==1)||(month==3)||(month==5)||(month==7)||(month==8)||(month==10)||(month==11))
                    {
                        if((day<0)||(day>31))
                        {
                            System.out.println("일을 잘못 입력하셨습니다.");
                            throw new DateException();
                        }
                        else 
                        {
                            if((time<0)||time>24)
                            {
                                System.out.println("시간을 잘못 입력하셨습니다.");
                                throw new DateException();
                            }
                            else
                            {
                                if(min<0||min>60)
                                {
                                    System.out.println("분을 잘못 입력하셨습니다.");
                                    throw new DateException();
                                }

                            }
                        }
                    }
                    else if(month==2)
                    {
                        if((day<0)||(day>29))
                        {
                            System.out.println("일을 잘못 입력하셨습니다.");
                            throw new DateException();
                        }
                        else
                        {
                            if((time<0)||time>24)
                            {
                                System.out.println("시간을 잘못 입력하셨습니다.");
                                throw new DateException();
                            }
                            else
                            {
                                if(min<0||min>60)
                                {
                                    System.out.println("분을 잘못 입력하셨습니다.");
                                    throw new DateException();
                                }
                            }
                        }
                    }
                    else
                    {
                        if((day<0)||(day>30))
                        {
                            System.out.println("일을 잘못 입력하셨습니다.");
                            throw new DateException();
                        }
    
                        else
                        {
                            if((time<0)||time>24)
                            {
                                System.out.println("시간을 잘못 입력하셨습니다.");
                                throw new DateException();
                            }
                            else
                            {
                                if(min<0||min>60)
                                {
                                    System.out.println("분을 잘못 입력하셨습니다.");
                                    throw new DateException();
                                }
                            }
                        }
                    }
                }
                else
                {
                    if((month==1)||(month==3)||(month==5)||(month==7)||(month==8)||(month==10)||(month==11))
                    {
                        if((day<0)||(day>31))
                        {
                            System.out.println("일을 잘못 입력하셨습니다.");
                            throw new DateException();
                        }
    
                        else
                        {
                            if((time<0)||time>24)
                            {
                                System.out.println("시간을 잘못 입력하셨습니다.");
                                throw new DateException();
                            }
                            else 
                            {
                                if(min<0||min>60)
                                {
                                    System.out.println("분을 잘못 입력하셨습니다.");
                                    throw new DateException();
                                }
                            }
                        }
                    }
                    else if(month==2)
                    {
                        if((day<0)||(day>28))
                        {
                            System.out.println("일을 잘못 입력하셨습니다.");
                            throw new DateException();
                        }
                        else
                        {
                            if((time<0)||time>24)
                            {
                                System.out.println("시간을 잘못 입력하셨습니다.");
                                throw new DateException();
                            }
                            else
                            {
                                if(min<0||min>60)
                                {
                                    System.out.println("분을 잘못 입력하셨습니다.");
                                    throw new DateException();
                                }
                            }
                        }
                    }
                    else
                    {
                        if((day<0)||(day>30))
                        {
                            System.out.println("일을 잘못 입력하셨습니다.");
                            throw new DateException();
                        }
    
                        else
                        {
                            if((time<0)||time>24)
                            {
                                System.out.println("시간을 잘못 입력하셨습니다.");
                                throw new DateException();
                            }
                            else
                            {
                                if(min<0||min>60)
                                {
                                    System.out.println("분을 잘못 입력하셨습니다.");
                                    throw new DateException();
                                }
                            }
                            
                        }
                    }
                } 
            }
        }
        else{
            if(month<0||month>12)
            {
                System.out.println("달을 잘못 입력하셨습니다.");
                throw new DateException();
            }
            else
            {
                if (gc.isLeapYear(year))
                {
                    if((month==1)||(month==3)||(month==5)||(month==7)||(month==8)||(month==10)||(month==11))
                    {
                        if((day<0)||(day>31))
                        {
                            System.out.println("일을 잘못 입력하셨습니다.");
                            throw new DateException();
                        }
                        else
                        {
                            if((time<0)||time>24)
                            {
                                System.out.println("시간을 잘못 입력하셨습니다.");
                                throw new DateException();
                            }
                            else
                            {
                                if(min<0||min>60)
                                {
                                    System.out.println("분을 잘못 입력하셨습니다.");
                                    throw new DateException();
                                }

                            }
                        }
                    }
                    else if(month==2)
                    {
                        if((day<0)||(day>29))
                        {
                            System.out.println("일을 잘못 입력하셨습니다.");
                            throw new DateException();
                        }
                        else
                        {
                            if((time<0)||time>24)
                            {
                                System.out.println("시간을 잘못 입력하셨습니다.");
                                throw new DateException();
                            }
                            else
                            {
                                if(min<0||min>60)
                                {
                                    System.out.println("분을 잘못 입력하셨습니다.");
                                    throw new DateException();
                                }
                            }
                        }
                    }
                    else
                    {
                        if((day<0)||(day>30))
                        {
                            System.out.println("일을 잘못 입력하셨습니다.");
                            throw new DateException();
                        }
    
                        else
                        {
                            if((time<0)||time>24)
                            {
                                System.out.println("시간을 잘못 입력하셨습니다.");
                                throw new DateException();
                            }
                            else
                            {
                                if(min<0||min>60)
                                {
                                    System.out.println("분을 잘못 입력하셨습니다.");
                                    throw new DateException();
                                }
                            }
                        }
                    }
                }
                else
                {
                    if((month==1)||(month==3)||(month==5)||(month==7)||(month==8)||(month==10)||(month==11))
                    {
                        if((day<0)||(day>31))
                        {
                            System.out.println("일을 잘못 입력하셨습니다.");
                            throw new DateException();
                        }
    
                        else
                        {
                            if((time<0)||time>24)
                            {
                                System.out.println("시간을 잘못 입력하셨습니다.");
                                throw new DateException();
                            }
                            else
                            {
                                if(min<0||min>60)
                                {
                                    System.out.println("분을 잘못 입력하셨습니다.");
                                    throw new DateException();
                                }
                            }
                        }
                    }
                    else if(month==2)
                    {
                        if((day<0)||(day>28))
                        {
                            System.out.println("일을 잘못 입력하셨습니다.");
                            throw new DateException();
                        }
                        else
                        {
                            if((time<0)||time>24)
                            {
                                System.out.println("시간을 잘못 입력하셨습니다.");
                                throw new DateException();
                            }
                            else
                            {
                                if(min<0||min>60)
                                {
                                    System.out.println("분을 잘못 입력하셨습니다.");
                                    throw new DateException();
                                }
                            }
                        }
                    }
                    else
                    {
                        if((day<0)||(day>30))
                        {
                            System.out.println("일을 잘못 입력하셨습니다.");
                            throw new DateException();
                        }
    
                        else
                        {
                            if((time<0)||time>24)
                            {
                                System.out.println("시간을 잘못 입력하셨습니다.");
                                throw new DateException();
                            }
                            else
                            {
                                if(min<0||min>60)
                                {
                                    System.out.println("분을 잘못 입력하셨습니다.");
                                    throw new DateException();
                                }
                            }
                        }
                    }
                }
            }

        }
    }
}
