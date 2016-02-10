package eckeltests.ch10_innerclasses;

interface U {
	void t21_first();

	void t21_second();

	void t21_third();

}

class A {
	U getU() {
		return new U() {

			@Override
			public void t21_third() {
				System.out.println("t21_3 in A " + hashCode());

			}

			@Override
			public void t21_second() {
				System.out.println("t21_2 in A " + hashCode());

			}

			@Override
			public void t21_first() {
				System.out.println("t21_1 in A " + hashCode());

			}
		};
	}

}

class B {
	public static final int CAPACITY = 10;
	private int pos = 0;
	U[] u_objects = new U[CAPACITY];

	void setUNull(int i) {
		if (i >= 0 || i < CAPACITY) {
			u_objects[i] = null;
		}
	}

	void addU(U u) {
		if (pos < CAPACITY) {
			u_objects[pos++] = u;
		}

	}

	void callAllU() {
		for (int i = 0; i < CAPACITY; i++) {
			if(u_objects[i]==null){
				System.out.println("NULL at " + i);
			}else{
				System.out.println("Object at " +i);
			u_objects[i].t21_first();
			u_objects[i].t21_second();
			u_objects[i].t21_third();}
		}
	}
}

public class T21_IF3Methods {
	public static void main(String[] args) {
		B b=new B();
		for (int i = 0; i < B.CAPACITY-1; i++) {
			b.addU(new A().getU());
			
		}
		b.callAllU();
		b.setUNull(3);
		b.setUNull(5);
		b.setUNull(7);
		b.callAllU();
	}
}
