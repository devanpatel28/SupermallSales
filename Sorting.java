import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.lang.*;

public class Sorting extends Frame
{
	TextField t1;
	Sorting()
	{
		super(" Sorted Items By Brands ");
		setLayout(null);
		setBounds(300,50,600,600);
		setBackground(Color.LIGHT_GRAY);
		
		t1 = new TextField("<items>");

		Font f1 = new Font("Calibri",Font.ITALIC,15);
		t1.setFont(f1);
		
		add(t1);
		
		t1.setBounds(50,50,500,500);

		addWindowListener(new WindowAdapter()
			{
				public void windowClosing(WindowEvent we)
				{
					System.exit(0);
				}
			});
	}
	public static void main(String args[])
	{
			Sorting fa = new Sorting();
			fa.setVisible(true);
	}
}