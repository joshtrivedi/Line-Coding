package linecoding;
import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import javax.swing.JFrame;

public class AlternateMarkInversion extends Canvas implements ActionListener{
    JFrame f1;
    JButton b1;
    static int[] a=new int[8];
    static int[] arr=new int[8];
    public void paint(Graphics g)
    {
        int i,j=20;
        g.drawLine(20, 20, 20, 250); //Vertical Line
        g.drawLine(20, 135, 400, 135); //Horizontal Line
        
        g.drawString(""+arr[0], 25, 70);
        g.drawString(""+arr[1], 65, 70);
        g.drawString(""+arr[2], 105, 70);
        g.drawString(""+arr[3], 145, 70);
        g.drawString(""+arr[4], 185, 70);
        g.drawString(""+arr[5], 225, 70);
        g.drawString(""+arr[6], 265, 70);
        g.drawString(""+arr[7], 305, 70);

        Graphics2D g2d = (Graphics2D) g;
        Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{3}, 0);
        g2d.setStroke(dashed);
        g2d.drawLine(60,20,60,255);
        g2d.drawLine(100,20,100,255);
        g2d.drawLine(140,20,140,255);
        g2d.drawLine(180,20,180,255);
        g2d.drawLine(220,20,220,255);
        g2d.drawLine(260,20,260,255);
        g2d.drawLine(300,20,300,255);
        g2d.drawLine(340,20,340,255);


        g2d.setStroke(new BasicStroke(3));
        
        for(i=0;i<a.length;i++)
        {
            if(i==0)
            {
                if(a[i] == 0)
                {
                    g.setColor(Color.RED.darker());
                    g.drawLine(j,135,j+40,135);
                    j=j+40;
                }
                else if(a[i] == 1)
                {
                    g.setColor(Color.BLUE.darker());
                    g.drawLine(j,105,j+40,105);
                    j=j+40;
                }
                else if(a[i] == -1)
                {
                    g.setColor(Color.WHITE.darker());
                    g.drawLine(j,165,j+40,165);
                    j=j+40;
                }
            }
            else
            {
                if((a[i]==-1 && a[i-1]==0) || (a[i]==0 && a[i-1]==-1))
                {
                    g.drawLine(j, 165, j, 135);
                }
                if((a[i]==0 && a[i-1]==1) || (a[i]==1 && a[i-1]==0))
                {
                    g.drawLine(j,135,j,105);
                }
                if((a[i]==-1 && a[i-1]==1) || (a[i]==1 && a[i-1]==-1))
                {
                    g.drawLine(j,165,j,105);
                }
                if(a[i] == 0)
                {
                    g.setColor(Color.RED.darker());
                    g.drawLine(j,135,j+40,135);
                    j=j+40;
                }
                else if(a[i] == 1)
                {
                    g.setColor(Color.BLUE.darker());
                    g.drawLine(j,105,j+40,105);
                    j=j+40;
                }
                else if(a[i] == -1)
                {
                    g.setColor(Color.GREEN.darker());
                    g.drawLine(j,165,j+40,165);
                    j=j+40;
                }
            }

        }
    }
    public AlternateMarkInversion(int []val,int []arr1) {
        // TODO Auto-generated constructor stub
        a = val;
        arr = arr1;
        f1 = new JFrame("A M I");
        f1.setSize(500,500);
        b1 = new JButton("Done");
        f1.add(b1);
        f1.add(this);
        f1.setVisible(true);
        b1.setBounds(10,400,100,50);
        b1.addActionListener(this);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setLocation(600, 60);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
    if(ae.getSource() == b1)
        {
            new MainForm();
            f1.setVisible(false);
        }
    }
}
