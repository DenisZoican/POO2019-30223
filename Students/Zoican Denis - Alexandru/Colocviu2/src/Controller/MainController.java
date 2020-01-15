package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JLabel;


import Colocviu.Angajat;
import Model.MainModel;
import Views.MainView;

public class MainController {
	private MainModel m;
	private MainView v;

	public MainController(MainModel m, MainView v) {
		this.m = m;
		this.v = v;
		
		v.getBt().addActionListener(new ButtonListener());
	}

	public class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			v.getF().remove(v.getBtPanel());
			Arrays.sort(m.a);
			for (Angajat a : m.a) {
				v.getF().add(new JLabel(a.getNume()+" -- "+a.getBonus_salariu()));
			}
			v.getF().revalidate();
			v.getF().repaint();
		}

	}
}
