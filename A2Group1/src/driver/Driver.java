package driver;

import utilities.*;
import java.io.IOException;

	public class Driver {
		public static void main(String[] args) throws IOException 
		{ 	
			if (args[0] == null) {
				System.out.println("Please enter a file name.");
			}
			else {
				String fileName = args[0];
				String file = "res/" + fileName;
				//String file = "res/sample2.xml";
				Parser xml = new Parser(file);
			}
		}
}
