package com.hotel.hotelaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Role extends JpaRepository<Role, Long> {

    Optional<Role> findByNome(String nome);
}
