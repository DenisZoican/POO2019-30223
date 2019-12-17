import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class MainController {
	private MainFrame f;

	public MainController(MainFrame f) {
		this.f = f;
		f.setButtonConv(new ButtonConvListener());
		f.addFromCListener(new FromCListener());
		f.addToCListener(new ToCListener());
	}

	public class FromCListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String simbol_mon = f.getFromC().getSelectedItem().toString().substring(0,3);
			
			switch (simbol_mon) {
			case "RON":
				f.setFrom_d(1);
				break;
			case "EUR":
				f.setFrom_d(4.78);
				break;
			case "LEM":
				f.setFrom_d(0.25);
				break;
			case "USD":
				f.setFrom_d(4.28);
				break;
			case "DIN":
				f.setFrom_d(0.041);
				break;
			case "RUB":
				f.setFrom_d(0.069);
				break;
			case "BIT":
				f.setFrom_d(28653.66);
				break;
			default:
				f.setFrom_d(1);
				break;
			}
			
			DecimalFormat df = new DecimalFormat("#.#######");
			String value_in_lei = df.format(f.getFrom_d()/f.getTo_d());
			
			f.getSumaSimbol().setText(simbol_mon);
			f.getConvText().setText("1 "+simbol_mon+" = "+value_in_lei+" "+f.getConvText().getText().substring(f.getConvText().getText().length()-3));
		}
		
	}
	
	public class ToCListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String simbol_mon = f.getToC().getSelectedItem().toString().substring(0,3);
			
			switch (simbol_mon) {
			case "RON":
				f.setTo_d(1);
				break;
			case "EUR":
				f.setTo_d(4.78);
				break;
			case "LEM":
				f.setTo_d(0.25);
				break;
			case "DIN":
				f.setTo_d(0.041);
				break;
			case "USD":
				f.setTo_d(4.28);
				break;
			case "RUB":
				f.setTo_d(0.069);
				break;
			case "BIT":
				f.setTo_d(28653.66);
				break;
			default:
				f.setTo_d(1);
				break;
			}
			
			DecimalFormat df = new DecimalFormat("#.#######");
			String value_in_lei = df.format(f.getFrom_d()/f.getTo_d());
			
			f.getSumaSimbol().setText(simbol_mon);
			f.getConvText().setText(f.getConvText().getText().substring(0,8)+value_in_lei+" "+simbol_mon);
		}
		
	}
	
	public class ButtonConvListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
						
			double value_to_conv = 0;
			try {
				value_to_conv = Double.parseDouble(f.getSumaInput().getText());
				DecimalFormat df = new DecimalFormat("#.#######");
				String value_in_lei = df.format(value_to_conv*f.getFrom_d()/f.getTo_d());
				
				f.getRezInput().setText(value_in_lei);
			} catch(NumberFormatException exc){
				f.getRezInput().setText("Invalid format");
			}
			
		}

	}
}
