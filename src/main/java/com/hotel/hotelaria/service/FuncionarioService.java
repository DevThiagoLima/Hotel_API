package com.hotel.hotelaria.service;

import com.hotel.hotelaria.entity.Funcionario;
import com.hotel.hotelaria.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    public Funcionario salvar(Funcionario funcionario) {
        return repository.save(funcionario);
    }

    public List<Funcionario> listar() {
        return repository.findAll();
    }
}