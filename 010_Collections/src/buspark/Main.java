package buspark;

public class Main {
	public static void main(String[] args) {
Park p=new Park(10);
System.out.println(p.getInQty());
System.out.println("in park-------------");
p.listIn();
System.out.println("on route------------");
p.listOut();
System.out.println("changes-------------");
p.BusOut();
System.out.println("in park-------------");
p.listIn();
System.out.println("on route------------");
p.listOut();
System.out.println();
System.out.println("changes-------------");
p.BusOut();
p.BusOut();
System.out.println("in park-------------");
p.listIn();
System.out.println("on route------------");
p.listOut();
System.out.println();
System.out.println("changes-------------");
p.BusIn();
System.out.println("in park-------------");
p.listIn();
System.out.println("on route------------");
p.listOut();
p.BusOut();
p.BusOut();
p.BusIn();
p.BusOut();
p.BusOut();

	}

}
