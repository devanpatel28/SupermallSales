import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.AWTEvent.*;
import java.lang.*;
import javax.swing.*;

public class MainFrame extends JFrame
{
	
	Listener lis = new Listener(this);
	JLabel l1;
	JButton b1,b2,b3,b4,b5,b6;
	ImageIcon backImage;
	JPanel background;
	JLabel imglabel;
    MainFrame()
	{ 
        super("WELCOME");
        setLayout(null);
        setBounds(50,50,1500,900);
		
		backImage = new ImageIcon(getClass().getClassLoader().getResource("img\\projectmain.jpg"));
		background = new JPanel();
		background.setBounds(0,0,1500,900);
		
		
		imglabel = new JLabel();
		imglabel.setIcon(backImage);
		background.add(imglabel);
		//getContentPane().setBackground(Color.LIGHT_GRAY);
		
		l1 = new JLabel("WELCOME TO STORE");
		b1 = new JButton("Stocks");
		b2 = new JButton("Sales");
		b3 = new JButton("Profit/Loss");
		b4 = new JButton("Sorting");
		b5 = new JButton("Report");
		b6 = new JButton("EXIT");
		
		Font f1 = new Font("Calibri",Font.ITALIC,40);
		Font f2 = new Font("Calibri",Font.BOLD,30);
		
		b1.setFont(f2);
		b2.setFont(f2);
		b3.setFont(f2);
		b4.setFont(f2);
		b5.setFont(f2);
		b6.setFont(f2);
		l1.setFont(f1);
		
		l1.setBounds(525,120,350,50);
		b1.setBounds(550,190,300,50);
		b2.setBounds(550,260,300,50);
		b3.setBounds(550,330,300,50);
		b4.setBounds(550,400,300,50);
		b5.setBounds(550,470,300,50);
		b6.setBounds(550,540,300,50);
		l1.setOpaque(true);
		l1.setBackground(Color.WHITE);
		

		add(l1);
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		add(b6);
		add(background);
		
		b1.addActionListener(lis);
		b2.addActionListener(lis);
		b3.addActionListener(lis);
		b4.addActionListener(lis);
		b5.addActionListener(lis);
		b6.addActionListener(lis);
		
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }
    public static void main(String s[]) {
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
    }
}