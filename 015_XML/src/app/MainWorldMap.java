package app;

public class MainWorldMap {
	public static void main(String[] args) {
		Worldmap wm=new Worldmap();
		wm.loadFromFile("data.xml");
		wm.printAll();
		System.out.println("--------------------------------");
		wm.addCity(8, "Белгород", false, 800_000, 1);
		wm.addCountry(4, "Котэ");
		System.out.println(wm.countCountries());
		wm.deleteCountry(2);
		wm.getCityByCode(6);
		try {
			wm.getCityByCode(121);
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(wm.getCountryByCode(3));
		System.out.println(wm.getCountryByCode(121));
		System.out.println(wm.getCountryByIndex(0));
		System.out.println("--------------------------------");
		wm.printAll();
		wm.saveToFile("test.xml");
	}

}
