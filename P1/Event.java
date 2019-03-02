package P1;

import java.util.ArrayList;
import java.util.Scanner;
public class Event {
	public static int availablePlaces;
	public ArrayList<Guest> guestsList = new ArrayList<Guest>(availablePlaces);
	public ArrayList<Guest> waitingList = new ArrayList<Guest>();
	private int orderNo;
	
 	public Event(int availablePlaces) {
		this.availablePlaces = availablePlaces;
	}
		
	public int add() {
		Scanner sc = new Scanner(System.in); 
		String firstname, lastname, email, phoneNoString;
		int phoneNo;
		
		firstnameLabel:
		while (true) {
			System.out.println("Introdu numele: ");
			firstname = sc.nextLine();
			for (int i = 0; i<firstname.length(); i++) {
				if (!Character.isLetter(firstname.charAt(i))) {
					continue firstnameLabel;
				}
			}
			break firstnameLabel;
		}

		lastnameLabel:
		while (true) {
			System.out.println("Introdu prenumele: ");
			lastname = sc.nextLine();
			for (int i = 0; i<lastname.length(); i++) {
				if (!Character.isLetter(lastname.charAt(i))) {
					continue lastnameLabel;
				}
			}
			break lastnameLabel;
		}
		
		emailLabel:
		while (true) {
			System.out.println("Introdu email: ");
			email = sc.nextLine();
			for (int i = 0; i<email.length(); i++) {
				if (Character.compare(email.charAt(i), '@') == 0) {
					break emailLabel;	
				} 
			}
		}
		
		phoneNoLabel:
		while (true) {
			do {
				System.out.println("Numar telefon: ");
				phoneNoString = sc.nextLine();
			} while ((phoneNoString.length() < 10) || (phoneNoString.length() > 10));
			for (int i = 0; i<phoneNoString.length(); i++) {
				if (!(phoneNoString.charAt(0) == '0')) {
					continue phoneNoLabel;
				}
				if (!Character.isDigit(phoneNoString.charAt(i))) {
					continue phoneNoLabel;
				}
			}
			break phoneNoLabel;
		}
		phoneNo = Integer.parseInt(phoneNoString);
		
		if (availablePlaces > 0) {
			Guest invitat = new Guest(firstname, lastname, email, phoneNo, guestsList.size());
			guestsList.add(invitat);
			availablePlaces--;
			System.out.println("Felicitari! Locul tau la eveniment este confirmat. Te asteptam!");
			return 0;
		} else {
			Guest invitat = new Guest(firstname, lastname, email, phoneNo, waitingList.size());
			waitingList.add(invitat);
			System.out.println("Te-ai inscris cu succes in lista de asteptare si ai primit numarul de ordine <" 
					+ invitat.getOrderNo() + ">. Te vom notifica daca un loc devine disponibil.");
			return waitingList.size();
		}
	}
	
