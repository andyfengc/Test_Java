package andy.test.inherit;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		Base base = new Base();
		base.process();
		Base base2 = new Child();
		base2.process();
		Base base3 = new Grandson();
		base3.process();

		Child child = new Child();
		child.process();
		Child child2 = new Grandson();
		child2.process();

		Grandson grandson = new Grandson();
		grandson.process();
		System.out.println();
		
	}
}
