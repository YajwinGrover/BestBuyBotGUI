import javax.swing.*;
import java.awt.*;


public class SwingMain {
	static String Fname;
	static String Lname;
	static String address;
	static String city;
	static String state;
	static String email;
	static String phone;
	static int zip;
	static long cardNumber;
	static int cvv;
	static int exMonth;
	static int exYear;
	static String url;
	
	public SwingMain() {

		JOptionPane.showMessageDialog(null, moddedJOp("Welcome to the Best Buy Bot(BBB).\nWe need to get your name, credit card information, and a few other details. \nPlease press ok to continue!"), "BestBuyBot", JOptionPane.PLAIN_MESSAGE);
	String z;
		z = JOptionPane.showInputDialog(null, moddedJOp("Please type the URL of the item you are trying to purchase"), "BestBuyBot", JOptionPane.PLAIN_MESSAGE);

		url = z;
		z = JOptionPane.showInputDialog(null, moddedJOp("Please type your email address"), "BestBuyBot", JOptionPane.PLAIN_MESSAGE);
		email = z;
		z = JOptionPane.showInputDialog(null, moddedJOp("Please type your phone number"),"BestBuyBot", JOptionPane.PLAIN_MESSAGE);
		phone = z;
	z = JOptionPane.showInputDialog(null, moddedJOp("Please input your first name"), "BestBuyBot", JOptionPane.PLAIN_MESSAGE);
	Fname = z;
	
	z = JOptionPane.showInputDialog(null, moddedJOp("Please input your last name"), "BestBuyBot", JOptionPane.PLAIN_MESSAGE);
	 Lname = z;
	
	 z = JOptionPane.showInputDialog(null, moddedJOp("Please supply us with your address (number, and street name)"), "BestBuyBot", JOptionPane.PLAIN_MESSAGE);
	this.address = z;
	
	z = JOptionPane.showInputDialog(null, moddedJOp("Please tell us your city"), "BestBuyBot", JOptionPane.PLAIN_MESSAGE);
	city = z;
	
	z = JOptionPane.showInputDialog(null, moddedJOp("Please tell us your state"), "BestBuyBot", JOptionPane.PLAIN_MESSAGE);
	state = z;
	
	z = JOptionPane.showInputDialog(null, moddedJOp("Please input your zipcode"), "BestBuyBot", JOptionPane.PLAIN_MESSAGE);
	int t = Integer.parseInt(z);
	zip = t;
	 
	z = JOptionPane.showInputDialog(null, moddedJOp("Please enter your credit card information"), "BestBuyBot", JOptionPane.PLAIN_MESSAGE);
	long i = Long.parseLong(z);
	cardNumber = i;
	
	z = JOptionPane.showInputDialog(null, moddedJOp("Please enter your security number (three numbers on the back)"), "BestBuyBot", JOptionPane.PLAIN_MESSAGE);
	int ji = Integer.parseInt(z);
	cvv = ji;
	
	z = JOptionPane.showInputDialog(null, moddedJOp("Please enter the month of expiration"), "BestBuyBot", JOptionPane.PLAIN_MESSAGE);
	ji = Integer.parseInt(z);
	exMonth = ji;
	
	z = JOptionPane.showInputDialog(null, moddedJOp("Please enter the year of expiration"), "BestBuyBot", JOptionPane.PLAIN_MESSAGE);
	ji = Integer.parseInt(z);
	exYear = ji;
	
	JOptionPane.showMessageDialog(null, moddedJOp("Thank you for cooperating with us, our bot will do the rest"), "BestBuyBot", JOptionPane.PLAIN_MESSAGE);
	
		   
	}

	private JPanel moddedJOp(String text){
		JPanel panel = new JPanel();
		panel.setOpaque(true);
		panel.setBackground(Color.LIGHT_GRAY);
		try
		{
			java.net.URL url = new java.net.URL("https://www.bing.com/th?id=OIP.fQHfJ8DmU3rGe0YqE3b15QHaFj&w=135&h=101&c=8&rs=1&qlt=90&o=6&dpr=1.5&pid=3.1&rm=2");
			ImageIcon image = new ImageIcon(url);
			panel.add(new JLabel("", image, JLabel.LEFT));
			JTextArea area = new JTextArea(text);
			area.setForeground(Color.BLACK);
			area.setBackground(Color.LIGHT_GRAY);
			area.setEditable(false);
			panel.add(area);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return panel;
	}

	public static void main(String args[]){
			new SwingMain();
			System.out.println(Fname);
			System.out.println(Lname);
			System.out.println(address);
			System.out.println(city);
			System.out.println(state);
			System.out.println(zip);
			System.out.println(cardNumber);
			System.out.println(cvv);
			System.out.println(exMonth);
			System.out.println(exYear);
			
    }

}
