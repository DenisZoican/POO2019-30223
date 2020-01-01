package connect4.controllers;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.sql.SQLException;

import javax.swing.*;

import connect4.models.MainModel;
import connect4.views.MainFrame;

public class MainApp extends JPanel {
	 public static void main(String[] args) throws SQLException, ClassNotFoundException {
		 MainFrame view = new MainFrame();
		 MainModel model = new MainModel();
		 MainController controller = new MainController(view,model);
		 controller.main();
	 }
}
