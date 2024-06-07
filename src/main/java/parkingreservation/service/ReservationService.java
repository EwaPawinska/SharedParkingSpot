package parkingreservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import parkingreservation.model.Reservation;
import parkingreservation.model.User;
import parkingreservation.repository.ReservationRepository;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> findReservationsByUser(User user) {
        return reservationRepository.findByUser(user);
    }

    public void save(Reservation reservation) {
        reservationRepository.save(reservation);
    }
}
