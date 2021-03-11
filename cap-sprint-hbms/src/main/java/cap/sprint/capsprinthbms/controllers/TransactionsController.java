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
import cap.sprint.capsprinthbms.entities.Transactions;
import cap.sprint.capsprinthbms.repos.ITransactionsRepository;
import cap.sprint.capsprinthbms.services.TransactionsServicesImpl;

@RestController
public class TransactionsController 
{
	@Autowired
	TransactionsServicesImpl  transactionsServicesImpl;
	
	@Autowired
	ITransactionsRepository transactionsRepository;
	
	@PostMapping("/transaction")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void addTransaction(@RequestBody Transactions transactions)
	{
		transactionsServicesImpl.addTransaction(transactions);
	}
	
	
	@GetMapping("/transaction/{id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public Transactions findTransaction(@PathVariable int id)
	{
		return transactionsRepository.findById(id).get();
				
	}
}
