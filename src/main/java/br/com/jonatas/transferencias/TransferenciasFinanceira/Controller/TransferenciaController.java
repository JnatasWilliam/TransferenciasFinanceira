package br.com.jonatas.transferencias.TransferenciasFinanceira.Controller;

import br.com.jonatas.transferencias.TransferenciasFinanceira.Service.TransferenciaService;
import br.com.jonatas.transferencias.TransferenciasFinanceira.model.Transferencia;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transferencias")
@RequiredArgsConstructor
public class TransferenciaController {

    private final TransferenciaService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Transferencia criarTransferencia(@RequestBody Transferencia transferencia) {
        return service.agendarTransferencia(transferencia);
    }

    @GetMapping
    public List<Transferencia> listarTransferencias() {
        return service.listarTransferencias();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
