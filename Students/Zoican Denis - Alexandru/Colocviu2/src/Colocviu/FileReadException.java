package Colocviu;

public class FileReadException extends Exception{
	public FileReadException(String msg) {
		super("Exception for reading: "+msg);
	}
}
