package andy.test.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import sun.reflect.ReflectionFactory.GetReflectionFactoryAction;

public class Main {

	public static void main(String[] args) {
		try {	
			FileInputStream fin = new FileInputStream("input.txt");
			int i;
			do {
				 i = fin.read();
				if (i != -1) System.out.println((char) i);
				
			}while (i != -1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
