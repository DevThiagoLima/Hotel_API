package com.hotel.hotelaria.service;

import com.hotel.hotelaria.entity.Funcionario;
import com.hotel.hotelaria.entity.Hospede;
import com.hotel.hotelaria.entity.Quarto;
import com.hotel.hotelaria.entity.Reserva;
import com.hotel.hotelaria.repository.FuncionarioRepository;
import com.hotel.hotelaria.repository.HospedeRepository;
import com.hotel.hotelaria.repository.QuartoRepository;
import com.hotel.hotelaria.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private HospedeRepository hospedeRepository;

    @Autowired
    private QuartoRepository quartoRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Reserva salvar(Reserva reserva) {

        Hospede hospede = hospedeRepository.findById(reserva.getHospede().getId())
                .orElseThrow(() -> new RuntimeException("Hóspede não encontrado"));

        Quarto quarto = quartoRepository.findById(reserva.getQuarto().getId())
                .orElseThrow(() -> new RuntimeException("Quarto não encontrado"));

        Funcionario funcionario = funcionarioRepository.findById(reserva.getFuncionario().getId())
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        reserva.setHospede(hospede);
        reserva.setQuarto(quarto);
        reserva.setFuncionario(funcionario);

        reserva.setDataReserva(LocalDate.now());
        reserva.setStatus("Reservado");

        return reservaRepository.save(reserva);
    }

    public List<Reserva> listar() {
        return reservaRepository.findAll();
    }

    public Reserva buscarPorId(Long id) {
        return reservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva não encontrada"));
    }

    public void cancelar(Long id) {
        Reserva reserva = buscarPorId(id);
        reserva.setStatus("Cancelado");
        reservaRepository.save(reserva);
    }
}
