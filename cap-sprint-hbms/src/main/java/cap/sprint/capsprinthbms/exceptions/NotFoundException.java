package cap.sprint.capsprinthbms.exceptions;

public class NotFoundException extends RuntimeException {

	public NotFoundException(String msg) {
		super(msg);
		System.out.println(msg);
	}
}
