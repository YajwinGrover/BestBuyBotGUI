package hack2021;
import javax.swing.*;


public class SwingMain {
	static String Fname;
	static String Lname;
	static String address;
	static String city;
	static String state;
	static int zip;
	static int cardNumber;
	static int cvv;
	static int exMonth;
	static int exYear;
	
	public SwingMain() {
	JOptionPane.showMessageDialog(null, "Welcom to the best buy bot buying thing, name is still work in progress.  We will be needing to get your name, credit card information, and a few other details.  Please press ok to continue");
	String z = JOptionPane.showInputDialog("Please type in your first name");
	Fname = z;
	
	z = JOptionPane.showInputDialog("Please type in your last name");
	 Lname = z;
	
	 z = JOptionPane.showInputDialog("Please type your building number and street name of your home");
	this.address = z;
	
	z = JOptionPane.showInputDialog("Please type your city");
	city = z;
	
	z = JOptionPane.showInputDialog("Please type your state");
	state = z;
	
	z = JOptionPane.showInputDialog("Please type your zipcode");
	int t = Integer.parseInt(z);
	 
	z = JOptionPane.showInputDialog("Please enter your credit card information");
	int i = Integer.parseInt(z);
	cardNumber = i;
	
	z = JOptionPane.showInputDialog("Please enter your security number (three numbers on the back)");
	i = Integer.parseInt(z);
	cvv = i;
	
	z = JOptionPane.showInputDialog("Please enter the month of expiration");
	i = Integer.parseInt(z);
	exMonth = i;
	
	z = JOptionPane.showInputDialog("Please enter the year of expiration");
	i = Integer.parseInt(z);
	exYear = i;
	
	JOptionPane.showMessageDialog(null, "Thank you for coroperating with us, our bot will do the rest");
	
		   
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
