package cap.sprint.capsprinthbms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cap.sprint.capsprinthbms.entities.Payments;
import cap.sprint.capsprinthbms.repos.IPaymentsRepository;
import cap.sprint.capsprinthbms.services.PaymentsServicesImpl;

@RestController
public class PaymentsController 
{
	@Autowired
	PaymentsServicesImpl paymentsServicesImpl;
	
	@Autowired
	IPaymentsRepository p;
	
	@PostMapping("/payment")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void addPayments(@RequestBody Payments p)
	{
		paymentsServicesImpl.addPayment(p);
	}
	
	@GetMapping("/payment/{id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public Payments findPayment(@PathVariable int id)
	{
		return p.findById(id).get();
				
	}
}
