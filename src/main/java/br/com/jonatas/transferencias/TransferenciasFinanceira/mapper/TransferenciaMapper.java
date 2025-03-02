package br.com.jonatas.transferencias.TransferenciasFinanceira.mapper;

import br.com.jonatas.transferencias.TransferenciasFinanceira.dto.TransferenciaDTO;
import br.com.jonatas.transferencias.TransferenciasFinanceira.model.Transferencia;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransferenciaMapper {
    TransferenciaMapper INSTANCE = Mappers.getMapper(TransferenciaMapper.class);

    TransferenciaDTO toDTO(Transferencia transferencia);
    Transferencia toEntity(TransferenciaDTO transferenciaDTO);
    List<TransferenciaDTO> toDTOList(List<Transferencia> transferencia);
}
