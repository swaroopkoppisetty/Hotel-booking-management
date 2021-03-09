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
	RoomDetailsServicesImpl roomDetailsServicesImpl;
	
	@Autowired
	HotelServicesImpl hotelServicesImpl;
	
	@Autowired
	BookingDetailsServicesImpl bookingDetailsServicesImpl;
	
	@Transactional
	public void addPayment(Payments p)
	{
		Optional <BookingDetails> bd= bookingDetailsServicesImpl.viewBookingDetails(p.getBookingDetails().getBookingId());
		
		p.setBookingDetails(bd.get());
		paymentRepository.save(p);
			
	}
	


}