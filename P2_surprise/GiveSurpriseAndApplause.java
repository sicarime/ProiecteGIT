package P2_surprise;

public class GiveSurpriseAndApplause extends AbstractGiveSurprises{
	
	public GiveSurpriseAndApplause(String type, int waitTime) {
		super(type, waitTime);
	}

	@Override
	public void giveWithPassion() {
		System.out.println("Loud applause to you… For it is in giving that we receive.");
	}
}
