package P1;

import java.util.ArrayList;
import java.util.Scanner;
public class Main {
	static Scanner sc = new Scanner(System.in);
	static String  userCommand;
	
	/**
	 * kjhgjhgfuhgfyu
	 * kjkh
	 */
	
	public static void help() {
		System.out.println(
				"help         - Afiseaza aceasta lista de comenzi\r\n" + 
				"add          - Adauga o noua persoana (inscriere)\r\n" + 
				"check        - Verifica daca o persoana este inscrisa la eveniment\r\n" + 
				"remove       - Sterge o persoana existenta din lista\r\n" + 
				"update       - Actualizeaza detaliile unei persoane\r\n" + 
				"guests       - Lista de persoane care participa la eveniment\r\n" + 
				"waitlist     - Persoanele din lista de asteptare\r\n" + 
				"available    - Numarul de locuri libere\r\n" + 
				"guestsno    - Numarul de persoane care participa la eveniment\r\n" + 
				"waitlistno  - Numarul de persoane din lista de asteptare\r\n" + 
				"subscribeno - Numarul total de persoane inscrise\r\n" + 
				"search       - Cauta toti invitatii conform sirului de caractere introdus\r\n" + 
				"quit         - Inchide aplicatia");
	}
	
	/**
	 * ;ljb
	 */
	
	public static void command() {
		System.out.println("Introdu o comanda: (help):_");
		userCommand = sc.nextLine();
	}

	
	public static void main(String[] args) {
		Event devmindEvent = new Event(5);
		Guest invitat1 = new Guest("Banica", "Stefan", "stefan@banica.ro", 0744123456, 0);
		devmindEvent.guestsList.add(invitat1);
		invitat1.setOrderNo(devmindEvent.guestsList.size());
		devmindEvent.availablePlaces--;
		Guest invitat2 = new Guest("Radulescu", "Dem", "dem@radulesc.ro", 074456567, 0);
		devmindEvent.guestsList.add(invitat2);
		invitat2.setOrderNo(devmindEvent.guestsList.size());
		devmindEvent.availablePlaces--;
		Guest invitat3 = new Guest("Calinescu", "Puiu", "puiu@calinescu.ro", 0744147147, 0);
		devmindEvent.guestsList.add(invitat3);
		invitat3.setOrderNo(devmindEvent.guestsList.size());
		devmindEvent.availablePlaces--;
		Guest invitat4 = new Guest("Caragiu", "Toma", "toma@caragiu.ro", 074415, 0);
		devmindEvent.waitingList.add(invitat4);
		invitat4.setOrderNo(devmindEvent.waitingList.size());
		
		
		
		// TODO Auto-generated method stub
		
		command();
		
		while (!userCommand.equals("quit")) {
			switch (userCommand) {
				case "help" : {
					help();
					command();
					break;
				}
				case "add" : {
					devmindEvent.add();
					command();
					break;
				}
				case "check" : {
					devmindEvent.check();
					command();
					break;
				}
				case "remove" : {
					devmindEvent.removeGuest();
					command();
					break;
				}
				case "update" : {
					command();
					break;
				}
				case "guests" : {
					devmindEvent.printGuestList(devmindEvent);
					command();
					break;
				}
				case "waitlist" : {
					devmindEvent.printWaitingList(devmindEvent);
					command();
					break;
				}
				case "available" : {
					devmindEvent.getAvailablePlaces(devmindEvent);
					command();
					break;
				}
				case "guestno" : {
					devmindEvent.getGuestsNo(devmindEvent);
					command();
					break;
				}
				case "waitlistno" : {
					devmindEvent.getWaitingListNo(devmindEvent);
					command();
					break;
				}
				case "subscribeno" : {
					System.out.println("Numarul persoanelor inscrise la eveniment este: " + devmindEvent.subscribeno());
					command();
					break;
				}
				case "search" : {
//					search();
					command();
					break;
				}
				case "o" : 
					devmindEvent.printGuestList(devmindEvent);
					devmindEvent.printWaitingList(devmindEvent);
					command();
					break;
				default : {
					help();
					command();
					break;
				}
				
			}
		}
		System.out.println("Bye, Bye!");
	}

}
