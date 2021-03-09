package cap.sprint.capsprinthbms.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cap.sprint.capsprinthbms.entities.Transactions;
import cap.sprint.capsprinthbms.services.TransactionsServicesImpl;

@RestController
public class TransactionsController 
{
	TransactionsServicesImpl  transactionsServicesImpl;
	
	@PostMapping("/transaction")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void addTransaction(@RequestBody Transactions transactions)
	{
		transactionsServicesImpl.addTransaction(transactions);
	}
}
