package connect4.models;

import connect4.views.TokenImage;

public class NodeMatrix {
	private int value;
	private int player;
	private TokenImage token;
	private int pozi;
	private int pozj;

	public NodeMatrix(int pozi,int pozj) {
		this.token = new TokenImage("face.png");
		this.pozi = pozi;
		this.pozj = pozj;
		this.player = -1;
	}
	
	public NodeMatrix() {
		this.token = new TokenImage("face.png");
		this.player = -1;
	}
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public TokenImage getToken() {
		return token;
	}
	public void setToken(TokenImage token) {
		this.token = token;
	}

	public int getPlayer() {
		return player;
	}

	public void setPlayer(int player) {
		this.player = player;
	}
}
