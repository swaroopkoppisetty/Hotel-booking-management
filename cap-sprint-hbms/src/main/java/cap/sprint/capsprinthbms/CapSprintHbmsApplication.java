package cap.sprint.capsprinthbms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"cap.sprint.capsprinthbms.entities.Payments", "cap.sprint.capsprinthbms.entities.RoomDetails"})
public class CapSprintHbmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CapSprintHbmsApplication.class, args);
	}

}
