package cap.sprint.capsprinthbms.exceptions;

public class RoomDetailsNotFoundException extends RuntimeException {

	public RoomDetailsNotFoundException(String msg) {
		super(msg);
		System.out.println(msg);
	}
}
