package cap.sprint.capsprinthbms.exceptions;

public class NoRoomsListedException extends RuntimeException {

	public NoRoomsListedException(String msg) {
		super(msg);
		System.out.println(msg);
	}
}
