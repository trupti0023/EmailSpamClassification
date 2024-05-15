
class Thread3 extends Thread
{
    int no;

    Thread3(int n)
    {
        super(" ");
        no = n;
        start();
    }

    public void run()
    {
        int i = 1;
        while(i<=no)
        {
            System.out.println("Thread "+i);
            try
            {
                Thread.sleep(500);
            }
            catch(Exception e){}
            i++;
        }
    }
}

public class Thrd3{

    public static void main(String []args)
    {
        System.out.println("Main starts");

        Thread3 th = new Thread3(10);
        Thread3 t = new Thread3(5);

        System.out.println("main ends");

    }

}