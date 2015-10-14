package andy.test.inherit.demo2;

class Parent {
	private int count;

	public Parent(){
		count = 0;
	}
	public void increment() {
		setCount(getCount()+1);
	}

	public String toString() {
//		return Integer.toString(count);
		return Integer.toString(getCount());
	}
	
	protected int getCount(){
		return this.count;
	}
	
	protected void setCount(int count){
		this.count = count;
	}
}
