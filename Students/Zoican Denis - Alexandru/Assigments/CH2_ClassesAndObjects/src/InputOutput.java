import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class InputOutput {

	public void readFromFile(Polynomials eu) {
		File file = new File("C:\\Users\\zoica\\eclipse-workspace\\CH2_Classes_and_objects\\src\\pol.txt");
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String s1;
		String s2;
		
		s1 = scanner.nextLine();
		s2 = scanner.nextLine();
		
		String op[] = new String[100];
		int ok = 0;
		while(scanner.hasNext())
		{
			String c = scanner.nextLine();
			op[ok]=c;
			ok++;
		}
		
		ok--;
		String op2[] = new String[ok];
		
		for(int i=0;i<ok;i++)
		{
			op2[i]=op[i];
		}
		eu.changeStrings(s1, s2, op2);
	}
	
	public void resetFile() {
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter("C:\\Users\\zoica\\eclipse-workspace\\CH2_Classes_and_objects\\src\\output.txt"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			out.write("");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void writeInFile(String S){
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter("C:\\Users\\zoica\\eclipse-workspace\\CH2_Classes_and_objects\\src\\output.txt",true));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
		    out.write(S);  
		}
		catch (IOException e)
		{
		    System.out.println("Exception ");

		}
		finally
		{
		    try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	}

}
