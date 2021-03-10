package cap.sprint.capsprinthbms.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cap.sprint.capsprinthbms.entities.BookingDetails;
import cap.sprint.capsprinthbms.entities.Hotel;
import cap.sprint.capsprinthbms.entities.Payments;
import cap.sprint.capsprinthbms.entities.RoomDetails;
import cap.sprint.capsprinthbms.repos.IPaymentsRepository;
import cap.sprint.capsprinthbms.services_interfaces.IPaymentsService;

@Service
public class PaymentsServicesImpl implements IPaymentsService
{
	@Autowired
	IPaymentsRepository paymentRepository;
	
	
	
	@Autowired
	BookingDetailsServicesImpl bookingDetailsServicesImpl;
	
	@Transactional
	public void addPayment(Payments payment)
	{
		Optional <BookingDetails> bd= bookingDetailsServicesImpl.viewBookingDetails(payment.getBookingDetails().getBookingId());
		
		payment.setBookingDetails(bd.get());
		paymentRepository.save(payment);
			
	}
	
	public Optional<Payments> viewPayments(int paymentId)
	{
			Optional<Payments> payments = paymentRepository.findById(paymentId);
			return payments;
	}
	


}