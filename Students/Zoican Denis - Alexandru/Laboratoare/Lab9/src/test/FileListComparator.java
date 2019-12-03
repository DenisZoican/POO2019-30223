package test;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.io.*;

public class FileListComparator {
	public static HashMap<String,Long> h = new HashMap<String,Long>();
	
	public static void main(String[] args) {
		Comparator<File> byDirThenAlpha = new DirAlphaComparator();
		Comparator<File> byNameLength = new NameLengthComparator();
		Comparator<File> bySize = new SizeComparator();

		File dir = new File("D:\\");
		File[] children = dir.listFiles();
		
		System.out.println("Fisierele dupa director, apoi alfabetic ");
		Arrays.sort(children, byDirThenAlpha);
		printFileNames(children);

		System.out.println("Fisierele dupa lungimea numelui lor (cel mai lung primul)");
		Arrays.sort(children, byNameLength);
		printFileNames(children);

		///////Am adaugat mod nou de sortat
		System.out.println("Fisierele dupa dimensiune (cel mai mic primul)");
		long ok = 0;
		for(File f:children) {
			ok++;
			System.out.println(ok+"/"+children.length);
			h.put(f.getName(), folderSize(f));
		}
		
		Arrays.sort(children, bySize);
		printFileNames(children);
	}

	private static long folderSize(File directory) {
		if (directory.listFiles() != null) {
			long length = 0;
			for (File file : directory.listFiles()) {
				if (file.isFile())
					length += file.length();
				else
					length += folderSize(file);
			}
			return length;
		}
		return 0;
	}
	
	private static void printFileNames(File[] fa) {
		for (File oneEntry : fa) {
			System.out.println(" " + oneEntry.getName());
		}
	}
}


///Un nou comparator in functie de dimensiune

class SizeComparator implements Comparator<File> {

	@Override
	public int compare(File file1, File file2) {
		long length1 = FileListComparator.h.get(file1.getName());
		long length2 = FileListComparator.h.get(file2.getName());;

		System.out.println("23");
		return (int) (length1 - length2);
	}

}

class DirAlphaComparator implements Comparator<File> {
	public int compare(File filea, File fileb) {
		if (filea.isDirectory() && !fileb.isDirectory()) {
			return -1;
		} else if (!filea.isDirectory() && fileb.isDirectory()) {
			return 1;
		} else {
			return filea.getName().compareToIgnoreCase(fileb.getName());
		}
	}
}

class NameLengthComparator implements Comparator<File> {
	public int compare(File filea, File fileb) {
		int comp = fileb.getName().length() - filea.getName().length();
		if (comp != 0) {
			return comp;
		} else {
			return filea.getName().compareToIgnoreCase(fileb.getName());
		}
	}
}