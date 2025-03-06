package br.com.jonatas.transferencias.TransferenciasFinanceira.controller;

import br.com.jonatas.transferencias.TransferenciasFinanceira.dto.TransferenciaDTO;
import br.com.jonatas.transferencias.TransferenciasFinanceira.mapper.TransferenciaMapper;
import br.com.jonatas.transferencias.TransferenciasFinanceira.service.TransferenciaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/transferencias")
public class TransferenciaController {

    private final TransferenciaService service;
    private TransferenciaMapper mapper;

    TransferenciaController(TransferenciaService service, TransferenciaMapper mapper){
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<TransferenciaDTO> criarTransferencia(@RequestBody TransferenciaDTO transferenciaDTO) {
        var transferenciaEntity = mapper.toEntity(transferenciaDTO);
        var transferenciaSalva = service.agendarTransferencia(transferenciaEntity);
        TransferenciaDTO responseDTO = mapper.toDTO(transferenciaSalva);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping
    public ResponseEntity<List<TransferenciaDTO>> listarTransferencias() {
        List<TransferenciaDTO> transferencias = mapper.toDTOList(service.listarTransferencias());
        return ResponseEntity.ok(transferencias);
    }
}
