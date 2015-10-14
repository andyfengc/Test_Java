package andy.test.inherit.demo2;

public class Child extends Parent {
	private int newCount = 1000;

	public Child() {
//		super.setCount(getNewCount());
	}

	@Override
	public void increment() {
		super.increment();
		this.setCount(getCount()+10); 
//		super.setCount(super.getCount() + 10);
		// count++;
		// count +=10;
	}

	protected int getNewCount() {
		return this.newCount* 1 / 1;// extract from new source
	}

	@Override
	protected int getCount() {
		return this.newCount * 1 /1;
	}
	
	@Override
	protected void setCount(int count) {
		this.newCount = count * 1 / 1;
	}
}
