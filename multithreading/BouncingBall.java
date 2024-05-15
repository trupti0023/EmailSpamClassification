import java.awt.*;
import java.awt.event.*;

class Ball extends Thread
{
    Panel pobj;
    static int w = 10;
    static int h = 10;
    int x,y;
    int dx,dy;  //dx == column increment, dy == row increment
    Color cr;

    Ball(Panel p)
    {
        super();
        pobj = p;
        x = 0;
        y = (int)(Math.random()*500);
        dx = dy = 2;
        cr = new Color(((int)(Math.random()*255)),((int)(Math.random()*255)),((int)(Math.random()*255)));
        start();
    }

    public void run()
    {
        while(true)
        {
            move();
            try
            {
                Thread.sleep(50);
            }
            catch(Exception e){}
        }
    }

    public void move()
    {
        Graphics g = pobj.getGraphics();
        g.setColor(Color.WHITE);
        g.fillOval(x,y,w,h);
        x += dx;
        y += dy;
        g.setColor(cr);
        g.fillOval(x,y,w,h);
        Dimension d = pobj.getSize();
        if(x<0)
        {
            x = 0;
            dx = -dx;
        }
        if(x>d.width)
        {
            x = d.width-w;
            dx = -dx;
        }
        if(y<0)
        {
            y = 0;
            dy = -dy;
        }
        if(y>d.height)
        {
            y = d.height-h;
            dy = -dy;
        }
    }
}

public class BouncingBall extends Frame implements ActionListener
{
    Panel p,q;
    Button bs,bx;
    Ball obj;
    BouncingBall()
    {
        super("Bouncing Ball");

        p = new Panel();
        q = new Panel();
        bs = new Button("Start");
        bx = new Button("Exit");
        bs.addActionListener(this);
        bx.addActionListener(this);
        q.add(bs);
        q.add(bx);
        add(p,BorderLayout.CENTER);
        add(q,BorderLayout.SOUTH);
        setSize(500,500);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        Button b = (Button)e.getSource();
        if(b == bx)
        {
            System.exit(0);
        }
        else
        {
            obj = new Ball(p);
        }
    }

    public static void main(String []args)
    {
        BouncingBall bb = new BouncingBall();
    }
}