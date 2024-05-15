//Inter Thread Communication

class Shared
{
    int data,flg;
    Shared()
    {
        data = flg = 0;
    }

    synchronized void produce()
    {
        if(flg == 1)
        {
            flg = 0;
            try
            {
                wait();
            }
            catch(Exception e){}
        }
        // else
        //     notify();
        try
        {
            Thread.sleep(1000);
        }
        catch(Exception e){}
        data = (int)(Math.random()*100);
        notify();
    }

    synchronized void consume()
    {
        if(flg == 1)
        {
            notify();
        }
        else
        {
            flg = 0;
        }
        try
        {
            wait();
        }
        catch(Exception e){}
        String s = "Table\n";
        for(int i=1;i<=10;i++)
        {
            s = s + " "+ (data*i);
        }
        System.out.println(s);
    }
}

class T1 extends Thread
{
    Shared obj;
    T1(Shared obj)
    {
        super();
        this.obj = obj;
        start();
    }

    public void run()
    {
        obj.consume();
    }
}

class T2 extends Thread
{
    Shared obj;
    T2(Shared obj)
    {
        super();
        this.obj = obj;
        start();
    }

    public void run()
    {
        obj.produce();
    }
}

public class Communication
{
    public static void main(String []args)
    {
        Shared a = new Shared();
        T1 b = new T1(a);
        T2 c = new T2(a);
        // T1 b = new T1(a);
        // T2 c = new T2(a);
        try
        {
            b.join();
            c.join();
        }
        catch(Exception e){}

        System.out.println("main ends");
    }
}