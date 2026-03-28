package com.hotel.hotelaria.repository;

import com.hotel.hotelaria.entity.Quarto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.expression.spel.ast.OpOr;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuartoRepository extends JpaRepository<Quarto, Long> {

    List<Quarto> findByStatus(String status);
}
