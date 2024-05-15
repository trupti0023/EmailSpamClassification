//Synchornization issue

class TShared
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

class Thread21 extends Thread
{
    TShared obj;
    int no;
    Thread21(TShared ref,int n)
    {
        super();
        obj = ref;
        no = n;
        start();
    }

    public void run()
    {
        obj.table(no);
    }
}

public class Sync0
{
    public static void main(String []args)
    {
        System.out.println("main starts");
        TShared a = new TShared();
        Thread21 b = new Thread21(a,10);
        Thread21 c = new Thread21(a,20);
        try
        {
            b.join();
            c.join();
        }
        catch(Exception e){}
        System.out.println("main ends");
    }
}