
public class NameInverter {

	public String revert (String a)
	{
		if(a==null || a=="")
			return a;
		a.replaceAll(" ","");
		String[] tok = a.split("\\s+");
		
		if(tok.length==1)
		{
			return tok[0];
		} else if(tok.length==2){
			return tok[1]+", "+tok[0];	
		} else if(tok.length==3){
			if(tok[0].compareTo("Mr.")!=0 && tok[0].compareTo("Mrs.")!=0)
				return "Invalid Format";
			return tok[2]+", "+tok[1]+' '+tok[0];	
		} else {
			if((tok[0].compareTo("Mr.")!=0 && tok[0].compareTo("Mrs.")!=0) || tok[1].compareTo("Phd.")!=0)
				return "Invalid Format";
			return tok[3]+", "+tok[2]+' '+tok[0]+' '+tok[1];
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		NameInverter name = new NameInverter();
		
		System.out.println(name.revert("Fist asda      "));
	}

}