	public void check() {
		Scanner sc = new Scanner(System.in); 
		System.out.println("Introdu modalitatea de cautare: \n"
				+ "\t1. Dupa nume si prenume\n"
				+ "\t2. Dupa email\n"
				+ "\t3. Dupa numarul de telefon\n");
		int opt = sc.nextInt();
		sc.nextLine();
		if (guestsList.size() == 0) {
			System.out.println("Lista de invitati este goala.");
				return;
		}
		switch (opt) {
			case 1 : {
				System.out.println("Numele si prenumele: ");
				String name = sc.nextLine();
				String names[] = name.split(" ");
				String firstname = names[0];
				String lastname = names[1];
							
//				for (int i = 0; i<this.guestsList.size(); i++) {
					if ((cautaFirstname(this.guestsList, firstname) == true) && (cautaLastname(this.guestsList, lastname) == true)) {
//					if ((guestsList.get(i).checkFirstname(firstname) == true) && (guestsList.get(i).checkLastname(lastname) == true))	{
						System.out.println(name + " este inscris la eveniment pe lista de invitati "); 
//								+ guestsList.get(i).getOrderNo());
						return;
					} else {
//							for (int j = 0; j<this.waitingList.size(); j++) {
								if ((cautaFirstname(this.waitingList, firstname) == true) && (cautaLastname(this.waitingList, lastname) == true)) {
//								if ((waitingList.get(j).checkFirstname(firstname) == true) && (waitingList.get(j).checkLastname(lastname) == true)) {
									System.out.println(name + " este inscris la eveniment pe lista de asteptare.");
									return;
									} 
								else {
									System.out.println(name + " nu este inscris la eveniment.");
									}
//							}
					}
					break;
				}
				
			
			case 2: {
				System.out.println("Email: ");
				String email = sc.nextLine();
				for (int i = 0; i<this.guestsList.size(); i++) {
					if (guestsList.get(i).checkEmail(email) == true) {
						System.out.println("Persoana cu email-ul " + email + " este inscrisa la eveniment pe lista de invitati si are numarul de ordine " 
								+ guestsList.get(i).getOrderNo());
						return;
						} else {
							for (int j = 0; j<this.waitingList.size(); j++) {
								if (waitingList.get(j).checkEmail(email) == true) {
									System.out.println("Persoana cu email-ul " + email + " este inscrisa la eveniment pe lista de asteptare.");
									return;
									} 
								else {
									System.out.println("Persoana cu email-ul " + email + " nu este inscrisa la eveniment.");
									return;
									}
							}
					}
				} 
				break;
			}
			
			case 3: {
				System.out.println("Numarul de telefon:");
				String phoneNoString = sc.nextLine();
				int phoneNo = Integer.parseInt(phoneNoString);
				for (int i = 0; i<this.guestsList.size(); i++) {
					if (guestsList.get(i).checkPhoneNo(phoneNo)) {
						System.out.println("Persoana cu numarul de telefon " + phoneNo + " este inscrisa la eveniment pe lista de invitati si are numarul de ordine "
								+ guestsList.get(i).getOrderNo());
						return;
					}
					else {
						for (int j = 0; j<this.guestsList.size(); j++) {
							if (waitingList.get(j).checkPhoneNo(phoneNo)) {
								System.out.println("Persoana cu numarul de telefon " + phoneNo + " este inscrisa la eveniment pe lista de asteptare.");
								return;
							}
							else {
								System.out.println("Persoana cu numarul de telefon " + phoneNo + " nu este inscrisa la eveniment.");
								return;
							}
						}
					}
				}
				break;
			}
			default: {
				System.out.println("Comanda gresita!" );
				break;
			}
		}
	}
	
	public void removeGuest() {
		Scanner sc = new Scanner(System.in); 
		System.out.println("Introdu modalitatea de cautare: \n"
				+ "\t1. Dupa nume si prenume\n"
				+ "\t2. Dupa email\n"
				+ "\t3. Dupa numarul de telefon\n");
		int opt = sc.nextInt();
		sc.nextLine();
		if (guestsList.size() == 0) {
			System.out.println("Lista de invitati este goala.");
//				return false;
		}
		switch (opt) {
			case 1 : {
				System.out.println("Numele si prenumele: ");
				String name = sc.nextLine();
				String names[] = name.split(" ");
				String firstname = names[0];
				String lastname = names[1];
							
				for (int i = 0; i<this.guestsList.size(); i++) {
					if ((guestsList.get(i).checkFirstname(firstname) == true) && (guestsList.get(i).checkLastname(lastname) == true)) {
						System.out.println("Persoana cu numele " + name + " va fi stearsa de pe lista de invitati.");
						guestsList.remove(i);
						this.availablePlaces++;
						if (waitingList.size() > 0) {
							guestsList.add(waitingList.get(0));
							System.out.println("Persoana cu numele " + guestsList.get(guestsList.size()).getFirstname() + " " 
									+ guestsList.get(guestsList.size()).getLastname() + "a fost adaugata pe lista de invitati.");
							this.orderNo++;
							guestsList.get(guestsList.size()).setOrderNo(this.orderNo);
							this.availablePlaces--;
							waitingList.remove(0);
						}				

//						return true;
					} else {
							for (int j = 0; j<this.waitingList.size(); j++) {
//								if ((cautaFirstname(this.waitingList, firstname) == true) && (cautaLastname(this.waitingList, lastname) == true)) {
								if ((waitingList.get(j).checkFirstname(firstname) == true) && (waitingList.get(j).checkLastname(lastname) == true)) {
									System.out.println("Persoana cu numele " + name + " va fi stearsa de pe lista de asteptare.");
									waitingList.remove(i);
//									return true;
									} 
								else {
									System.out.println(name + " nu este inscris la eveniment.");
//									return false;
									}
							}
					}
					
				}
				break;
			}
				
			
			case 2: {
				System.out.println("Email: ");
				String email = sc.nextLine();
				for (int i = 0; i<this.guestsList.size(); i++) {
					if (guestsList.get(i).checkEmail(email) == true) {
						System.out.println("Persoana cu email-ul " + email + " va fi stearsa de pe lista de invitati."); 
						guestsList.remove(i);
//						return true;
						} else {
							for (int j = 0; j<this.waitingList.size(); j++) {
								if (waitingList.get(j).checkEmail(email) == true) {
									System.out.println("Persoana cu email-ul " + email + " va fi stearsa de pe lista de asteptare.");
									waitingList.remove(i);
									this.availablePlaces++;
//									return true;
									} 
								else {
									System.out.println("Persoana cu email-ul " + email + " nu este inscrisa la eveniment.");
//									return false;
									}
							}
					}
				}
				guestsList.add(waitingList.get(0));
				System.out.println("Persoana cu numele " + guestsList.get(guestsList.size()).getFirstname() + " " + guestsList.get(guestsList.size()).getLastname() + " a fost adaugata pe lista de invitati din lista de asteptare.");
				break;
			}
			
			case 3: {
				System.out.println("Numarul de telefon:");
				String phoneNoString = sc.nextLine();
				int phoneNo = Integer.parseInt(phoneNoString);
				for (int i = 0; i<this.guestsList.size(); i++) {
					if (guestsList.get(i).checkPhoneNo(phoneNo)) {
						System.out.println("Persoana cu numarul de telefon " + phoneNo + " va fi stearsa de pe lista de invitati.");
						guestsList.remove(i);
//						return true;
					}
					else {
						for (int j = 0; j<this.guestsList.size(); j++) {
							if (waitingList.get(j).checkPhoneNo(phoneNo)) {
								System.out.println("Persoana cu numarul de telefon " + phoneNo + " va fi stearsa de pe lista de asteptare.");
								waitingList.remove(i);
//								return true;
							}
							else {
								System.out.println("Persoana cu numarul de telefon " + phoneNo + " nu este inscrisa la eveniment.");
//								return false;
							}
						}
					}
				}
				guestsList.add(waitingList.get(0));
				System.out.println("Persoana cu numele " + guestsList.get(guestsList.size()).getFirstname() + " " + guestsList.get(guestsList.size()).getLastname() + " a fost adaugata pe lista de invitati din lista de asteptare.");
				break;
			}
			default: {
				System.out.println("Comanda gresita!" );
				break;
			}
		}
	}

