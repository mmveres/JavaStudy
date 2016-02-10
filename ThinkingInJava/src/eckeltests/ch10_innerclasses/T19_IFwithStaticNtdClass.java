package eckeltests.ch10_innerclasses;

interface Nestable19 {
	void nest19();

	class Nester19 {
		static void callNest19(Nestable19 n) {
			n.nest19();
		}
	}
}

public class T19_IFwithStaticNtdClass implements Nestable19 {

	@Override
	public void nest19() {
		System.out.println("IF_mtd_called!");

	}

	public static void main(String[] args) {
		T19_IFwithStaticNtdClass o1 = new T19_IFwithStaticNtdClass();
		Nester19.callNest19(o1);
	}
}
