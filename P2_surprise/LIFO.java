package P2_surprise;

import java.util.ArrayList;

public class LIFO implements IBag {
	private ArrayList<ISurprise> lifoArray;
	
	public LIFO() {
		this.lifoArray = new ArrayList<ISurprise>();
	}
	
	@Override
	public void put(ISurprise newSurprise) {
		// adds a surprise in the bag
		this.lifoArray.add(newSurprise);
	}

	@Override
	public void put(IBag bagOfSurprises) {
		// adds all the surprises from another IBag
		//   -> the 'bagOfSurprises' will be empty() afterwards
		for (int i = 0; i<bagOfSurprises.size(); i++) {
			this.lifoArray.add(bagOfSurprises.takeOut());
		}
	}

	@Override
	public ISurprise takeOut() {
		 // removes a surprise from the bag and returns it
		if (!this.lifoArray.isEmpty()) {
			return this.lifoArray.remove(this.lifoArray.size() - 1);
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		// Checks if the bag is empty or not
		if (this.lifoArray.size() == 0) {
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		// Returns the number of surprises
		return this.lifoArray.size();
	}
	
	@Override
	public String toString() {
		for(int i = 0; i<this.lifoArray.size(); i++) {
			System.out.println(this.lifoArray.get(i));
		}
		return "LIFO Array " + this.lifoArray.size();
	}

}
