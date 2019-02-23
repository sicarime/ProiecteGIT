package P2_surprise;

import java.util.Random;
import java.util.ArrayList;


public class FortuneCookie implements ISurprise {
	private ArrayList<Zicale> listaZicale = new ArrayList<Zicale>();
	
	public FortuneCookie() {
		this.listaZicale.add(new Zicale("Nu descuraja niciodată pe cineva care progresează, indiferent cât de încet o face.", "Platon"));
		this.listaZicale.add(new Zicale("Egalitatea nu există decât în matematică!", "Mihai Eminescu"));
		this.listaZicale.add(new Zicale("Be water, my friend", "Bruce Lee"));
		this.listaZicale.add(new Zicale("To be or not to be. This is the question!", "William Shakespeare"));
		this.listaZicale.add(new Zicale("Orice soldat poartă în raniță bastonul de mareșal", "Napoleaon Bonaparte"));
		this.listaZicale.add(new Zicale("Nu întrerupe niciodată un dușman atunci când face o greșeală.", "Napoleaon Bonaparte"));
		this.listaZicale.add(new Zicale("La răscruce de viaţă nu există indicatoare.", "Charlie Chaplin"));
		this.listaZicale.add(new Zicale("Viaţa este darul lui Dumnezeu pentru noi. Modul în care o trăim este darul pe care noi îl facem lui Dumnezeu.", "Michelangelo Buonarotti"));
		this.listaZicale.add(new Zicale("Cu cât judeci mai mult, cu atât iubești mai puțin", "Honoré de Balzac"));
		this.listaZicale.add(new Zicale("Să creezi ca un zeu, să poruncești ca un rege, să muncești ca un rob!", "Constantin Brâncuși"));
		this.listaZicale.add(new Zicale("Oamenii se împart în două categorii: cei care caută sensul vieții fără să-l găsească și cei care l-au găsit fără să-l caute.", "Emil Cioran"));
		this.listaZicale.add(new Zicale("Dacă văd o nedreptate şi nu fac nimic s-o îndrept, sunt laş.", "Confucius"));
		this.listaZicale.add(new Zicale("A studia și a nu gândi e o risipă. A gândi și a nu studia e periculos.", "Confucius"));
		this.listaZicale.add(new Zicale("Coincidența este felul lui Dumnezeu de a rămâne anonim", "Albert Einstein"));
		this.listaZicale.add(new Zicale("Viața e duelul lui Dumnezeu cu diavolul, iar câmpul de bătălie sunt eu.", "Feodor Dostoievski"));
		this.listaZicale.add(new Zicale("Fiecare om pe care îl întâlnesc în drumul meu îmi e superior prin ceva. De aceea încerc să învăț câte ceva pe lângă fiecare.", "Sigmund Freud"));
		this.listaZicale.add(new Zicale("Există suficient în lume pentru nevoile omului, dar nu şi pentru lăcomia lui.", "Mahatma Gandhi"));
		this.listaZicale.add(new Zicale("Nu mi-e teamă de o armată de lei condusă de o oaie. Mi-e teamă de o armată de oi condusă de un leu.", "Alexandru Macedon"));
		this.listaZicale.add(new Zicale("Dacă vrei să fii fericit, fii!", "Lev Tolstoi"));
		this.listaZicale.add(new Zicale("Dacă ești deprimat, trăiești în trecut. Dacă ești nerăbdător, trăiești în viitor. Dacă ești împăcat, trăiești în prezent", "Lao Tse"));
	}
	
	public int generate(int n) {
	    Random random = new Random();
	    return random.nextInt(n);
	}
	
	public ISurprise generate2() {
		ISurprise surprise = new FortuneCookie();
		return surprise;
	}
	
	@Override
	public String toString() {
		for(int i=0; i<this.listaZicale.size(); i++) {
			System.out.println(this.listaZicale.get(i) + "\n");
		}
		return "";
	}

	@Override
	public void enjoy() {
		System.out.println(listaZicale.get(generate(this.listaZicale.size())));
	}
}
