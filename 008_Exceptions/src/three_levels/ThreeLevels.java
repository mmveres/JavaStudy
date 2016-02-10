package three_levels;

class FirstlevelException extends Exception {
}

class SecondLevelException extends FirstlevelException {
}

class ThirdLevelException extends SecondLevelException {
}

class A {
	void doException() throws FirstlevelException{
		throw new FirstlevelException();
	}
}

class B extends A{

	@Override
	void doException() throws SecondLevelException{
		throw new SecondLevelException();
	}
	
	
}

class C extends B{

	@Override
	void doException() throws ThirdLevelException{
		throw new ThirdLevelException();
	}
	
	
}

public class ThreeLevels {
	public static void main(String[] args) {
		C c=new C();
		A a =(A)c;
		try {
			a.doException();
		} catch (ThirdLevelException e) {
			System.out.println("It's third!");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FirstlevelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
