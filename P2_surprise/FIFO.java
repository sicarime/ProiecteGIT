package P2_surprise;

import java.util.ArrayList;

public class FIFO implements IBag {
	private ArrayList<ISurprise> fifoArray;
	
	public FIFO() {
		this.fifoArray = new ArrayList<ISurprise>();
	}

	@Override
	public void put(ISurprise newSurprise) {
		// adds a surprise in the bag
		this.fifoArray.add(newSurprise);
	}

	@Override
	public void put(IBag bagOfSurprises) {
		// adds all the surprises from another IBag
		//   -> the 'bagOfSurprises' will be empty() afterwards
		for (int i = 0; i<bagOfSurprises.size(); i++) {
			this.fifoArray.add(bagOfSurprises.takeOut());
		}
	}

	@Override
	public ISurprise takeOut() {
		 // removes a surprise from the bag and returns it
		if (!this.fifoArray.isEmpty()) {
			return this.fifoArray.remove(0);
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		// Checks if the bag is empty or not
		if (this.fifoArray.size() == 0) {
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		// Returns the number of surprises
		return this.fifoArray.size();
	}
	
	@Override
	public String toString() {
		for(int i = 0; i<this.fifoArray.size(); i++) {
			System.out.println(this.fifoArray.get(i));
		}
		return "FIFO Array " + this.fifoArray.size();
	}
	

}
