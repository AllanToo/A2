package Driver;

import utilities.*;
import java.io.IOException;

	public class Driver {
		public static void main(String[] args) throws IOException 
		{
			try {
				String fileName = args[0];
	
				Parser xml = new Parser(fileName);
			}
			
			catch (IndexOutOfBoundsException e) {
				System.out.println("Please enter a valid file name.");
			}
		}
}
