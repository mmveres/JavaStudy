package stock.main;

import java.util.ArrayList;
import java.util.List;

import stock.dao.ProductDAO;

public class Test {
public static void main(String[] args) {
ProductDAO pd = new ProductDAO();
List<Integer> productIds = new ArrayList<Integer>();
try {
	productIds = pd.getProductIds();
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
}
