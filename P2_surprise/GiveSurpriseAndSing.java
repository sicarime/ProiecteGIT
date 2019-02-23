package P2_surprise;

public class GiveSurpriseAndSing extends AbstractGiveSurprises {
	public GiveSurpriseAndSing(String type, int waitTime) {
		super(type, waitTime);
	}

	@Override
	public void giveWithPassion() {
		System.out.println("Singing a nice song, full of joy and genuine excitement…");
	}

}
