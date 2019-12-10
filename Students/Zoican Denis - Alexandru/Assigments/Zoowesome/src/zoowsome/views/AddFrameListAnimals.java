package zoowsome.views;

import java.util.ArrayList;

import zoowsome.models.animals.Animal;
import zoowsome.models.animals.Aquatic;
import zoowsome.models.animals.Bird;
import zoowsome.models.animals.Insect;
import zoowsome.models.animals.Mammal;
import zoowsome.models.animals.Reptile;

public class AddFrameListAnimals extends ZooFrame {

	public AddFrameListAnimals(String title, ArrayList<Animal> an_gui) {
		super(title);
		for (Animal c : an_gui) {
			if (c instanceof Aquatic)
				contentPanel.add(new AnimalPanel(c, 1));
			else if (c instanceof Mammal)
				contentPanel.add(new AnimalPanel(c, 2));
			else if (c instanceof Reptile)
				contentPanel.add(new AnimalPanel(c, 3));
			else if (c instanceof Insect)
				contentPanel.add(new AnimalPanel(c, 4));
			else if (c instanceof Bird)
				contentPanel.add(new AnimalPanel(c, 5));
		}
	}

	@Override
	public void goBack() {
		// TODO Auto-generated method stub

	}

}