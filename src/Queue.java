import java.io.Serializable;

public class Queue implements Serializable{
	
	int front;
	int back;
	int size;
	String[] fName;
	String[] lName;
	static final int max = 7;

	Queue() {
		fName = new String[max];
		lName = new String[max];
		front = -1;
		back = 0;
		size = 0;
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	public boolean backMax() {
		return (back == (max - 1));
	}

	public boolean isSet() {
		return (size == (max - 1));
	}

	// setting up the push method for first name
	public void pushFirstName(String input) {
		if (!isSet()) {
			if (front <(max )) {
				fName[++front] = input;
			} else {
				front = -1;
				fName[++front] = input;
			}
		} else {
			System.out.println(" Below Customer detail is removed ");
			System.out.println(" First Name : " + fName[back]);
			System.out.println(" Last Name : " + lName[back]);
			fName[back] = input;
		}
		for (int x = 0; x < fName.length; x++) {
			System.out.println(fName[x]);
		}
	}

	// setting up the push method for last name
	public void pushLastName(String input) {
		if (!isSet()) {
			if (front < (max - 1)) {
				lName[front] = input;
			} else {
				front = -1;
				lName[front] = input;
			}
			size++;
		} else {
			System.out.println(" Below Customer detail is removed ");
			System.out.println(" First Name : " + fName[back]);
			System.out.println(" Last Name : " + lName[back]);
			lName[back] = input;

			// Setting up the backward pivot forward
			if (backMax()) {
				back = 0;
			} else {
				back++;
			}
		}
	}

	public String peek() {
		if (!isEmpty()) {
			return (fName[back] + " " + lName[back]);
		} else {
			return null;
		}
	}

	public String pop() {
		if (!isEmpty()) {
			size--;
			return (fName[back] + " " + lName[back++]);
		} else {
			return null;
		}
	}
}
