package andy.test.inherit.demo2;

public class Useit {
	public static void main(String[] args) {
		// useParent();
		useChild();
	}

	private static void useChild() {
		Child s = new Child();
		s.increment();
		s.increment();
		s.increment();
		int v = Integer.parseInt(s.toString());
		System.out.println(v);
	}

	private static void useParent() {
		Parent s = new Parent();
		s.increment();
		s.increment();
		s.increment();
		int v = Integer.parseInt(s.toString());
		System.out.println(v);
	}
}
