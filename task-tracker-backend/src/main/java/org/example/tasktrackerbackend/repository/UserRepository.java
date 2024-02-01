package org.example.tasktrackerbackend.repository;

import java.util.Optional;
import org.example.tasktrackerbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

  Boolean existsByEmail(String email);

  Optional<User> findByUsernameOrEmail(String username, String email);

  Boolean existsByUsername(String username);

  Optional<User> findByUsername(String username);
}
