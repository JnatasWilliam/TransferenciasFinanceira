# TransferenciasFinanceira

## Instruções de Execução

1. **Clonar o repositório:**
   gitbash
   git clone https://github.com/JnatasWilliam/TransferenciasFinanceira.git

2. **Executar o backend:**
   mvn spring-boot:run

3. **Testar os Endpoints:**
   A API estará disponível em http://localhost:8080

   Utilize ferramentas como Postman ou cURL para:
      POST http://localhost:8080/transferencias (para agendar uma transferência)

         Exemplo Json: {
                         "contaOrigem": "XXXXXXXXXX",
                         "contaDestino": "XXXXXXXXXX",
                         "valor": 1000.00,
                         "dataTransferencia": "2025-03-10",
                         "dataAgendamento": "2025-03-01"
         }

      GET http://localhost:8080/transferencias (para listar os agendamentos)


4. **Acessar o console H2:**
   Acesse http://localhost:8080/h2-console para visualizar o banco de dados (conforme configurado no arquivo application.properties).