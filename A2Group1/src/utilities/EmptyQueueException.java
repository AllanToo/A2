package utilities;

public class EmptyQueueException extends Exception {
   // Constructor
	
	public EmptyQueueException()
	{
		super();
	}
	
	
	/*  Constructor to provide a message
	 * @param message invoked from method that called this constructor
	 */
	
	public EmptyQueueException(String message)
	{
		super(message);
	}
}
