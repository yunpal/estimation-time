public class ArraysAlg {
    
    public static <T extends Vehicle> void sort(T[] a)
    {
        if(a !=null || a.length != 0)
        {
            T tmp;
        for(int i=0;i<a.length;i++)
        {
        for(int j=1;j<a.length;j++)
        {
            if(a[i].compareTo(a[j])>0)
            {
                tmp=a[i];
                a[i]=a[j];
                a[j]=tmp;
                System.out.println("hello");
            }
        }
        }
        }
    }
}
