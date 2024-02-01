package org.example.tasktrackerbackend.repository;

import java.util.Optional;
import org.example.tasktrackerbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
  Optional<User> findByName(String username);

  Boolean existsByEmail(String email);

  Optional<User> findByNameOrEmail(String username, String email);

  Boolean existsByName(String username);
}
