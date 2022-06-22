import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.lang.*;
import java.util.*;

public class ProfitLoss extends JFrame {
	JLabel l1, l2, prof;
	ImageIcon backImage;
	JPanel background;
	JLabel imglabel;
	Sales sl = new Sales();

	ProfitLoss() {
		super(" Profit And Loss ");
		setLayout(null);
		setBounds(0, 0, 600, 300);
		backImage = new ImageIcon(getClass().getClassLoader().getResource("img\\profit-1.jpg"));
		background = new JPanel();
		background.setBounds(0,0,600,300);
		
		imglabel = new JLabel();
		imglabel.setIcon(backImage);
		background.add(imglabel);
		//getContentPane().setBackground(Color.LIGHT_GRAY);

		l1 = new JLabel("Profit / Loss : ");
		prof = new JLabel();
		prof.setOpaque(true);

		l2 = new JLabel(" (+) Profit and (-) Loss ");

		try {
			ArrayList<Integer> tempArray = new ArrayList<>();
			BufferedReader bufReader = new BufferedReader(new FileReader("Stocks.txt"));
			String line = bufReader.readLine();
			while (line != null) {
				String arr[] = line.split(",");
				// (arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6]);

				int multi = Integer.parseInt(arr[3]) * Integer.parseInt(arr[6]);
				tempArray.add(multi);
				line = bufReader.readLine();
			}

			bufReader.close();
			int sum = 0;
			for (int loop = 0; loop < tempArray.size(); loop++) {
				sum = sum + (tempArray.get(loop));
			}
			char sale[] = new char[10];
			FileReader fr = new FileReader("profitloss.txt");
			fr.read(sale);
			fr.close();
			String sum1 = new String(sale);
			int sales = Integer.parseInt(sum1.trim());
			int p = sales - sum;
			String profit = String.valueOf(p);
			this.prof.setText(profit);
			if(p>0)
			{
				this.prof.setBackground(Color.GREEN);
			}
			else
			{
				this.prof.setBackground(Color.RED);
			}
			
		} catch (Exception i) {
			System.out.println(i);
		}

		Font f1 = new Font("Calibri", Font.BOLD, 20);
		Font f2 = new Font("Calibri", Font.BOLD, 30);
		Font f3 = new Font("Calibri", Font.PLAIN, 35);

		l1.setFont(f2);
		prof.setFont(f3);
		l2.setFont(f1);

		add(l1);
		add(prof);
		add(l2);
		add(background);

		l1.setBounds(150, 80, 200, 50);
		prof.setBounds(350, 80, 200, 50);

		l2.setBounds(390, 180, 500, 50);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				dispose();
			}
		});
	}

	public static void main(String args[]) {
		ProfitLoss fa = new ProfitLoss();
		fa.setVisible(true);
	}
}