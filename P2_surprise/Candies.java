package P2_surprise;
import java.util.Random;
public class Candies implements ISurprise {
	private String[] candiesList = {"cupcake", "donut", "eclair", "froyo", "ginger bread", "honeycomb", "ice cream", "jelly bean", "kitkat", "lollypop", "marshmallow", "nougat", "oreo", "pie"};

	public Candies() {
	}
	
	public int generate(int n) {
	    Random random = new Random();
	    return random.nextInt(n);
	}
	
	public String toString() {
		for(String s: this.candiesList) {
			System.out.println(s);
		}
		return "";
	}
	
	@Override
	public void enjoy() {
		int randomCandie = this.generate(this.candiesList.length);
		Random randomN = new Random();
		for (int i = 0; i<=randomN.nextInt(10); i++) {
			System.out.println(this.candiesList[randomCandie]);
		}
	}
}