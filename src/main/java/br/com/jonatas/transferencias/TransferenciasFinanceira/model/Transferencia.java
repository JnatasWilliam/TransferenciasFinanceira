package br.com.jonatas.transferencias.TransferenciasFinanceira.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "transferencias")
@Data
@NoArgsConstructor
public class Transferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contaOrigem;
    private String contaDestino;

    private BigDecimal valor;

    // Data em que a transferência será realizada
    private LocalDate dataTransferencia;
    // Data do agendamento (geralmente a data atual)
    private LocalDate dataAgendamento;

    // Taxa calculada conforme regras de negócio
    private BigDecimal taxa;
}