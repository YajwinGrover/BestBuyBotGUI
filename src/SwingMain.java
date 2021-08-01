import javax.swing.*;


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
	JOptionPane.showMessageDialog(null, "Welcom to the best buy bot buying thing, name is still work in progress.  We will be needing to get your name, credit card information, and a few other details.  Please press ok to continue");
	String z;
		z = JOptionPane.showInputDialog("Please type the URL of the item you are trying to purchase");
		url = z;
		z = JOptionPane.showInputDialog("Please type your email address");
		email = z;
		z = JOptionPane.showInputDialog("Please type your phone number");
		phone = z;
	z = JOptionPane.showInputDialog("Please type in your first name");
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
	zip = t;
	 
	z = JOptionPane.showInputDialog("Please enter your credit card information");
	long i = Long.parseLong(z);
	cardNumber = i;
	
	z = JOptionPane.showInputDialog("Please enter your security number (three numbers on the back)");
	int ji = Integer.parseInt(z);
	cvv = ji;
	
	z = JOptionPane.showInputDialog("Please enter the month of expiration");
	ji = Integer.parseInt(z);
	exMonth = ji;
	
	z = JOptionPane.showInputDialog("Please enter the year of expiration");
	ji = Integer.parseInt(z);
	exYear = ji;
	
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
