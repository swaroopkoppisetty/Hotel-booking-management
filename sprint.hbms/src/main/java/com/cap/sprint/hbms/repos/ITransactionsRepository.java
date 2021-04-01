package com.cap.sprint.hbms.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cap.sprint.hbms.entities.Payments;
import com.cap.sprint.hbms.entities.Transactions;

@Repository
public interface ITransactionsRepository extends JpaRepository<Transactions, Integer>
{
	public Transactions findByPayments(Payments payments);
}