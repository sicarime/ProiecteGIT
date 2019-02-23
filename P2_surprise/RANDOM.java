package P2_surprise;

import java.util.ArrayList;
import java.util.Random;

public class RANDOM implements IBag {
	private ArrayList<ISurprise> randomArray;
	
	public RANDOM() {
		this.randomArray = new ArrayList<ISurprise>();
	}

	@Override
	public void put(ISurprise newSurprise) {
		// adds a surprise in the bag
		this.randomArray.add(newSurprise);
	}

	@Override
	public void put(IBag bagOfSurprises) {
		// adds all the surprises from another IBag
		//   -> the 'bagOfSurprises' will be empty() afterwards
		for (int i = 0; i<bagOfSurprises.size(); i++) {
			this.randomArray.add(bagOfSurprises.takeOut());
		}
	}

	@Override
	public ISurprise takeOut() {
		// removes a surprise from the bag and returns it
		Random random = new Random();
		
		if (!this.randomArray.isEmpty()) {
			return this.randomArray.remove(random.nextInt(this.randomArray.size()));
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		// Checks if the bag is empty or not
		if (this.randomArray.size() == 0) {
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		// Returns the number of surprises
		return this.randomArray.size();
	}
	
	@Override
	public String toString() {
		for(int i = 0; i<this.randomArray.size(); i++) {
			System.out.println(this.randomArray.get(i));
		}
		return "RANDOM Array " + this.randomArray.size();
	}

}
