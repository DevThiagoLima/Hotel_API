package com.hotel.hotelaria.repository;

import com.hotel.hotelaria.entity.Funcionario;
import com.hotel.hotelaria.entity.Hospede;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    Optional<Funcionario> findByCpf(String cpf);
}
