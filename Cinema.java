import java.util.Scanner;
public class Cinema {
	public static void main(String[] args) {
		BookTickets();
	}
	public static void BookTickets(){
		Film backToTheFuture = new Film("Back to the Future", 116, 50);
		Bookings screeningBTTF1 = new Bookings("31/05/2017", 1300, backToTheFuture);
		Bookings screeningBTTF2 = new Bookings("01/06/2017", 1700, backToTheFuture);
		Film jurassicPark = new Film("Jurassic Park", 127, 100);
		Bookings screeningJP = new Bookings("31/05/2017", 1400, jurassicPark);
		Bookings filmToBook = GetfilmToBook(screeningBTTF1, screeningBTTF2, screeningJP);
		BookTickets(filmToBook);
	}
	public static Bookings GetfilmToBook(Bookings film1, Bookings film2, Bookings film3){
		System.out.println("Hello and welcome to QA Cinema!");
		System.out.println("We are currently showing:"); 
		System.out.println("1: " + film1.filmToBeShown.title + " on the " + film1.screeningDate + " starting at " + film1.startTime + ".");
		System.out.println("2: " + film2.filmToBeShown.title + " on the " + film2.screeningDate + " starting at " + film2.startTime + ".");
		System.out.println("3: " + film3.filmToBeShown.title + " on the " + film3.screeningDate + " starting at " + film3.startTime + ".");
		boolean filmSelected = false;
		while(filmSelected == false){
			System.out.println("Please pick the number of the film you wish to book for:");
			Scanner s = new Scanner(System.in);
			int userInput = s.nextInt();
			switch(userInput){
			case 1:
				return film1;
			case 2:
				return film2;
			case 3:
				return film3;
			default:
				System.out.println("You have not picked a film we are showing, please try again.");
				break;
			}
		}
		return film1;
	}

	public static void BookTickets(Bookings filmToBook) {
		System.out.println("You have selected the film " + filmToBook.filmToBeShown.title + ".");
		System.out.println("This film has "
				+ (filmToBook.filmToBeShown.numberOfSeats - filmToBook.filmToBeShown.totalTicketsBooked)
				+ " number of seats left.");
		int totalCost = 0;
		boolean finishedBooking = false;
		TicketType ticketPrices = new TicketType();
		while (finishedBooking == false) {
			if (filmToBook.filmToBeShown.numberOfSeats != filmToBook.filmToBeShown.totalTicketsBooked) {
				System.out.println("What type of ticket would you like to book?");
				System.out.println("Standard: £" + ticketPrices.standard);
				System.out.println("OAP: £" + ticketPrices.oldAgePensioner);
				System.out.println("Student: £" + ticketPrices.student);
				System.out.println("Child: £" + ticketPrices.child);
				Scanner s = new Scanner(System.in);
				String userInput = s.nextLine();
				switch (userInput) {
				case "Standard":
					totalCost += ticketPrices.standard;
					filmToBook.filmToBeShown.totalTicketsBooked++;
					System.out.println("Your total comes to: £" + totalCost);
					System.out.println("Would you like to book another ticket, Yes or No?");
					userInput = s.nextLine();
					if(userInput == "No") finishedBooking = true;
					break;
				case "OAP":
					totalCost += ticketPrices.oldAgePensioner; 
					filmToBook.filmToBeShown.totalTicketsBooked++;
					System.out.println("Your total comes to: £" + totalCost);
					System.out.println("Would you like to book another ticket, Yes or No?");
					userInput = s.nextLine();
					if(userInput == "No") finishedBooking = true;
					break;
				case "Student":
					totalCost += ticketPrices.student;
					filmToBook.filmToBeShown.totalTicketsBooked++;
					System.out.println("Your total comes to: £" + totalCost);
					System.out.println("Would you like to book another ticket, Yes or No?");
					userInput = s.nextLine();
					if(userInput == "No") finishedBooking = true;
					break;
				case "Child":
					totalCost += ticketPrices.child;
					filmToBook.filmToBeShown.totalTicketsBooked++;
					System.out.println("Your total comes to: £" + totalCost);
					System.out.println("Would you like to book another ticket, Yes or No?");
					userInput = s.nextLine();
					if(userInput == "No") finishedBooking = true;
					break;
				default:
					System.out.println("You have not picked a available ticket type, please try again.");
					break;
				}
			} else{
				System.out.println("You have booked the last available ticket, thank you!");
			}
		}
	}
}
