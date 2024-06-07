package parkingreservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import parkingreservation.model.Reservation;
import parkingreservation.model.User;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findByUser(User user);
}