package br.com.jonatas.transferencias.TransferenciasFinanceira.repository;


import br.com.jonatas.transferencias.TransferenciasFinanceira.model.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {
}
