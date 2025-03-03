package br.com.jonatas.transferencias.TransferenciasFinanceira.util;

import java.math.BigDecimal;
import java.util.Map;

public class CalcularTaxa {

    private static final BigDecimal TAXA_FIXA_MESMO_DIA = new BigDecimal("3.00");
    private static final BigDecimal PERCENTUAL_MESMO_DIA = new BigDecimal("0.025");

    private static final Map<Integer, BigDecimal> TAXAS = Map.of(
            10, new BigDecimal("12.00"), // 1 a 10 dias
            20, new BigDecimal("0.082"), // 11 a 20 dias
            30, new BigDecimal("0.069"), // 21 a 30 dias
            40, new BigDecimal("0.047"), // 31 a 40 dias
            50, new BigDecimal("0.017")  // 41 a 50 dias
    );

    public static BigDecimal calculaTaxa(BigDecimal valor, long dias) {
        if (dias == 0) {
            return TAXA_FIXA_MESMO_DIA.add(valor.multiply(PERCENTUAL_MESMO_DIA));
        }

        return TAXAS.entrySet().stream()
                .filter(entry -> dias <= entry.getKey())
                .findFirst()
                .map(entry -> entry.getValue().compareTo(BigDecimal.ONE) < 0
                        ? valor.multiply(entry.getValue())
                        : entry.getValue())
                .orElseThrow(() -> new IllegalArgumentException("Não há taxa aplicável para transferências com essa data"));
    }
}
