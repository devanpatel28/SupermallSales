import java.awt.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.*;

public class DisplayItem extends JFrame {
	Listener lis = new Listener(this);
	JMenuBar mb;
	JMenu m1,m2,m3,m4,m5,m6,m7;
	Font f,f5;
	String no, name, company, BRate, SRate, quant, sales;
	ArrayList<DisplayItem> dataDetail;

	DisplayItem(String no, String name, String company, String BRate, String SRate, String quant, String sales) {
		this.no = no;
		this.name = name;
		this.company = company;
		this.BRate = BRate;
		this.SRate = SRate;
		this.quant = quant;
		this.sales = sales;

	}

	DisplayItem() {
		super("All Items");
		setLayout(null);
		setBounds(100, 100, 700, 400);
		setVisible(true);
		setBackground(Color.GRAY);
		int count = 0;
		try {
			File f = new File("Stocks.txt");
			Scanner sc = new Scanner(f);
			while (sc.hasNextLine()) {
				sc.nextLine();
				count++;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		JLabel[] no = new JLabel[count];
		JLabel[] name = new JLabel[count];
		JLabel[] company = new JLabel[count];
		JLabel[] BRate = new JLabel[count];
		JLabel[] SRate = new JLabel[count];
		JLabel[] quant = new JLabel[count];
		JLabel[] sales = new JLabel[count];
		JMenuBar mb = new JMenuBar();
		JMenu m1 = new JMenu("      SR No.     |");
		JMenu m2 = new JMenu("Item Name |");
		JMenu m3 = new JMenu(" Company   |");
		JMenu m4 = new JMenu(" Buy Rate   |");
		JMenu m5 = new JMenu(" Sale Rate    |");
		JMenu m6 = new JMenu(" Quantity   |");
		JMenu m7 = new JMenu(" Saled");
		Font f5 = new Font("Calibri",Font.BOLD,16);
		mb.add(m1);
		mb.add(m2);
		mb.add(m3);
		mb.add(m4);
		mb.add(m5);
		mb.add(m6);
		mb.add(m7);
		m1.setFont(f5);
		m2.setFont(f5);
		m2.setFont(f5);
		m3.setFont(f5);
		m4.setFont(f5);
		m5.setFont(f5);
		m6.setFont(f5);
		m7.setFont(f5);
		setJMenuBar(mb);
		mb.setBackground(Color.BLACK);
		m1.setForeground(Color.WHITE);
		m2.setForeground(Color.WHITE);
		m3.setForeground(Color.WHITE);
		m4.setForeground(Color.WHITE);
		m5.setForeground(Color.WHITE);
		m6.setForeground(Color.WHITE);
		m7.setForeground(Color.WHITE);
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("Stocks.txt"));
			dataDetail = new ArrayList<DisplayItem>();
			setLayout(new GridLayout(count, 7));
			for (int j = 0; j < count; j++) {
				String st1 = br.readLine();
				String arr[] = st1.split(",");
				dataDetail.add(new DisplayItem(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6]));

				no[j] = new JLabel(arr[0], SwingConstants.CENTER);
				name[j] = new JLabel(arr[1], SwingConstants.CENTER);
				company[j] = new JLabel(arr[2], SwingConstants.CENTER);
				BRate[j] = new JLabel(arr[3], SwingConstants.CENTER);
				SRate[j] = new JLabel(arr[4], SwingConstants.CENTER);
				quant[j] = new JLabel(arr[5], SwingConstants.CENTER);
				sales[j] = new JLabel(arr[6], SwingConstants.CENTER);

				no[j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
				name[j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
				company[j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
				BRate[j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
				SRate[j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
				quant[j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
				sales[j].setBorder(BorderFactory.createLineBorder(Color.BLACK));

				add(no[j]);
				add(name[j]);
				add(company[j]);
				add(BRate[j]);
				add(SRate[j]);
				add(quant[j]);
				add(sales[j]);

				Font f = new Font("Calibri", Font.PLAIN, 15);
				no[j].setFont(f);
				name[j].setFont(f);
				company[j].setFont(f);
				BRate[j].setFont(f);
				SRate[j].setFont(f);
				quant[j].setFont(f);
				sales[j].setFont(f);
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				dispose();
			}
		});
	}

	public static void main(String s[]) throws IOException {
		DisplayItem ds = new DisplayItem();
	}
}