	public void updateGuest() {
		Scanner sc = new Scanner(System.in); 
		System.out.println("Introdu modalitatea de cautare: \n"
				+ "\t1. Dupa nume si prenume\n"
				+ "\t2. Dupa email\n"
				+ "\t3. Dupa numarul de telefon\n");
		int opt = sc.nextInt();
		sc.nextLine();
		if (guestsList.size() == 0) {
			System.out.println("Lista de invitati este goala.");
//				return false;
		}
		switch (opt) {
			case 1 : {
				System.out.println("Numele si prenumele: ");
				String name = sc.nextLine();
				String names[] = name.split(" ");
				String firstname = names[0];
				String lastname = names[1];
							
				for (int i = 0; i<this.guestsList.size(); i++) {
					if ((guestsList.get(i).checkFirstname(firstname) == true) && (guestsList.get(i).checkLastname(lastname) == true)) {
						System.out.println("Datele pesrsoanei " + guestsList.get(i).getFirstname() + " " +guestsList.get(i).getLastname() + " vor fi modificate.");
						System.out.println("Numele si prenumele: ");
						String newName = sc.nextLine();
						String newNames[] = newName.split(" ");
						String newFirstname = newNames[0];
						String newLastname = newNames[1];
						guestsList.get(i).setFirstname(newFirstname);
						guestsList.get(i).setLastname(newLastname);

//						return true;
					} else {
							for (int j = 0; j<this.waitingList.size(); j++) {
//								if ((cautaFirstname(this.waitingList, firstname) == true) && (cautaLastname(this.waitingList, lastname) == true)) {
								if ((waitingList.get(j).checkFirstname(firstname) == true) && (waitingList.get(j).checkLastname(lastname) == true)) {
									System.out.println("Datele persoanei " + waitingList.get(j).getFirstname() + " " + waitingList.get(j).getLastname() + " vor fi modificate.");
									
									System.out.println("Numele si prenumele: ");
									String newName = sc.nextLine();
									String newNames[] = newName.split(" ");
									String newFirstname = newNames[0];
									String newLastname = newNames[1];
									waitingList.get(i).setFirstname(newFirstname);
									waitingList.get(i).setLastname(newLastname);
//									return true;
									} 
								else {
									System.out.println(name + " nu este inscris la eveniment.");
//									return false;
									}
							}
					}
					
				}
				guestsList.add(waitingList.get(0));
				System.out.println("Persoana cu numele " + guestsList.get(guestsList.size()).getFirstname() + " " + guestsList.get(guestsList.size()).getLastname() + " a fost adaugata pe lista de invitati din lista de asteptare.");
				break;
			}
				
			
			case 2: {
				System.out.println("Email: ");
				String email = sc.nextLine();
				for (int i = 0; i<this.guestsList.size(); i++) {
					if (guestsList.get(i).checkEmail(email) == true) {
						System.out.println("Persoanei cu email-ul " + guestsList.get(i).getEmail() + " i se va modifica email-ul"); 
						System.out.println("Noul email: ");
						String newEmail = sc.nextLine();
						guestsList.get(i).setEmail(newEmail);
//						return true;
						} else {
							for (int j = 0; j<this.waitingList.size(); j++) {
								if (waitingList.get(j).checkEmail(email) == true) {
									System.out.println("Persoanei cu email-ul " + waitingList.get(i).getEmail() + " i se va modifica email-ul"); 
									System.out.println("Noul email: ");
									String newEmail = sc.nextLine();
									waitingList.get(i).setEmail(newEmail);
									
//									return true;
									} 
								else {
									System.out.println("Persoana cu email-ul " + email + " nu este inscrisa la eveniment.");
//									return false;
									}
							}
					}
				}
				break;
			}
			
			case 3: {
				System.out.println("Numarul de telefon:");
				String phoneNoString = sc.nextLine();
				int phoneNo = Integer.parseInt(phoneNoString);
				for (int i = 0; i<this.guestsList.size(); i++) {
					if (guestsList.get(i).checkPhoneNo(phoneNo)) {
						System.out.println("Persoana cu numarul de telefon " + phoneNo + " va fi stearsa de pe lista de invitati.");
						guestsList.remove(i);
//						return true;
					}
					else {
						for (int j = 0; j<this.guestsList.size(); j++) {
							if (waitingList.get(j).checkPhoneNo(phoneNo)) {
								System.out.println("Persoana cu numarul de telefon " + phoneNo + " va fi stearsa de pe lista de asteptare.");
								waitingList.remove(i);
//								return true;
							}
							else {
								System.out.println("Persoana cu numarul de telefon " + phoneNo + " nu este inscrisa la eveniment.");
//								return false;
							}
						}
					}
				}
				guestsList.add(waitingList.get(0));
				System.out.println("Persoana cu numele " + guestsList.get(guestsList.size()).getFirstname() + " " + guestsList.get(guestsList.size()).getLastname() + " a fost adaugata pe lista de invitati din lista de asteptare.");
				break;
			}
			default: {
				System.out.println("Comanda gresita!" );
				break;
			}
		}
	}
	
