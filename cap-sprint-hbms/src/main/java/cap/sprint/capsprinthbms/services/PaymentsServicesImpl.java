package cap.sprint.capsprinthbms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cap.sprint.capsprinthbms.entities.Payments;
import cap.sprint.capsprinthbms.repos.IPaymentsRepository;
import cap.sprint.capsprinthbms.services_interfaces.IPaymentsService;

@Service
public class PaymentsServicesImpl implements IPaymentsService
{
	@Autowired
	IPaymentsRepository paymentRepository;
	
	public void addPayment(Payments p)
	{
		
			paymentRepository.save(p);
		
	}

}