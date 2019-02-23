package P2_surprise;

public class BagFactory implements IBagFactory {
//	private String type;
	
	public BagFactory() {
//		ISurprise cookie = new FortuneCookie();
////		System.out.println(cookie);
//		
//		ISurprise candie = new Candies();
////		System.out.println(candie);
//		
//		ISurprise minion = new MinionToy();
////		System.out.println(minion);
	}

	@Override
	public IBag makeBag(String type) {
		IBag newBag;
		switch (type) {
			case "RANDOM":
				newBag =  new RANDOM();
				System.out.println("New RANDOM bag created");
				break;
			case "LIFO":
				newBag =  new LIFO();
				System.out.println("New LIFO bag created");
				break;
			case "FIFO":
				newBag = new FIFO();
				System.out.println("New FIFO bag created");
				break;
			default:
				System.out.println("Incorrect type of bag! No new bag created");
				return null;
		}
		return newBag;
	}

}
