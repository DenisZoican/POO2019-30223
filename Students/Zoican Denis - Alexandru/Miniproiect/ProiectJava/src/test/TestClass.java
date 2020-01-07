package test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JLabel;

import org.junit.jupiter.api.Test;

import connect4.models.MainModel;
import connect4.models.NodeMatrix;
import connect4.views.ConstantsGame;
import connect4.views.TokenImage;

/**
 * The class that tests the MainModel
 * 
 * @author Denis Zoican
 */
public class TestClass {

	@Test
	public void test() throws ClassNotFoundException, SQLException, ParseException {

		MainModel md = new MainModel();

		/// Check value
		md.getMatVal()[0][0].setValue(1);
		for (int i = 0; i < 6; i++)
			for (int j = 0; j < 7; j++)
				if (i != 0 || j != 0) {
					assertTrue(md.getMatVal()[i][j].getValue() == 0);
				}

		/// Check image
		md.getMatVal()[1][1].setToken(new TokenImage(ConstantsGame.ICON));
		String icon_string = ((JLabel) md.getMatVal()[1][1].getToken().getComponents()[0]).getIcon().toString();
		assertTrue(icon_string.compareTo("./Resources/icon.png") == 0);

		/// Check player
		md.getMatVal()[2][2].setPlayer(1);
		md.getMatVal()[2][2].setPlayer(2);
		assertTrue(md.getMatVal()[2][2].getPlayer() == 2);

		/// Set matrix

		NodeMatrix[][] a = new NodeMatrix[6][7];

		a[3][3] = new NodeMatrix();
		a[3][3].setToken(new TokenImage(ConstantsGame.ICON));
		a[3][3].setPlayer(0);
		a[3][3].setValue(1);

		md.setMatVal(a);

		for (int i = 0; i < 6; i++)
			for (int j = 0; j < 7; j++)
				if (3 != i || 3 != j) {
					assertTrue(md.getMatVal()[i][j] == null);
				} else {
					assertTrue(md.getMatVal()[i][j].getValue() == 1 && md.getMatVal()[i][j].getPlayer() == 0);
				}

	}
}
