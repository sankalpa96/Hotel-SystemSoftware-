import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

public class Functions implements Serializable{

	private static Room[] hotelRoom = new Room[10];
	private static Scanner sc = new Scanner(System.in);
	public Room obj = null;

	public void addCustomer() {//add customer to a room
		
		//System.out.println("Enter the room : ");
		 boolean isNumber;
		 int roomNum=0;
		   do{
		       System.out.print("Room No:");
		       //integer validating
		       if(sc.hasNextInt()){  
		    	   
		    	   roomNum = (sc.nextInt() - 1);
		          
		              isNumber=true;
		       }else{
		       System.out.println("invalid input");
		       isNumber=false;
		       sc.next();
		       }
		   }while(!(isNumber) );
		while(roomNum>10){
			
			System.out.println("invalid input");
			 System.out.print("Room No:");
			 roomNum=sc.nextInt();
			
		}
		
		System.out.println(roomNum);

		if (hotelRoom[roomNum] != null) {
			obj = hotelRoom[roomNum];
		} else {
			obj = new Room();
		}
		System.out.println("First Name u  : ");
		obj.setfName(sc.next());
		System.out.println("Last Name u : ");
		obj.setlName(sc.next());
		hotelRoom[roomNum] = obj;
	}
	
	public void viewCustomer(){//view all rooms
		
		   for(int i=0;i<10;i++){
		          //check for null and empty indexes in customer String array
		         if(hotelRoom[i]==null ) {
		                  System.out.println("Room number "+(i+1)+" is empty");
		         }else{
		               System.out.println("Room number "+(i+1)+" is occupied");
		         }       
		   }
		
	}

	public void deleteCustomer() {//delete customer
		
		System.out.println("Enter the room : ");
		 boolean isNumber;
		 int roomNum=0;
		   do{
		       System.out.print("Room No:");
		       //integer validating
		       if(sc.hasNextInt()){   
		    	   roomNum = (sc.nextInt() - 1);
		          
		              isNumber=true;
		       }else{
		       System.out.println("invalid input");
		       isNumber=false;
		       sc.next();
		       }
		   }while(!(isNumber) );
		   while(roomNum>10){
				
				System.out.println("invalid input");
				 System.out.print("Room No:");
				 roomNum=sc.nextInt();
				
			}
		System.out.println(roomNum);
		if (hotelRoom[roomNum].isStatus()){
			hotelRoom[roomNum].removeCustomer();
		    hotelRoom[roomNum]=null;
		}else {
			System.out.println("No Customer");
		}
	}

	public void previous() {//queue
		
		System.out.println("Enter the room : ");
		int roomNum = (sc.nextInt() - 1);
		for (int x = 0; x < 3; x++) {
			if (hotelRoom[roomNum].qObj.peek() != null) {
				System.out.println(hotelRoom[roomNum].qObj.pop());
			}
		}
	}

	public void saveData() throws Exception {//Save to file
		
		File file = new File("file.txt");
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(hotelRoom);
		oos.flush();
		oos.close();
		fos.close();
	}

	public void load() throws Exception {//Loading from the file
		
		File file = new File("file.txt");
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		hotelRoom = (Room[]) ois.readObject();
	}
}
