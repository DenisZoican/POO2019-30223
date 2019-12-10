package zoowsome.views;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import zoowsome.models.animals.Animal;
import zoowsome.models.animals.Aquatic;
import zoowsome.models.animals.Aquatic.type;
import zoowsome.models.animals.Bird;
import zoowsome.models.animals.Insect;
import zoowsome.models.animals.Mammal;
import zoowsome.models.animals.Reptile;

public class AnimalPanel extends JPanel{
	
	public AnimalPanel(Animal c,int type) {
		JLabel name_label = new JLabel("Name: "+c.getName(),SwingConstants.CENTER);
		JLabel alive_label = new JLabel("Is been taken care of: "+c.isTakenCareOf());
		JLabel type_label = new JLabel("Type: "+c.getClass().getName().substring(24),SwingConstants.CENTER);
		JLabel maintenance_label = new JLabel("Maintenance cost: "+c.getMaintenanceCost(),SwingConstants.CENTER);
		JLabel legs_label = new JLabel("Number of legs: "+c.getNrOfLegs(),SwingConstants.CENTER);
		JLabel pred_label = new JLabel("Predisposition: "+c.getPredisposition(),SwingConstants.CENTER);
		JLabel danger_label = new JLabel("Danger: "+c.getDangerPerc(),SwingConstants.CENTER);
		
		EmptyBorder emp = new EmptyBorder(5,5,5,5);
		name_label.setBorder(emp);
		maintenance_label.setBorder(emp);
		danger_label.setBorder(emp);
		this.setLayout(new GridLayout(3,3));
		this.setBorder(new EmptyBorder(5,5,5,5));
		this.add(name_label);
		this.add(type_label);
		this.add(alive_label);
		this.add(maintenance_label);
		this.add(legs_label);
		this.add(pred_label);
		this.add(danger_label);
		switch(type) {
		case 1:
			JLabel depth_label = new JLabel("Swim depth: "+((Aquatic)c).getAvgSwimDepth(),SwingConstants.CENTER);
			JLabel water_label = new JLabel("Water type: "+((Aquatic)c).getWaterType());
			this.add(depth_label);
			this.add(water_label);
			break;
		case 2:
			JLabel temp_label = new JLabel("Body temperature: "+((Mammal)c).getNormalBodyTemp(),SwingConstants.CENTER);
			JLabel hair_label = new JLabel("Body hair: "+((Mammal)c).getPercBodyHair()+"%",SwingConstants.CENTER);
			this.add(temp_label);
			this.add(hair_label);
			break;
		case 3:
			JLabel eggs_label = new JLabel("Lay eggs: "+((Reptile)c).getLayEggs(),SwingConstants.CENTER);
			this.add(eggs_label);
			break;
		case 4:
			JLabel fly_label = new JLabel("Can fly: "+((Insect)c).getCanFly(),SwingConstants.CENTER);
			JLabel dang_label = new JLabel("Dangerous: "+((Insect)c).getIsDangerous(),SwingConstants.CENTER);
			this.add(fly_label);
			this.add(dang_label);
			break;
		case 5:
			JLabel	alt_label = new JLabel("Altitude: "+((Bird)c).getAvgFlightAltitude(),SwingConstants.CENTER);
			JLabel 	mig_label = new JLabel("Migrates: "+((Bird)c).getMigrates(),SwingConstants.CENTER);
			this.add(alt_label);
			this.add(mig_label);
			break;
		} 
	}
}
