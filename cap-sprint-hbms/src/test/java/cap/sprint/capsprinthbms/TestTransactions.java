package cap.sprint.capsprinthbms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cap.sprint.capsprinthbms.entities.Transactions;
import cap.sprint.capsprinthbms.services.TransactionsServicesImpl;

@SpringBootTest
class TestTransactions {

	@Autowired
	TransactionsServicesImpl transactionServicesImpl;
	
	
	@Test
	public void testAddTransaction()
	{
	
		Transactions trasaction = new Transactions(5000.00);
		transactionServicesImpl.addTransaction(trasaction);
		
		
	}
}
