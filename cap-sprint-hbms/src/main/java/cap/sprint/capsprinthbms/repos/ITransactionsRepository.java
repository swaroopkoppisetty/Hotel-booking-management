package cap.sprint.capsprinthbms.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cap.sprint.capsprinthbms.entities.Transactions;

@Repository
public interface ITransactionsRepository extends JpaRepository<Transactions, Integer>
{

}