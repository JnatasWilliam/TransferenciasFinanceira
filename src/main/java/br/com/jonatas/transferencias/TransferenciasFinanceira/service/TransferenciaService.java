package br.com.jonatas.transferencias.TransferenciasFinanceira.service;

import br.com.jonatas.transferencias.TransferenciasFinanceira.mapper.TransferenciaMapper;
import br.com.jonatas.transferencias.TransferenciasFinanceira.repository.TransferenciaRepository;
import br.com.jonatas.transferencias.TransferenciasFinanceira.model.Transferencia;
import br.com.jonatas.transferencias.TransferenciasFinanceira.util.CalcularTaxa;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;

@Service
public class TransferenciaService {

    private final TransferenciaRepository repository;

    public TransferenciaService(TransferenciaRepository repository) {
        this.repository = repository;
    }

    public Transferencia agendarTransferencia(Transferencia transferencia) {
        long dias = ChronoUnit.DAYS.between(transferencia.getDataAgendamento(), transferencia.getDataTransferencia());

        if (dias < 0) {
            throw new IllegalArgumentException("Data de transferência não pode ser anterior à data de agendamento");
        }

        BigDecimal taxa = CalcularTaxa.calculaTaxa(transferencia.getValor(), dias);
        transferencia.setTaxa(taxa);

        return repository.save(transferencia);
    }

    public List<Transferencia> listarTransferencias() {
        return repository.findAll();
    }
}
