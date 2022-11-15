import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import utilities.MyDLL;


/**
 * 
 * @author Paul Holck
 * Takes in a file path for an xml file and checks for correct formatting 
 * and outputs lines with formatting issues
 * 
 * @param String filename
 */

public class Parser {

	public Parser(String file) throws IOException {
		xmlParser(file);
	}

	public void xmlParser(String file) throws IOException {


		//final String FILENAME = "res/sample2.xml";
		BufferedReader br = new BufferedReader(new FileReader(file));

		String line = "";
		int lineLength;
		String endTag = "";
		String rootTag = "";
		int i; // Counter
		int index; // Index Holder
		int lineCounter = 1; // Used to keep track of line numbers for errors in files
		String tagCheck = "";
		boolean isValid = false;
		boolean tagFinished = false;
		boolean openTag = false;
		boolean endReached = false;
		//ArrayList<String> openedTags = new ArrayList<String>(); // ArrayList to ensure all opened tags are closed
		MyDLL<String> openedTags = new MyDLL();
		MyDLL<Integer> errorLines = new MyDLL();
		br.mark(1000000); // reset for reader

		// Reads all lines in the file
		while(br.readLine() != null) {
			i = 0;
			endTag = "";
			isValid = false;
			endReached = false;
			line = br.readLine();
			lineLength = line.length();
			// System.out.println(line);

			// Checks for a self-ending tag, no errors will be found here
			if (line.contains("/>")) {
				// No action needed
			}

			// Checks if the line has an endTag, can contain an opening and closing tag
			else if (line.contains("</")) {
				while (i < lineLength) {
					tagCheck = Character.toString(line.charAt(i));

					if (endTag.length() == 1) {
						if (tagCheck.equals("/")) {
							// is a natural end tag
						}
						else {
							// adds a slash to an opening tag to match its endTag in the list
							endTag = "</";
							openTag = true;
							endReached = false;
						}
					}

					if (tagCheck.equals("<")) {
						endTag = "<";
						isValid = true;
					}

					else if (tagCheck.equals(">") && isValid == true) {
						endTag += ">";
						isValid = false;

						// Catches adding an open tag
						if (openTag == true) {
							openTag = false;
							if (endTag == rootTag) {
								if (!errorLines.contains(lineCounter)){
									errorLines.add(lineCounter);
								}
							}
							else {
								openedTags.add(endTag);
							}
						}

						// For removing the found endTag from the list of open tags
						else {
							// Retrieves the index of the last opened tag
							index = openedTags.size() -1;

							// if the current end tag doesnt match the last opened tag, error is raised
							if (!endTag.equals(openedTags.get(index))) {
								openedTags.remove(index);
								endReached = true;
								if (!errorLines.contains(lineCounter)){
									errorLines.add(lineCounter);
								}
							}

							else {
								endReached = true;
								if (endTag == rootTag && openedTags.size() == 1) {
									openedTags.remove(index);
								}
								else if (endTag == rootTag && openedTags.size() != 1) {
									if (!errorLines.contains(lineCounter)){
										errorLines.add(lineCounter);
									}
								}
								else {
									openedTags.remove(index);
								}
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

					else if (endReached == true && !tagCheck.equals(" ")) {
						if (!errorLines.contains(lineCounter)){
							errorLines.add(lineCounter);
						}
					}
					i++;
				}
			}


			// Handles beginning tags and adds them to the openedTags list
			// Tested, handles tags in the correct format
			else {
				while (i < lineLength) {
					tagCheck = Character.toString(line.charAt(i));

					if (tagCheck.equals("<")) {
						endTag = "<";
						endTag += "/";
						isValid = true;
					}

					else if (tagCheck.equals(">") && endReached == false) {
						if (isValid == true) {
							endTag += ">";
						}
						isValid = false;
						endReached = true;
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

					// Raises an error if there is more data after opening tag-only lines
					else if (endReached == true) {
						if (tagCheck.equals(" ")) {
						}
						else {
							if (!errorLines.contains(lineCounter)){
								errorLines.add(lineCounter);
							}
						}
					}

					i++;
				}
				openedTags.add(endTag);

				if (lineCounter == 1) {
					rootTag = endTag;
				}

			}
			lineCounter++;
		}
		i = 0;
		lineCounter = 1;
		System.out.println("File has been processed.");

		// If errors were logged, then a loop runs to display the lines where errors were found.
		if (errorLines.size() > 0) {
			System.out.println("Errors were found with the following lines: ");
			br.reset();

			while (br.readLine() != null) {
				line = br.readLine();
				if (i == errorLines.size()) {
					break;
				}
				else if (errorLines.get(i) == lineCounter) {
					System.out.println(line);
					i++;
				}
				lineCounter++;
			}
		}
	}
}
