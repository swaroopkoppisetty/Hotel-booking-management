package cap.sprint.capsprinthbms.exceptions;

public class AlreadyExistsException extends RuntimeException {
	public AlreadyExistsException(String msg) {
		super(msg);
		System.out.println(msg);
	}
}