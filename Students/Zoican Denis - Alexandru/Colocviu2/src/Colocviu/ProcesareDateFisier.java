package Colocviu;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

class ProcesareDateFisier {
	public static void main(String[] args) {
		
		
		String nume = null;
		String prenume = null;
		Integer varsta = null;
		String sex = null;
		
		int i = 0;
		
		File file = new File("input.txt");
		try (Scanner sc = new Scanner(file, StandardCharsets.UTF_8.name())) {
			while (sc.hasNextLine()) {
				i++;
				if(i==1)
				nume = sc.nextLine();
				if(i==2)
				prenume = sc.nextLine();
				if(i==3)
				varsta = sc.nextInt();
				if(i==4)
				sex = sc.nextLine();
				
			}
			
			if(varsta<0) {
				throw new WrongAgeFormat();
			}
			

			if(nume==null || prenume==null || varsta==null || sex==null)
				throw new IncompleteDataException();
			
		}  
		catch (IOException e) {
			e.printStackTrace();
		} catch (WrongAgeFormat e) {
			e.printStackTrace();
		} catch (IncompleteDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}