package P2_surprise;
import java.util.Random;

public final class GatherSurprises {
	
	private GatherSurprises() {
	}
	
	public static IBag gather(int n) {
		Random random = new Random();
		int toyType;
		IBag getSurprises = new FIFO();
		
		for(int i = 0; i<n; i++) {
			toyType = random.nextInt(3);
			System.out.println(toyType + " toyType in for");
			switch (toyType) {
				case 0:
					getSurprises.put(new FortuneCookie());
					break;
				case 1:
					getSurprises.put(new Candies());
					break;
				case 2:
					getSurprises.put(new MinionToy());
					break;
				default:
					System.out.println("No good number!" + toyType);
					break;
			}
		}
		System.out.println("GatherSurprises number of surprises got: " + getSurprises.size());
//		System.out.println(getSurprises);
		return getSurprises;
	}
	
	public static ISurprise gather() {
		Random random = new Random();
		ISurprise getSurprise = null;
		int toyType = random.nextInt(2);
		switch (toyType) {
			case 0:
				getSurprise = new FortuneCookie();
				break;
			case 1:
				getSurprise = new Candies();
				break;
			case 2:
				getSurprise = new MinionToy();
				break;
		}
		return getSurprise;	
	}
	
}
