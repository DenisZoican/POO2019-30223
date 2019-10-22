import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.Vector;


public class Polynomials {
	
	public String s1;
	public String s2;
	
	public String op[];
	public void changeStrings (String S1,String S2,String OP[]) {
		this.s1 = S1;
		this.s2 = S2;
		this.op = OP; 
	}
	public static void main(String[] args) {
		
		Polynomials eu = new Polynomials();
		Functions functions = new Functions();
		InputOutput inputOutput = new InputOutput();
		
		String s1 = null,s2 = null;
		
		inputOutput.readFromFile(eu);

		inputOutput.resetFile();
		
		for(int i=0;i<eu.op.length;i++)
		{
			inputOutput.writeInFile("\n"+eu.op[i]+"\n");
			
			if(eu.op[i].contentEquals("ADD")==true)
			{
				functions.ADD(eu.s1,eu.s2);
			} else 
			if(eu.op[i].contentEquals("SUBTRACT")==true)
			{
				functions.SUBTRACT(eu.s1,eu.s2);
			} else 
			if(eu.op[i].contentEquals("MULTIPLY")==true)
			{
				functions.MULTIPLY(eu.s1,eu.s2);
			} else 
			if(eu.op[i].contains("MUL_SCAL")==true)
			{
				String nr = eu.op[i].replaceAll("MUL_SCAL ","");
				nr = nr.replace(" ", "");
				int n = Integer.parseInt(nr);
				functions.MUL_SCA(eu.s1,eu.s2, n);
			} else 
			if(eu.op[i].contains("EVAL")==true)
			{
				String nr = eu.op[i].replaceAll("EVAL ","");
				nr = nr.replace(" ", "");
				int n = Integer.parseInt(nr);
				functions.EVAL(eu.s1,eu.s2, n);
			} 
		}
		
		inputOutput.writeInFile("DIVIDE:\n");
		functions.DIVIDE(eu.s1, eu.s2);
		inputOutput.writeInFile("\nRoot aprox:");
		functions.rootAprox(eu.s1, 3, 4);
	}
}
