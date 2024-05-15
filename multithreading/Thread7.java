import java.awt.*;
import java.awt.event.*;

class Thid7 extends Thread
{
    int x,y;
    boolean flag;
    Graphics obj;

    Thid7(Graphics g)
    {
        super();
        obj = g;
    }

    void tstart()
    {
        flag = true;
        start();
    }

    void tstop()
    {
        flag = false;
    }

    public void run()
    {
        while(flag)
        {
            x = (int)(Math.random()*400);
            y = (int)(Math.random()*400);
            obj.drawRect(x,y,20,20);

            try
            {
                Thread.sleep(500);
            }
            catch(Exception e){}
        }
    }
}
//why used Runnable?
public class Thread7 extends Frame implements Runnable
{
    Thid7 obj;
    Thread th;
    int flg;

    Thread7()
    {
        super("Thread");
        flg = 0;
        th = new Thread(this);
        th.start();

        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });

        addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                if(flg == 0)
                {
                    begin();
                }
                else 
                {
                    end();
                }
            }
        });

        setSize(400,400);
        setVisible(true);
    }

    void begin()
    {
        obj = new Thid7(getGraphics());
        flg = 1;
        obj.tstart();
    }

    void end()
    {
        flg = 0;
        obj.tstop();
    }

    public void run()
    {
        while(true)
        {
            try
            {
                Thread.sleep(10000);
            }
            catch(Exception e){}
            repaint();
        }
    }

    public static void main(String []args)
    {
        Thread7 a = new Thread7();
    }
}