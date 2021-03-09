package cap.sprint.capsprinthbms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cap.sprint.capsprinthbms.entities.Transactions;
import cap.sprint.capsprinthbms.repos.ITransactionsRepository;
import cap.sprint.capsprinthbms.services_interfaces.ITransactionsService;

@Service
public class TransactionsServicesImpl implements ITransactionsService
{
	@Autowired
	ITransactionsRepository transactionRepository;
	
	public void addTransaction(Transactions t)
	{
		
			transactionRepository.save(t);
		
	}
}