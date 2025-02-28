<template>
  <div id="app">
    <h1>Agendamento de Transferências</h1>
    <form @submit.prevent="criarTransferencia">
      <div>
        <label>Conta de Origem:</label>
        <input type="text" v-model="transferencia.contaOrigem" placeholder="XXXXXXXXXX" required>
      </div>
      <div>
        <label>Conta de Destino:</label>
        <input type="text" v-model="transferencia.contaDestino" placeholder="XXXXXXXXXX" required>
      </div>
      <div>
        <label>Valor:</label>
        <input type="number" v-model="transferencia.valor" step="0.01" required>
      </div>
      <div>
        <label>Data de Transferência:</label>
        <input type="date" v-model="transferencia.dataTransferencia" required>
      </div>
      <!-- A data de agendamento será definida automaticamente -->
      <button type="submit">Agendar Transferência</button>
    </form>
    <h2>Transferências Agendadas</h2>
    <ul>
      <li v-for="item in transferencias" :key="item.id">
        ID: {{ item.id }}, Conta Origem: {{ item.contaOrigem }}, Conta Destino: {{ item.contaDestino }}, Valor: {{ item.valor }}, Taxa: {{ item.taxa }}, Data Transferência: {{ item.dataTransferencia }}, Data Agendamento: {{ item.dataAgendamento }}
      </li>
    </ul>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'App',
  data() {
    return {
      transferencia: {
        contaOrigem: '',
        contaDestino: '',
        valor: null,
        dataTransferencia: '',
        dataAgendamento: '' // será definida como a data atual se não for informada
      },
      transferencias: []
    };
  },
  methods: {
    async criarTransferencia() {
      // Define a dataAgendamento como hoje se não estiver preenchida
      if (!this.transferencia.dataAgendamento) {
        this.transferencia.dataAgendamento = new Date().toISOString().split('T')[0];
      }
      try {
        const response = await axios.post('http://localhost:8080/transferencias', this.transferencia);
        alert('Transferência agendada com sucesso!');
        this.buscarTransferencias();
        // Limpa o formulário
        this.transferencia = {
          contaOrigem: '',
          contaDestino: '',
          valor: null,
          dataTransferencia: '',
          dataAgendamento: ''
        };
      } catch (error) {
        alert('Erro ao agendar a transferência: ' + error.response.data);
      }
    },
    async buscarTransferencias() {
      try {
        const response = await axios.get('http://localhost:8080/transferencias');
        this.transferencias = response.data;
      } catch (error) {
        console.error('Erro ao buscar transferências:', error);
      }
    }
  },
  mounted() {
    this.buscarTransferencias();
  }
}
</script>

<style>
/* Adicione estilos conforme necessário */
#app {
  max-width: 600px;
  margin: 0 auto;
  padding: 20px;
}
form div {
  margin-bottom: 10px;
}
</style>
