package parkingreservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import parkingreservation.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
