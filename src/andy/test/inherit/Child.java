package andy.test.inherit;

public class Child extends Base {
//	private FeatureV2 record = new FeatureV2();

//	public Child() {
//		this.setRecord(new FeatureV2());
//	}
	public Child() {
//		this.setRecord(new FeatureV2());
	}
//	@Override
//	public void process() {
//		super.process();
//		if (super.getRecord() instanceof FeatureV2){
//			FeatureV2 f2 = (FeatureV2) super.getRecord();
//			f2.setGrade("A+ v2");
//		}
//	}
	
	@Override
	public void process() {
		System.out.println("process in child");
		super.process();
		FeatureV2 f2 = getRecord();
		f2.setGrade("A+ v2");
		setRecord(f2);
	}
	
//	@Override
//	public FeatureV1 getRecord() {
//		FeatureV1 f1 = super.getRecord();
//		f1.setName("kevin v1");
//		return f1;
//	}
	@Override
	public FeatureV2 getRecord() {
		System.out.println("get record in child");
		FeatureV1 f1 = super.getRecord();
		FeatureV2 record = new FeatureV2(f1);
		return record;
	}
	
	@Override
		public void setRecord(FeatureV1 record) {
			// TODO Auto-generated method stub
			super.setRecord(record);
		}
}
