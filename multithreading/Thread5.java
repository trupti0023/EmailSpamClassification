//11-05-2022

/*
4 classes -

*/

class Thread51 extends Thread
{
    String nm;
    int val;

    Thread51(String nm,int val)
    {
        super(nm);
        this.nm = nm;
        this.val = val;
        start();
    }

    public void run()
    {
        int i = 1;
        while(i <= val)
        {
            System.out.println(nm+" "+i);
            try
            {
                Thread.sleep(500);
            }
            catch(Exception e){}
            i++;
        }
    }
}

class Thread52 extends Thread
{
    String nm;
    int val;

    Thread52(String nm,int val)
    {
        super(nm);
        this.nm = nm;
        this.val = val;
        start();
    }

    public void run()
    {
        int i = 1;
        System.out.println("Table");
        while(i <= 10)
        {
            System.out.println(val*i);
            try
            {
                Thread.sleep(500);
            }
            catch(Exception e){}
            i++;
        }
    }
}


class Thread53 extends Thread
{
    String nm;
    int val;

    Thread53(String nm,int val)
    {
        super(nm);
        this.nm = nm;
        this.val = val;
        start();
    }

    public void run()
    {
        int i = 1;
        System.out.println("Fibbonacci Series");
        
            int a = -1;
            int b = 1;
            int c = 0;
            while(i<val)
            {
                c = a+b;
                System.out.println(nm+" "+c);
                a = b;
                b = c;
                i++;
                try
                {
                    Thread.sleep(500);
                }
                catch(Exception e){}
                i++;
            }
            
            
        
    }
}


class Thread5
{
    public static void main(String []args)
    {
        System.out.println("Main Starts");

        Thread51 a = new Thread51("A",5);
        Thread52 b = new Thread52("B",23);
        Thread53 c = new Thread53("C",10);

        try
        {
            a.join();
            b.join();
            c.join();
        }
        catch(Exception e){}

        System.out.println("Main Ends");
    }
}