package Colocviu;

import java.util.Arrays;
import java.util.Date;

import javax.swing.JFrame;

import Controller.MainController;
import Model.MainModel;
import Views.MainView;

public class MainGUI {

	public static void main(String[] args) {
		
		
		MainModel m = new MainModel();
		MainView v = new MainView();
		MainController c = new MainController(m,v);
	}

}