	public void printGuestList(Event event) {
		System.out.println("Lista de invitati :" );
		for (int i = 0; i<guestsList.size(); i++) {
			System.out.println(guestsList.get(i));
		}
	}		
	
	public void printWaitingList(Event event) {
		System.out.println("Lista de asteptare :" );
		for (int i = 0; i<waitingList.size(); i++) {
			System.out.println(waitingList.get(i));
		}
		System.out.println("Lista de asteptare :" );
	}
	
	public void getAvailablePlaces(Event event) {
		System.out.println("Locuri disponibile: " + this.availablePlaces);
	}
	
	public void getGuestsNo(Event event) {
		System.out.println("Numarul de invitati care participa la eveniment: " + guestsList.size());
	}
	
	public void getWaitingListNo(Event event) {
		System.out.println("Numarul de invitati pe lista de asteptare: " + waitingList.size());
	}
	
	public int subscribeno() {
		return guestsList.size() + waitingList.size();
	}
	
	public void search() {
		
	}
	
	public boolean cautaFirstname(ArrayList<Guest> lista, String firstname) {
		for (int i = 0; i<lista.size(); i++) {
			if (lista.get(i).checkFirstname(firstname) == true)	{
				return true;
			}
		}
		return false;		
	}
	
	public boolean cautaLastname(ArrayList<Guest> lista, String lastname) {
		for (int i = 0; i<lista.size(); i++) {
			if (lista.get(i).checkLastname(lastname) == true)	{
				return true;
			}
		}
		return false;		
	}

}
