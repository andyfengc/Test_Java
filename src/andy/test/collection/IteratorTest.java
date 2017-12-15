package andy.test.collection;

import java.io.Console;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class IteratorTest {
	public static void main(String[] args) {
		MyList list = new MyList();
		Student s1 = new Student("John", 55);
		Student s2 = new Student("Kevin", 70);
		Student s3 = new Student("Andy", 77);
		Student s4 = new Student("Anne", 65);
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);

//		for (Student s : list) {
//			System.out.println(s);
//		}

//		Iterator<Student> it = list.iterator();
//		while (it.hasNext()) {
//			Student item = it.next();
//			if (item.name == "Kevin") {
//				it.remove();
//			}
//			System.out.println(item);
//		}
		
		
		List<Student> students = new ArrayList<Student>();
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
//		for(Student s : students) {			
//			System.out.println(s);
//			students.remove(s); // fail
//		}
//		Iterator<Student> it = students.iterator();
//		while(it.hasNext()) {
//			Student item = it.next();			
//			if (item.name == "Kevin") {
//				students.remove(item); // faile
//			}
//			//System.out.println(item);
//		}
		for(int i = 0; i < students.size(); i++) {
			Student item = students.get(i);
			System.out.println(item);
			if (item.name == "Kevin") {
				students.remove(item);
				
			}
		}
	}

}

class MyList implements Iterable<Student> {
	private MyNode cursor;
	private MyNode first;
	private MyNode last;

	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public boolean contains(Object o) {
		throw new UnsupportedOperationException("contains");
	}

	public Iterator<Student> iterator() {
		return new MyIterator();
	}

	public Object[] toArray() {
		throw new UnsupportedOperationException("toArray");
	}

	public <T> T[] toArray(T[] a) {
		throw new UnsupportedOperationException("toArray");
	}

	public boolean add(Student e) {
		if (isEmpty()) {
			first = last = new MyNode(e);
		} else {
			MyNode me = new MyNode(e);
			last.addNext(me);
			last = me;
		}
		return true;
	}

	public boolean remove(Object o) {
		throw new UnsupportedOperationException("remove");
	}
	
	class MyIterator implements Iterator<Student>{
		private MyNode cursorOfNextNode = first;

		@Override
		public boolean hasNext() {
//			return cursorOfNextNode != last.next();
			return cursorOfNextNode != null;	
		}

		@Override
		public Student next() {
			Student data = cursorOfNextNode.getData();
			cursorOfNextNode = cursorOfNextNode.next();
			return data;
		}
		
	}


}

class MyNode {
	private Student data;
	private MyNode next;

	public MyNode(Student data) {
		this.data = data;
	}

	public MyNode next() {
		return this.next;
	}

	public Student getData() {
		return this.data;
	}

	public void addNext(MyNode e) {
		this.next = e;
	}
}

class Student {
	public Student(String name, double score) {
		super();
		this.name = name;
		this.score = score;
	}

	public String name;
	public double score;

	@Override
	public String toString() {
		return this.name + " " + this.score;
	}
}