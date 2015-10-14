package andy.test.inherit.demo3;

import java.io.*;
import java.io.Serializable;
/**
 * private members of a superclass are indeed available (but not accessible) in the subclass's objects
 * Open MyData1.txt and the private member named 'bhavesh' is still there
 * @author Andy
 *
 */
public class ChildClass extends ParentClass {
	public ChildClass() {
		super();
	}

	public static void main(String[] args) {
		ChildClass childObj = new ChildClass();
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("d:\\MyData1.txt"));
			oos.writeObject(childObj); // Writing child class object and not
										// parent class object
			System.out.println("Writing complete !");
		} catch (IOException e) {
			e.printStackTrace();
		}
		catch (Exception ex){
			ex.printStackTrace();
		}

	}
}
