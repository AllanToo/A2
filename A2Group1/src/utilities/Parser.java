package utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Parser {

	public Parser(String file) throws IOException {
		xmlParser(file);
	}

	public void xmlParser(String file) throws IOException {


		final String FILENAME = "res/sample2.xml";
		BufferedReader br = new BufferedReader(new FileReader(FILENAME));

		String line = "";
		int lineLength;
		String endTag = "";
		int i; // Counter
		int index; // Index Holder
		int lineCounter = 1; // Used to keep track of line numbers for errors in files
		String tagCheck = "";
		boolean isValid = false;
		boolean tagFinished = false;
		boolean openTag = false;
		ArrayList<String> expectedTags = new ArrayList<String>(); // ArrayList to ensure all opened tags are closed
		ArrayList<Integer> lineTags = new ArrayList<Integer>(); // Parallel ArrayList to keep track of lines where tags are opened
		ArrayList<String> errorTags = new ArrayList<String>(); // Keeps a list of all error tags
		ArrayList<Integer> errorLines = new ArrayList<Integer>();
		br.mark(10000);
		// Reads all lines in the file
		while(br.readLine() != null) {
			i = 0;
			endTag = "";
			isValid = false;
			line = br.readLine();
			lineLength = line.length();
			
			// Checks for a self-ending tag, no errors will be found here
			if (line.contains("/>")) {
				// No action needed
			}

			// Checks if the line is an endTag, created tag needs to be removed from the list
			else if (line.contains("</")) {

				while (i < lineLength) {
					tagCheck = Character.toString(line.charAt(i));

					if (endTag.length() == 1) {
						if (tagCheck.equals("/")) {
							// is a natural end tag
						}
						else {
							endTag = "</";
							openTag = true;
						}
					}
					if (tagCheck.equals("<")) {
						endTag = "<";
						isValid = true;
					}

					else if (tagCheck.equals(">")) {
						endTag += ">";
						isValid = false;

						if (openTag == true) {
							expectedTags.add(endTag);
							openTag = false;
						}
						else {
							// Retrieves the index of the last opened tag
							index = expectedTags.size() -1;

							// if the current end tag doesnt match the last opened tag, error is raised
							if (!endTag.equals(expectedTags.get(index))) {
								expectedTags.remove(index);
								errorTags.add(endTag);
								errorLines.add(lineCounter);
							}

							else {
								expectedTags.remove(index);
							}
						}
					}

					else if (isValid == true) {
						if (tagCheck.equals(" ")) {
							endTag += ">";
							isValid = false;
						}
						else {
							endTag += tagCheck;
						}
					}
					i++;
				}
			}


			// Handles beginning tags and adds them to the expectedTags list
			// Tested, handles tags in the correct format
			else {
				while (i < lineLength) {
					tagCheck = Character.toString(line.charAt(i));

					if (tagCheck.equals("<")) {
						endTag = "<";
						endTag += "/";
						isValid = true;
					}

					else if (tagCheck.equals(">") && isValid == true) {
						endTag += ">";
						isValid = false;
					}

					else if (isValid == true) {
						if (tagCheck.equals(" ")) {
							endTag += ">";
							isValid = false;
						}
						else {
							endTag += tagCheck;
						}
					}

					//else if 
					i++;
				}
				expectedTags.add(endTag);
				lineTags.add(lineCounter);

			}
			lineCounter++;
		}
		i = 0;
		lineCounter = 1;
		System.out.println("File has been processed.");
		
		// If errors were logged, then a loop runs to display the lines where errors were found.
		if (errorTags.size() > 0) {
			System.out.println(errorTags.size() + " error(s) were found with the following lines: ");
			br.reset();
			
			while (br.readLine() != null) {
				line = br.readLine();
				if (errorLines.get(i) == lineCounter) {
					System.out.println(line);
					i++;
				}
				lineCounter++;
			}
		}
	}
}

