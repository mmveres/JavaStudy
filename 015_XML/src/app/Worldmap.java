package app;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import entity.City;
import entity.Country;

public class Worldmap {

	// Массив стран
	private ArrayList<Country> countries;
	// Массив городов
	private ArrayList<City> cities;

	// Записать данные в файл XML
	public void saveToFile(String filename) { 
		DocumentBuilderFactory dbf = null;
		DocumentBuilder db = null;
		Document doc = null;
		dbf = DocumentBuilderFactory.newInstance();
		try {
			db = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Создаем "чистый" документ XML
		doc = db.newDocument();
		// Создаем корневой элемент
		Element root = doc.createElement("map");
		doc.appendChild(root);
		// Создаем объект "страна"
		for (Country country : countries) {
			Element tempCountry = doc.createElement("country");
			tempCountry.setAttribute("id", ""+country.getCode());
			tempCountry.setAttribute("name", country.getName());
			root.appendChild(tempCountry);
			for (City city : cities) {
				if(city.getCountry().equals(country)){
					Element tempCity = doc.createElement("city");
					tempCity.setAttribute("id", ""+city.getCityCode());
					tempCity.setAttribute("name", city.getName());
					tempCity.setAttribute("count", ""+city.getPopulationAmount());
					tempCity.setAttribute("iscap", (city.isCapital()?"1":"0"));
					tempCountry.appendChild(tempCity);
				}				
			}
		}

		
		Source domSource = new DOMSource(doc);
		Result fileResult = new StreamResult(new File(filename));
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer transformer;
		try {
			transformer = factory.newTransformer();
			transformer.setOutputProperty(OutputKeys.ENCODING,"UTF-8");
			transformer.transform(domSource, fileResult);
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	// Прочитать данные из файла XML
	public void loadFromFile(String filename) {

		DocumentBuilderFactory dbf = null;
		DocumentBuilder db = null;
		try {
			dbf = DocumentBuilderFactory.newInstance();
			db = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
		}
		Document doc = null;
		try {
			doc = db.parse(new File(filename));
		} catch (SAXException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		// Получаем корневой элемент
		Element root = doc.getDocumentElement();
		if (root.getTagName().equals("map")) {
			// Получаем коллекцию стран
			NodeList listCountries = root.getElementsByTagName("country");
			// Проходим по странам
			countries = new ArrayList<>();
			cities=new ArrayList<>();
			for (int i = 0; i < listCountries.getLength(); i++) {
				// Получаем текущую срану
				Element country = (Element) listCountries.item(i);
				String countryCode = country.getAttribute("id");
				String countryName = country.getAttribute("name");
				countries.add(new Country(Integer.parseInt(countryCode), countryName));
				// Получаем коллекцию городов для страны
				NodeList listCities = country.getElementsByTagName("city");
				// Проходим по городам
				for (int j = 0; j < listCities.getLength(); j++) {
					// Получаем текущий город
					
					Element city = (Element) listCities.item(j);
					String cityName = city.getAttribute("name");
					String cityCode= city.getAttribute("id");
					String population= city.getAttribute("count");
					String capital= city.getAttribute("iscap");
					boolean isCapital=(capital.equals("1")?true:false);
					City c = new City(Integer.parseInt(cityCode), cityName, isCapital, Integer.parseInt(population), countries.get(i));
					cities.add(c);

				}
			}
		}

	}
	
	
	public void printAll(){
		for (Country country : countries) {
			System.out.println(country);
			for (City city : cities) {
				if(city.getCountry().equals(country))System.out.println(city);
			}
		}
	}


	// Добавить новую страну
	public void addCountry(int code, String name) {
		countries.add(new Country(code, name));
	}

	// Получить страну c заданным кодом
	public Country getCountryByCode(int code) {
		for (Country country : countries) {
			if(country.getCode()==code) return country;
		}
		return null;
	}

	// Получить страну c заданным номером
	public Country getCountryByIndex(int index) {
		if(index>-1&&index<countries.size())return countries.get(index);

		return null;
	}

	// Получить количество стран
	public int countCountries() {
		// возвращаем количество стран
		return countries.size();
	}

	// Удалить страну
	public void deleteCountry(int code) {
		// Удаляем страну с заданным кодом, а также все города,
		// ссылающиеся на данну страну
		// Если страны с заданным кодом в массиве countries нет -
		// генерируем исключение
		Country country = getCountryByCode(code);
		if(country==null){
			throw new IllegalArgumentException("No country with code provided exists!");
		}else{
			Iterator<City> cityIter = cities.iterator();
			while(cityIter.hasNext()){
				if(cityIter.next().getCountry().equals(country)) cityIter.remove();
			}
			countries.remove(country);
		}
	}

	// Добавить новый город для заданной страны
	public void addCity(int code, String name, boolean isCapital, int count, int countryCode) {
		// если город с заданным кодом code уже есть
		// - генерируем исключение
		// если страны с заданным кодом countryCode нет
		// - генерируем исключение
		// в противном случае, добавляем новый город
		if(getCountryByCode(countryCode)==null)throw new IllegalArgumentException("No country with code " + countryCode +" exists!");
		if(getCityByCode(code)==null){
			cities.add(new City(code, name, isCapital, count, getCountryByCode(countryCode)));
		}else{
			throw new IllegalArgumentException("City with code " + code + " already exists!");
		}
	}
	
	//Найти город по коду
	public City getCityByCode(int code){
		for (City city : cities) {
			if(city.getCityCode()==code) return city;
		}
		return null;
	}

}
