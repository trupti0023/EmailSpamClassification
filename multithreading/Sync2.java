//Giving correct result
//Synchornization using synchornised block

class TShared2
{
    void table(int no)
    {
        System.out.println("Table");
        for(int i=0;i<=10;i++)
        {
            System.out.println(no*i);
        }
    }
}

class Thread23 extends Thread
{Q
    TShared2 obj;
    int no;
    Thread23(TShared2 ref,int n)
    {
        super();
        obj = ref;
        no = n;
        start();
    }

    public void run()
    {
        synchronized(obj)
        {
            obj.table(no);
        }
       
    }
}

public class Sync2
{
    public static void main(String []args)
    {
        System.out.println("main starts");
        TShared2 a = new TShared2();
        Thread23 b = new Thread23(a,10);
        Thread23 c = new Thread23(a,20);
        try
        {
            b.join();
            c.join();
        }
        catch(Exception e){}
        System.out.println("main ends");
    }
}