package parkingreservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import parkingreservation.model.Reservation;
import parkingreservation.model.User;
import parkingreservation.service.ReservationService;
import parkingreservation.service.UserService;

import java.util.List;

@Controller
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private UserService userService;

    @GetMapping("/reservations")
    public String getUserReservations(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        User user = userService.findByUsername(userDetails.getUsername());
        List<Reservation> reservations = reservationService.findReservationsByUser(user);
        model.addAttribute("reservations", reservations);
        return "reservations";
    }

    @GetMapping("/createReservation")
    public String showCreateReservationForm(Model model) {
        model.addAttribute("reservation", new Reservation());
        return "createReservation";
    }

    @PostMapping("/createReservation")
    public String createReservation(@AuthenticationPrincipal UserDetails userDetails, Reservation reservation) {
        User user = userService.findByUsername(userDetails.getUsername());
        reservation.setUser(user);
        reservationService.save(reservation);
        return "redirect:/reservations";
    }
}