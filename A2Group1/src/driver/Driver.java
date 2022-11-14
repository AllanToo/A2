package driver;

import utilities.*;
import java.io.IOException;

	public class Driver {
		public static void main(String[] args) throws IOException 
		{
			try {
				String fileName = args[0];
				String file = "res/" + fileName;
				Parser xml = new Parser(file);
			}
			
			catch (IndexOutOfBoundsException e) {
				System.out.println("Please enter a valid file name.");
			}
		}
}
