package cap.sprint.capsprinthbms.exceptions;



public class BookingDetailsNotFoundException extends RuntimeException
{

	public BookingDetailsNotFoundException(String msg)
	{
		super(msg);
		System.out.println(msg);
	}
}
