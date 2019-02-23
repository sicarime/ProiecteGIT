package P2_surprise;

public class GiveSurpriseAndHug extends AbstractGiveSurprises {
	
	public GiveSurpriseAndHug(String type, int waitTime) {
		super(type, waitTime);
	}

	@Override
	public void giveWithPassion() {
		System.out.println("Warm wishes and a big hug!");
	}
}
