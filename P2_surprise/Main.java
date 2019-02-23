package P2_surprise;


public class Main {

	public static void main(String[] args) {
		// de refacut metodele duplicate
//		metoda surprise generate sa fie statica

		
//		ISurprise cookie = new FortuneCookie();
////		System.out.println(cookie);
//		
//		ISurprise candie = new Candies();
////		System.out.println(candie);
//		
//		ISurprise minion = new MinionToy();
////		System.out.println(minion);
		
		BagFactory newFactory = new BagFactory();
//		IBag randomList = newFactory.makeBag("RANDOM");
//		IBag lifoList = newFactory.makeBag("LIFO");
//		IBag fifoList = newFactory.makeBag("FIFO");
		
		//test if incorrect type of bag is written
		IBag fifoList2 = newFactory.makeBag("lifo");
		System.out.println(fifoList2);
		
//		test if GatherSurprises can be instantiate
//		GatherSurprises gatherSurprises = new GatherSurprises();
		
//		randomList.put(GatherSurprises.gather(4));
//		System.out.println("RANDOM list size: " + randomList.size());
//		
//		fifoList.put(GatherSurprises.gather(5));
//		System.out.println("FIFO list size: " + fifoList.size());
//		
//		lifoList.put(GatherSurprises.gather(7));
//		System.out.println("LIFO list size: " + lifoList.size());
		
		GiveSurpriseAndApplause applauseWithRandom = new GiveSurpriseAndApplause("RANDOM", 1);
		System.out.println("ApplauseWithRandom size: " + applauseWithRandom.tolba.size());
		GiveSurpriseAndApplause applauseWithLifo = new GiveSurpriseAndApplause("LIFO", 1);
		System.out.println("ApplauseWithLifo size: " + applauseWithLifo.tolba.size());
//		GiveSurpriseAndApplause applauseWithFifo = new GiveSurpriseAndApplause("FIFO", 1);
//		
		GiveSurpriseAndHug hugWithRandom = new GiveSurpriseAndHug("RANDOM", 1);
//		GiveSurpriseAndHug hugWithLifo= new GiveSurpriseAndHug("LIFO", 1);
//		GiveSurpriseAndHug hugWithFifo = new GiveSurpriseAndHug("FIFO", 1);
		
//		applauseWithRandom.tolba.put(lifoList);
		applauseWithRandom.put(GatherSurprises.gather(20));
		System.out.println("ApplauseWithRandom size after gathering surprises: " + applauseWithRandom.tolba.size());
//		System.out.println(applauseWithRandom.tolba);
		applauseWithRandom.giveAll();
		System.out.println("ApplauseWithRandom size: " + applauseWithRandom.tolba.size());
		
		applauseWithLifo.put(GatherSurprises.gather(6));
		System.out.println("ApplauseWithLifo size after gathering surprises: " + applauseWithLifo.tolba.size());
		applauseWithLifo.giveAll();
		System.out.println("ApplauseWithLifo size: " + applauseWithLifo.tolba.size());

		hugWithRandom.put(GatherSurprises.gather(6));
		System.out.println("HugWithRandom size after gathering surprises: " + hugWithRandom.tolba.size());
//		System.out.println(hugWithRandom.tolba);
		hugWithRandom.giveAll();
		System.out.println("HugWithRandom size: " + hugWithRandom.tolba.size());

		
//		cookie.enjoy();
//		candie.enjoy();
//		minion.enjoy();
//		

		
	}

}
