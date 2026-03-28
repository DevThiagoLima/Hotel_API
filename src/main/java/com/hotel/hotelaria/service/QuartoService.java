package com.hotel.hotelaria.service;

import com.hotel.hotelaria.entity.Quarto;
import com.hotel.hotelaria.repository.QuartoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuartoService {

    @Autowired
    private QuartoRepository repository;

    public Quarto salvar(Quarto quarto) {
        return repository.save(quarto);
    }

    public List<Quarto> listar() {
        return repository.findAll();
    }

    public Quarto buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Quarto não encontrado!"));
    }

    public Quarto atualizar(Long id, Quarto atualizado) {
        Quarto existente = buscarPorId(id);

        existente.setNumero(atualizado.getNumero());
        existente.setTipo((atualizado.getTipo()));
        existente.setStatus((atualizado.getStatus()));
        existente.setDescricao((atualizado.getDescricao()));

        return repository.save(existente);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
