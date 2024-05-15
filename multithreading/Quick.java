//Implementation of Quick sort
//06-06-2023

import javax.swing.*;

class Quick implements Runnable
{
    static int []arr;   //static -- it is a class variable...it is acessible throughout class
    int l,r;
    static
    {
        arr = new int[10];
    }

    Quick()
    {
        l = 0;
        r = 9;
    }

    Quick(int a,int b)
    {
        l = a;
        r = b;
    }

    void input()
    {
        for(int i=0;i<10;i++)
        {
            try
            {
                arr[i] = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter No: "));
            }
            catch(Exception e)
            {}
        }
    }

    void display()
    {
        String str = "Data\n";
        for(int i=0;i<10;i++)
        {
            str = str + " "+ arr[i];
        }
        JOptionPane.showMessageDialog(null,str);
    }

    void pivot()
    {
        if(arr[l] > arr[r])
        {
            int tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
        }
    }

    synchronized int partition()
    {
        pivot();
        int i = l, j = r, k = arr[l]; //k -- pivot, i === left , j == right
        do
        {

            do
            {
                i++;
            }while(arr[i]<k);
           
            do 
            {
                j--;
            }while(arr[j]>k);

            if(i<j)
            {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }while(i<j);

        int tmp = arr[l];
        arr[l] = arr[j];
        arr[j] = tmp;

        return j;
    }

    synchronized void quickSort()
    {
        int k = 0;
        if(l<r)
        {
            k = partition();   //returns the position of pivot
            Thread t1 = new Thread(new Quick(l,k-1));
            t1.start();
            try
            {
                t1.join();
            }
            catch(Exception e1){}
            Thread t2 = new Thread(new Quick(k+1,r));
            t2.start();
            try
            {
                t2.join();
            }
            catch(Exception e2){}
        }
    }

    public void run()
    {
        quickSort();
    }

    public static void main(String []args)
    {
        Quick a = new Quick();
        a.input();
        a.display();
        Thread b = new Thread(a);
        b.start();
        try
        {
            b.join();    
        }
        catch(Exception e){}
        a.display();
    }
}