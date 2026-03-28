package com.hotel.hotelaria.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_hospede")
    private Hospede hospede;

    @ManyToOne
    @JoinColumn(name = "id_quarto")
    private Quarto quarto;

    @ManyToOne
    @JoinColumn(name = "id_funcionario")
    private Funcionario funcionario;

    private LocalDate dataReserva;

    private LocalDate dataCheckinPrevista;

    private LocalDate dataCheckoutPrevista;

    private LocalDate dataCheckinReal;

    private LocalDate dataCheckoutReal;

    private String status;
}
