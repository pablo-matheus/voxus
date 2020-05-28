package tv.voxus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tv.voxus.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
