package cap.sprint.capsprinthbms.exceptions;

public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(String msg) {
		super(msg);
		System.out.println(msg);
	}
}
