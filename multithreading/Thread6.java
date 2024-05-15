//11-05-2022

/*
4 classes -

*/

class Thread61 extends Thread
{
    String nm;
    long val;
    volatile boolean flag;

    Thread61(String nm,int priority)
    {
        super(nm);
        this.nm = nm;
        setPriority(priority);
    }

    public void run()
    {
        val = 1;
        while(flag == true)
        {
            val++;
        }
    }

    public void tstart()
    {
        flag = true;
        start();
    }

    public void tstop()
    {
        flag = false;
    }
}

class Thread6
{
    public static void main(String []args)
    {
        System.out.println("Main Starts");

        Thread61 a = new Thread61("A",2);
        Thread61 b = new Thread61("B",5);
        Thread61 c = new Thread61("C",9);

        a.tstart();
        b.tstart();
        c.tstart();

        try
        {
            Thread.sleep(1000);
        }
        catch(Exception e){}

        a.tstop();
        b.tstop();
        c.tstop();

        try
        {
            a.join();
            b.join();
            c.join();
        }
        catch(Exception e){}
        
        System.out.println("A "+a.val);
        System.out.println("B "+b.val);
        System.out.println("C "+c.val);

        System.out.println("Main Ends");
    }
}