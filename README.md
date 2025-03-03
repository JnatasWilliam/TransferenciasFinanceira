# TransferenciasFinanceira

Projeto para gerenciamento de transferências financeiras.

## Instruções de Execução do backend

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

## Instruções de Execução do frontend

1. **Entrar na pasta do frontend:**
   cd transferencias-frontend
2. **Instale as dependências:**
   npm install
3. **Executar o frontend:**
   npm run serve
4. **Acesse o frontend no navegador**
   (o endereço pode variar, geralmente algo como http://localhost:8080 ou outra porta configurada).

## Documentação da API

Acesse a documentação interativa da API através do link:  
[Swagger UI](http://localhost:8080/swagger-ui/index.html) (lembre-se de iniciar o app)
