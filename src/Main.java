
import java.io.Serializable;
import java.util.Scanner;

public class Main implements Serializable{

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		Functions obj1 = new Functions();
		
		System.out.println("Welcome To Hotel Room Manegement System.......\n");

		System.out.println("      Login......\n      ");
		
		String name="";
		String password="";
		
		while(!(name.equals("hemal")) || !(password.equals("118"))){//check user name and password
			System.out.print("Enter User Name : ");
			name=sc.next();
			System.out.print("Enter password  : ");
			password=sc.next();
			
			if(!(name.equals("hemal")) || !(password.equals("118"))){//if user name and password correct
				System.out.println("LOGIN FAIL");
			}else{
				System.out.println("LOGIN SUCCESS\n");//if user name and password wrong
			}
		}			

		System.out.println("##WELCOME TO HOTEL ROOM MANEGMENT SYSTEM##\n");

		char selection = 'z';

		// Selection list for the Hotel
		while (selection != 'q' || selection != 'Q') {

			System.out.println("\n\tA: Add a customer to a room");
			System.out.println("\tD: Delete customer from room");
			System.out.println("\tV: View Rooms");
			System.out.println("\tS: Save program data");
			System.out.println("\tL: Load previous data");
			System.out.println("\t3: Display Queue");
			System.out.println("\tQ: Exit\n");

			System.out.print("\n\tEnter your selection here : ");

			selection = sc.next().toLowerCase().charAt(0); // converting the upper case letters to lower case

			switch (selection) {
			
			case 'a':
				obj1.addCustomer();
				break;
				
			case 'v' :
				obj1.viewCustomer();
				break;
				
			case '3':
				obj1.previous();
				break;
				
			case 's':
				obj1.saveData();
				break;
				
			case 'l':
				obj1.load();
				break;
				
			case 'd':
				obj1.deleteCustomer();
				break;
				
			case 'q':
				// exits the system
				System.out.println("\n\tSystem Exiting........!");
				System.exit(1);
				break;
			default:
				// validate
				System.out.println("\n\tInvalid Choice! Try Again...\n");
				break;
			}
		}

	}

}
