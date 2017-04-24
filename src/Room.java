import java.io.Serializable;

public class Room implements Serializable{
	
	private String fName="";
	private String lName="";
	private int roomNo=-1;
	private boolean status=false;
	Queue qObj = new Queue();
	public String toString() {
		
		return "Customer [fName=" + fName + ", lName=" + lName + ", roomNo=" + roomNo + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
		if (fName.matches("[a-zA-Z]*")) {
			this.fName = fName;
		} else {
			do {
				System.err.println("Input is not a valid one");
			} while (!(fName.matches("[a-zA-Z]*")));
		}
		qObj.pushFirstName(fName);
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
		if (lName.matches("[a-zA-Z]*")) {
			this.lName = lName;
		} else {
			do {
				System.err.println("Input is not valid ");
			} while (!(lName.matches("[a-zA-Z]*")));
		}
		qObj.pushLastName(lName);
		status=true;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getRoomNo() {
		return roomNo;

	}
	public void removeCustomer(){
		
		String fName="";
		String lName="";
		int roomNo = -1;
	//	status=false;

	}

	public void setRoomNo(int roomNo) {
		if ((roomNo >= 0 && roomNo < 10)) {
			this.roomNo = roomNo;
		} else {
			do {
				System.err.println("Input is not valid");
			} while (!(roomNo >= 0 && roomNo < 10));
		}
	}

}
