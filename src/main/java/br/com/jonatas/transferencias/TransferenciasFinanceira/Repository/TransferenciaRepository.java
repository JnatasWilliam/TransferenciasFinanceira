package br.com.jonatas.transferencias.TransferenciasFinanceira.Repository;


import br.com.jonatas.transferencias.TransferenciasFinanceira.model.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {
}
