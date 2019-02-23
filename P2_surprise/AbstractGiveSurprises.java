package P2_surprise;
//import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public abstract class AbstractGiveSurprises {
	IBag tolba;
	int waitTime;
	
	public AbstractGiveSurprises(String type, int waitTime) {
		BagFactory bagFactory = new BagFactory(); 
		this.tolba = bagFactory.makeBag(type);
		this.waitTime = waitTime;
	}
	
	public void put(ISurprise newSurprise) {
		this.tolba.put(newSurprise);
	}
	
	public void put(IBag bagOfSurprises) {
		this.tolba.put(bagOfSurprises);	
	}
	
	public void give() {
		if (!this.isEmpty()) {
			this.tolba.takeOut().enjoy();;
			giveWithPassion();
			System.out.println("---------------");
			if (this.tolba.isEmpty()) {
				System.out.println("The bag of surprises is empty now!");
			}
		}
		else {
			System.out.println("The bag of surprises is empty now!");
		}
	}

	public void giveAll() {
		if (!this.isEmpty()) {
			for(int i = 0; i<=this.tolba.size() + 1; i++) {
				this.tolba.takeOut().enjoy();
				giveWithPassion();
				System.out.println("---------------");
				if (this.tolba.isEmpty()) {
					System.out.println("The bag of surprises is empty now!");
				}
				try {
				  	TimeUnit.SECONDS.sleep(this.waitTime); // number of seconds to sleep
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}
		else {
			System.out.println("The bag of surprises is empty now!");
		}
	}
	
	public boolean isEmpty() {
		if (this.tolba.isEmpty()) {
			return true;
		}
		return false;
	}
	
	public abstract void giveWithPassion();
}
