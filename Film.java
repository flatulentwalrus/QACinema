
public class Film {
	public String title;
	public int durationMinutes;
	public int numberOfSeats;
	public int totalTicketsBooked = 0;

	Film(String name, int length, int seats) {
		this.title = name;
		this.durationMinutes = length;
		this.numberOfSeats = seats;
	}

}
