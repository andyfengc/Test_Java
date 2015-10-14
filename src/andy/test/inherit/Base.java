package andy.test.inherit;

public class Base {

	private FeatureV1 record;

	public Base() {
		this.record = new FeatureV1();
		FeatureV1 f1 = getRecord();
		f1.setGender("male v1");
		setRecord(f1);
	}

	public void process() {
		System.out.println("process in parent");
		FeatureV1 f1 = getRecord();
		f1.setName("andy base v1");
		setRecord(f1);
	}

	public FeatureV1 getRecord() {
		System.out.println("get record in parent");
		return record;
	}

	public void setRecord(FeatureV1 record) {
		this.record = record;
	}
}
