package connect4.models;


public class MainModel {
	private NodeMatrix matVal[][];
	
	public MainModel() {
		matVal = new NodeMatrix[6][7]; 
		for(int i=0;i<6;i++)
			for(int j=0;j<7;j++) {
				matVal[i][j] = new NodeMatrix();
			}
	}
	
	/**
	 * 
	 * @return NodeMatrix[][] The matrix with tokens
	 */
	public NodeMatrix[][] getMatVal(){
		return matVal;
	}
	
	public void setMatVal(NodeMatrix[][] a) {
		this.matVal = a;
	}

}
