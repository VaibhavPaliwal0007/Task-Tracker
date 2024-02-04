package org.example.tasktrackerbackend.repository;

import java.util.Optional;
import org.example.tasktrackerbackend.entity.RolesType;
import org.example.tasktrackerbackend.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
  Optional<UserRole> findByName(RolesType name);
}
