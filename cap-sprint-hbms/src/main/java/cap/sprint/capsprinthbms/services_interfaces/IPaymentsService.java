package cap.sprint.capsprinthbms.services_interfaces;

import java.util.Optional;

import cap.sprint.capsprinthbms.entities.Payments;

public interface IPaymentsService 
{
	public void addPayment(Payments p);
	
	public Optional<Payments> viewPayments(int paymentId);
	
	
}