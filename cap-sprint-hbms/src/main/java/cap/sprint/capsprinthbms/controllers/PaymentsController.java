package cap.sprint.capsprinthbms.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cap.sprint.capsprinthbms.entities.Payments;
import cap.sprint.capsprinthbms.services.PaymentsServicesImpl;

@RestController
public class PaymentsController 
{
	PaymentsServicesImpl paymentsServicesImpl;
	
	@PostMapping("/payment")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void addPayments(@RequestBody Payments p)
	{
		paymentsServicesImpl.addPayment(p);
	}
	

}
