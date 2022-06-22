import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.lang.*;
import java.util.*;

public class Sales extends JFrame {
    Listener lis = new Listener(this);
    JLabel l1;
    JLabel l2;
	ImageIcon backImage;
	JPanel background;
	JLabel imglabel;
    ArrayList<Integer> tempArray;

    Sales() {
        super(" Total Sales ");
        setLayout(null);
        setBounds(100, 100, 700, 400);
		backImage = new ImageIcon(getClass().getClassLoader().getResource("img\\sales-1.jpg"));
		background = new JPanel();
		background.setBounds(0,0,700,400);
		
		imglabel = new JLabel();
		imglabel.setIcon(backImage);
		background.add(imglabel);

        l1 = new JLabel("TOTAL SALES (In Ruppee) : ");

        try {
            ArrayList<Integer> tempArray = new ArrayList<>();
            BufferedReader bufReader = new BufferedReader(new FileReader("Stocks.txt"));
            String line = bufReader.readLine();
            while (line != null) {
                String arr[] = line.split(",");
                // (arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6]);

                int multi = Integer.parseInt(arr[4]) * Integer.parseInt(arr[6]);
                tempArray.add(multi);
                line = bufReader.readLine();
            }

            bufReader.close();
            int sum = 0;
            for (int loop = 0; loop < tempArray.size(); loop++) {
                sum = sum + (tempArray.get(loop));
            }
            String str = String.valueOf(sum);
            l2 = new JLabel(str + "/-");

            FileWriter fw = new FileWriter("profitloss.txt");
            fw.write(str);
            fw.close();

        } catch (Exception i) {
            System.out.println(i);
        }

        l1.setBounds(50, 130, 400, 50);
        l2.setBounds(450, 130, 200, 50);

        l1.setFont(new Font("Calibri", Font.BOLD, 30));
        l2.setFont(new Font("Calibri", Font.PLAIN, 40));
		
		
		
		
		
        add(l1);
        add(l2);
		add(background);
		
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });
    }

    public static void main(String s[]) {
        Sales sl = new Sales();
        sl.setVisible(true);
    }
}