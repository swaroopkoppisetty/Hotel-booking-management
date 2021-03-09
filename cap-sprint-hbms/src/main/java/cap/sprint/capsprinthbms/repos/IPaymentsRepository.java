package cap.sprint.capsprinthbms.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cap.sprint.capsprinthbms.entities.Payments;

@Repository
public interface IPaymentsRepository extends JpaRepository<Payments, Integer> 
{

}