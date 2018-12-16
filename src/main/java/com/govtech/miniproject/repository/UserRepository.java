package com.govtech.miniproject.repository;

import com.govtech.miniproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllBySalaryIsBetween(Double min, Double max);
}
