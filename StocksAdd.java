import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.lang.*;

public class StocksAdd extends Frame
{
	Listener lis = new Listener(this);
	Label l1,l2,l3,l4,l5,l6,l7;
	TextField t1,t2,t3,t4,t5,t6,t7;
	JButton b1;
	StocksAdd()
	{
		super(" Adding New Items ");
		setLayout(null);
		setBounds(300,50,600,700);
		setBackground(Color.LIGHT_GRAY);
		
		l1 = new Label("Item No. : ");
		t1 = new TextField();

		l2 = new Label("Item Name : ");
		t2 = new TextField();
		
		l3 = new Label("Item Company : ");
		t3 = new TextField();
		
		l4 = new Label("Item Buy Rate : ");
		t4 = new TextField();
		
		l5 = new Label("Item Sale Rate : ");
		t5 = new TextField();
		
		l6 = new Label("Item Quantity : ");
		t6 = new TextField();
		
		l7 = new Label("Item Sales : ");
		t7 = new TextField();

		b1 = new JButton("ADD");
		
		Font f1 = new Font("Calibri",Font.BOLD,25);
		Font f2 = new Font("Calibri",Font.BOLD,20);

		l1.setFont(f2);
		t1.setFont(f1);
		l2.setFont(f2);
		t2.setFont(f1);
		l3.setFont(f2);
		t3.setFont(f1);
		l4.setFont(f2);
		t4.setFont(f1);
		l5.setFont(f2);
		t5.setFont(f1);
		l6.setFont(f2);
		t6.setFont(f1);
		l7.setFont(f2);
		t7.setFont(f1);
		b1.setFont(f2);
		
		l1.setBounds(100,100,200,50);
		t1.setBounds(300,100,200,50);

		l2.setBounds(100,170,200,50);
		t2.setBounds(300,170,200,50);
		
		l3.setBounds(100,240,200,50);
		t3.setBounds(300,240,200,50);
		
		l4.setBounds(100,310,200,50);
		t4.setBounds(300,310,200,50);
		
		l5.setBounds(100,380,200,50);
		t5.setBounds(300,380,200,50);
		
		l6.setBounds(100,450,200,50);
		t6.setBounds(300,450,200,50);
		
		l7.setBounds(100,520,200,50);
		t7.setBounds(300,520,200,50);

		b1.setBounds(200,600,150,50);
		
		add(l1);
		add(t1);
		add(l2);
		add(t2);
		add(l3);
		add(t3);
		add(l4);
		add(t4);
		add(l5);
		add(t5);
		add(l6);
		add(t6);
		add(l7);
		add(t7);
		add(b1);

		t1.addActionListener(lis);
		t2.addActionListener(lis);
		t3.addActionListener(lis);
		t4.addActionListener(lis);
		t5.addActionListener(lis);
		t6.addActionListener(lis);
		t7.addActionListener(lis);
		b1.addActionListener(lis);


        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });
    }

    public static void main(String s[]) {
        StocksAdd mf = new StocksAdd();
        mf.setVisible(true);
    }
}