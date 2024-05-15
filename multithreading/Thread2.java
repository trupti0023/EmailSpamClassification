
public class Thread2 
{
    public static void main(String []args)
    {
        System.out.println("main starts");

        Thread th = Thread.currentThread();
        System.out.println("name "+th.getName());
        System.out.println("priority "+th.getPriority());
        System.out.println("is alive "+th.isAlive());

        for(int i=1;i<10;i++)
        {
            System.out.println(i);
            try
            {
                Thread.sleep(i);
            }
            catch(Exception e){}
            
        }

        System.out.println("main ends");
    }
}