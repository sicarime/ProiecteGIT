package P2_surprise;

public class MinionToy implements ISurprise {
	private String[] minionToyList = {"Dave", "Carl", "Kevin", "Stuart", "Jerry", "Tim"};
	private int lastMinion = 0;
	
	public MinionToy() {
	}

	@Override
	public void enjoy() {
		if (this.lastMinion < this.minionToyList.length) {
		System.out.println(minionToyList[lastMinion]);
		this.lastMinion++;
		}
		if (this.lastMinion == this.minionToyList.length) {
			System.out.println(minionToyList[lastMinion]);
			this.lastMinion = 0;
		}
	}
	
	@Override
	public String toString() {
		for(String s: this.minionToyList) {
			System.out.println(s);
		}
		return "";
	}

}