package com.hotel.hotelaria.service;

import com.hotel.hotelaria.entity.Hospede;
import com.hotel.hotelaria.repository.HospedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospedeService {

    @Autowired
    private HospedeRepository hospedeRepository;

    public Hospede salvar(Hospede hospede) {
        hospedeRepository.findByCpf(hospede.getCpf())
                .ifPresent(h -> {
                    throw new RuntimeException("Este CPF já está cadastrado!");
                });
        return hospedeRepository.save(hospede);
    }

    public List<Hospede> listar() {
        return hospedeRepository.findAll();
    }

    public Hospede buscarPorId(Long id) {
        return hospedeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hóspede não encontrado!"));
    }

    public Hospede atualizar(Long id, Hospede hospedeAtualizado) {

        Hospede existente = buscarPorId(id);

        existente.setNome(hospedeAtualizado.getNome());
        existente.setCpf(hospedeAtualizado.getCpf());
        existente.setEmail(hospedeAtualizado.getEmail());
        existente.setTelefone(hospedeAtualizado.getTelefone());

        return hospedeRepository.save(existente);
    }

    public void deletar(Long id) {
        Hospede existente = buscarPorId(id);
        hospedeRepository.delete(existente);
    }
}
