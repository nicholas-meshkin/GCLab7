import java.util.Scanner;

public class GCLab7 {

	public static void main(String[] args) {

		Scanner scnr = new Scanner(System.in);
		String userName;
		String userEmail;
		String userPhone;
		String userDate;
		String userHTML;

		System.out.println("Please enter a valid Name");
		userName = scnr.nextLine();
		if (nameCheck(userName)) {
			System.out.println("Name is valid!");
		} else {
			System.out.println("Sorry, name is not valid");
		}

		System.out.println("Please enter a valid email");
		userEmail = scnr.nextLine();
		if (emailCheck(userEmail)) {
			System.out.println("Email is valid!");
		} else {
			System.out.println("Sorry, email is not valid");
		}

		System.out.println("Please enter a valid phone number");
		userPhone = scnr.nextLine();
		if (phoneCheck(userPhone)) {
			System.out.println("Phone is valid!");
		} else {
			System.out.println("Sorry, phone is not valid");
		}

		System.out.println("Please enter a valid date");
		userDate = scnr.nextLine();
		if (monthDayCheck(userDate)) {
			System.out.println("Date is valid!");
		} else {
			System.out.println("Sorry, date is not valid");
		}
		
		System.out.println("Please enter an HTML element");
		userHTML = scnr.nextLine();
		if (htmlDoubleCheck(userHTML)) {
			System.out.println("HTML element is valid");
		}else {
			System.out.println("Sorry, your HTML element is not valid");
		}

		scnr.close();

	}

	public static boolean nameCheck(String userName) { // checks if name is in correct format
		String regex = ("[A-Z][a-zA-Z]{0,29}");
		return userName.matches(regex);

	}

	public static boolean emailCheck(String userEmail) { // checks if email is in correct format
		String regex = ("[a-zA-z]{5,30}@[a-zA-z]{5,10}[.][a-zA-z]{2,3}");
		return userEmail.matches(regex);

	}

	public static boolean phoneCheck(String userPhone) {// checks if phone number is in correct format
		String regex = ("[0-9]{3}-[0-9]{3}-[0-9]{4}");
		return userPhone.matches(regex);
	}

	public static boolean dateCheck(String userDate) { // checks if the date is in the right format
		String regex = ("[0-3][0-9][/][0-1][0-9][/][0-2][0-9]{3}");
		return userDate.matches(regex);
	}

	public static boolean monthDayCheck(String userDate) { // checks if the day actually appears on a calendar
		int month;
		int day;
		if (dateCheck(userDate)) {
			day = Integer.parseInt(userDate.substring(0, 2));
			month = Integer.parseInt(userDate.substring(3, 5));
			if (month > 12 || day > 31) {
				return false;
			} else if ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30) {
				return false;
			} else if (month == 2 && day > 29) {
				return false;
			}
			return true;
		}
		return false;
	}
	
	public static boolean htmlDoubleCheck(String userHTML) { //checks if opening and closing tag are the same
		String tag1;
		String tag2;
		if (htmlCheck(userHTML)) {
			tag1 = userHTML.substring(userHTML.indexOf('<')+1, userHTML.indexOf('>'));
			userHTML = userHTML.substring(userHTML.lastIndexOf('<') +1);
			tag2 = userHTML.substring(userHTML.indexOf('/')+1, userHTML.indexOf('>'));
			if (tag1.equals(tag2)) {
				return true;
			}else {return false;}
		}else {return false;}
	}
	
	public static boolean htmlCheck(String userHTML) { // checks if html format is valid
		String regex = ("[<].+[>].*[<][/].+[>]");
		return userHTML.matches(regex);
	}
	

}
