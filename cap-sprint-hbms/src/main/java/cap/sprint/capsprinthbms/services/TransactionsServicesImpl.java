package cap.sprint.capsprinthbms.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cap.sprint.capsprinthbms.entities.BookingDetails;
import cap.sprint.capsprinthbms.entities.Payments;
import cap.sprint.capsprinthbms.entities.Transactions;
import cap.sprint.capsprinthbms.repos.ITransactionsRepository;
import cap.sprint.capsprinthbms.services_interfaces.ITransactionsService;

@Service
public class TransactionsServicesImpl implements ITransactionsService
{
	@Autowired
	ITransactionsRepository transactionRepository;
	
	@Autowired
	PaymentsServicesImpl  PaymentsServicesImpl;
	
	
	@Transactional
	public void addTransaction(Transactions transactions)
	{
		Optional<Payments> payments = PaymentsServicesImpl.viewPayments(transactions.getPayments().getPaymentId());
		transactions.setPayments(payments.get());
		transactionRepository.save(transactions);
		
	}
	

	
}