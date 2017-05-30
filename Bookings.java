
public class Bookings {
	public String screeningDate;
	public int startTime;
	public Film filmToBeShown;
	
	Bookings(String airDate, int beginTime, Film filmToBook) {
		this.screeningDate = airDate;
		this.startTime = beginTime;
		this.filmToBeShown = filmToBook;
	}
}
