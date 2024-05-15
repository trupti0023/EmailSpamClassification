
public class Thread1 
{
    public static void main(String []args)
    {
        System.out.println("main starts");
        
        Thread th = Thread.currentThread();
        System.out.println("name "+th.getName());
        System.out.println("priority "+th.getPriority());
        System.out.println("is alive "+th.isAlive());
        
        System.out.println("main ends");
    }
}