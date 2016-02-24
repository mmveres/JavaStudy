package app;

import entity.Worldmap;

public class MainWorldMap {
	public static void main(String[] args) {
		Worldmap wm=new Worldmap();
		wm.loadFromFile("data.xml");
		wm.saveToFile("test.xml");
	}

}
