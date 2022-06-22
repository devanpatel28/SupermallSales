import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.lang.*;

public class Stocks extends JFrame
{
	Listener lis = new Listener(this);
	JLabel l1;
	JButton b1,b2,b3;
	ImageIcon backImage;
	JPanel background;
	JLabel imglabel;
    Stocks()
	{
        super(" Stocks ");
        setLayout(null);
        setBounds(100,100,800,400);
		backImage = new ImageIcon(getClass().getClassLoader().getResource("img\\Stocks-1.jpg"));
		background = new JPanel();
		background.setBounds(0,0,800,400);
			
		imglabel = new JLabel();
		imglabel.setIcon(backImage);
		background.add(imglabel);
		
		//getContentPane().setBackground(Color.LIGHT_GRAY);
		
		l1 = new JLabel("STOCKS");
		b1 = new JButton("Display Items");
		b2 = new JButton("Add Items");
		b3 = new JButton("Modify Items");
		
		Font f1 = new Font("Calibri",Font.ITALIC,40);
		Font f2 = new Font("Calibri",Font.BOLD,30);
		
		b1.setFont(f2);
		b2.setFont(f2);
		b3.setFont(f2);
		l1.setFont(f1);
		
		l1.setBounds(470,50,140 ,50);
		b1.setBounds(400,120,300,50);
		b2.setBounds(400,190,300,50);
		b3.setBounds(400,260,300,50);
		
		l1.setOpaque(true);
		l1.setBackground(Color.WHITE);
		
		add(l1);
		add(b1);
		add(b2);
		add(b3);
		add(background);

		b1.addActionListener(lis);
		b2.addActionListener(lis);
		b3.addActionListener(lis);
		
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });
    }
	/*public void paint(Graphics g) 
    {  
        Toolkit t=Toolkit.getDefaultToolkit();  
        Image i=t.getImage("E://Stocks-1.jpg");  
        g.drawImage(i, 0, 0,this);    
    }*/

    public static void main(String s[]) {
        Stocks st = new Stocks();
        st.setVisible(true);
    }
}