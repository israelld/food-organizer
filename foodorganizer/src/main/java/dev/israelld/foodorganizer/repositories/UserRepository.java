package dev.israelld.foodorganizer.repositories;

import dev.israelld.foodorganizer.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
