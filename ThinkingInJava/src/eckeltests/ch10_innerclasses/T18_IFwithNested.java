package eckeltests.ch10_innerclasses;

interface Nestable {
	void nest();

	class Nester {
		public Nester() {
			System.out.println("Nester init!");
		}
	}

}

class T18_IFwithNested implements Nestable {

	@Override
	public void nest() {
		System.out.println("IF_init!");

	}

	public static void main(String[] args) {
		T18_IFwithNested o = new T18_IFwithNested();
		o.nest();
		Nester n = new Nester();
	}

}
