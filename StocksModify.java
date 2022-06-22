import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.lang.*;

public class StocksModify extends JFrame implements ActionListener
{
	Listener lis = new Listener(this);
	JMenuBar mb1;
	JMenu m1;
	JMenuItem mi1,mi2;
	JTextArea ta;
	StocksModify()
	{
		super(" Updating Items Items ");
		setLayout(new GridLayout(1,1));
		setBounds(300,50,900,700);
		setBackground(Color.LIGHT_GRAY);

		mb1 = new JMenuBar();
		m1 = new JMenu("UPDATE");
		mi1 = new JMenuItem("Save");
		mi2 = new JMenuItem("Exit");
		ta = new JTextArea();
		Font f1 = new Font("Calibri",Font.PLAIN,20);
		Font f2 = new Font("Arial",Font.BOLD,15);

		try
		{
			BufferedReader br = new BufferedReader(new FileReader("Stocks.txt"));
			String line = br.readLine();
			
			while(line !=null)
			{
				this.ta.append(line+"\n");
				line = br.readLine();
			}
			br.close();
		}
		catch(Exception ef)
		{
			System.out.println(ef);
		}

		mb1.setBackground(Color.CYAN);
		m1.setFont(f2);
		mi1.setFont(f2);
		mi2.setFont(f2);
		ta.setFont(f1);

		mi1.addActionListener(lis);
		mi2.addActionListener(this);
		m1.add(mi1);
		m1.add(mi2);
		mb1.add(m1);
		setJMenuBar(mb1);
		add(ta);
		ta.setLineWrap(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });
    }
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().equals("Exit"))
		{
			dispose();
		}
	}
    public static void main(String s[]) {
        StocksModify mf = new StocksModify();
        mf.setVisible(true);
    }
}