//11-05-2022

/*
4 classes -

*/

class Thread41 extends Thread
{
    String nm;
    int val;

    Thread41(String nm,int val)
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

class Thread42 extends Thread
{
    String nm;
    int val;

    Thread42(String nm,int val)
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


class Thread43 extends Thread
{
    String nm;
    int val;

    Thread43(String nm,int val)
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


class Thread4
{
    public static void main(String []args)
    {
        System.out.println("Main Starts");

        Thread41 a = new Thread41("A",5);
        Thread42 b = new Thread42("B",23);
        Thread43 c = new Thread43("C",10);

        System.out.println("Main Ends");
    }
}