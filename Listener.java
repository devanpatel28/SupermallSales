import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.lang.*;
import java.util.*;

public class Listener implements ActionListener
{	
    MainFrame mf;
    Stocks st;
    StocksAdd sta;
    StocksModify sm;
    DisplayItem ds;
    Sales sl;
    ProfitLoss pl;
    String abc;
	Listener(MainFrame f)
    {
        this.mf = f;
    }
    Listener(Stocks f)
    {
        this.st = f;
    }
    Listener(Sales f)
    {
        this.sl = f;
    }
    Listener(StocksAdd f)
    {
        this.sta = f;
    }
    Listener(DisplayItem f)
    {
        this.ds = f;
    }
    Listener(StocksModify f)
    {
        this.sm = f;
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Stocks"))
        {
            Stocks st = new Stocks();
            st.setVisible(true);
        }
        if(e.getActionCommand().equals("Sales"))
        {
            Sales sl = new Sales();
            sl.setVisible(true);
        }
        if(e.getActionCommand().equals("Profit/Loss"))
        {
            ProfitLoss pl = new ProfitLoss();
            pl.setVisible(true);
        }
		if(e.getActionCommand().equals("EXIT"))
        {
            System.exit(0);
        }
        if(e.getActionCommand().equals("Add Items"))
        {
            StocksAdd sta = new StocksAdd();
            sta.setVisible(true);
        }
        if(e.getActionCommand().equals("Display Items"))
        {
            DisplayItem ds = new DisplayItem();
            ds.setVisible(true);
        }
        if(e.getActionCommand().equals("ADD"))
        {
            if(this.sta.t1.getText().isEmpty() ||
                this.sta.t2.getText().isEmpty() ||
                this.sta.t3.getText().isEmpty() ||
                this.sta.t4.getText().isEmpty() ||
                this.sta.t5.getText().isEmpty() ||
                this.sta.t6.getText().isEmpty() ||
                this.sta.t7.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null," PLEASE ENTER FULL DETAILS ");
            }
            else
            {
                try
                {
                    FileWriter fw = new FileWriter("Stocks.txt",true);
                    fw.write(this.sta.t1.getText()+","+this.sta.t2.getText()+","+this.sta.t3.getText()+","+this.sta.t4.getText()+","+this.sta.t5.getText()+","+this.sta.t6.getText()+","+this.sta.t7.getText()+"\n");
                    fw.close();
                }
                catch(Exception ex)
                {
                    System.out.println(ex);
                }
                this.sta.t1.setText("");
                this.sta.t2.setText("");
                this.sta.t3.setText("");
                this.sta.t4.setText("");
                this.sta.t5.setText("");
                this.sta.t6.setText("");
                this.sta.t7.setText("");
            }
        }
        if(e.getActionCommand().equals("Modify Items"))
        {
            StocksModify sm = new StocksModify();
            sm.setVisible(true);
        }
        if(e.getActionCommand().equals("Save"))
        {
            StocksModify sm = new StocksModify();
            try
				{
					BufferedWriter bw = new BufferedWriter(new FileWriter("Stocks.txt"));
					bw.write(this.sm.ta.getText());
					bw.newLine();
					bw.close();
				}
				catch(Exception ef)
				{
					System.out.println(ef);
				}
                JOptionPane.showMessageDialog(null," Updated Successfully !!! ");
        }
    }
}