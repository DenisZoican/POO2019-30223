import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.AbstractAction;


public class keyAdapter extends AbstractAction{
	
	timerFace face;
	char cr;
	keyAdapter(timerFace e,char c){
		face = e;
		cr = c;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(cr == 'r')
		{
			face.change_face(0);
		} else if(cr == 'l')
		{
			face.change_face(1);
		} else if(cr == 's')
		{
			try {
				face.drop_token();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
