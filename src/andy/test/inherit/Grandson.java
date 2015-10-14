package andy.test.inherit;

public class Grandson extends Child {

	public Grandson() {
		this.setRecord(new FeatureV3());
	}

	@Override
	public void process() {
		super.process();
		if (super.getRecord() instanceof FeatureV3){
			FeatureV3 f3 = (FeatureV3) getRecord();
			f3.setFirstLanguage("mandarin v3");
		}
	}
	
	@Override
	public FeatureV2 getRecord() {
		// TODO Auto-generated method stub
		return super.getRecord();
	}
	
	@Override
	public void setRecord(FeatureV1 record) {
		// TODO Auto-generated method stub
		super.setRecord(record);
	}

}
