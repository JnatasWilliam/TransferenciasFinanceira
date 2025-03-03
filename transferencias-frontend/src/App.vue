<template>
  <div id="app">
  <ThemeToggle />
    <h1 class="fonte-style-h">Agendamento de Transferências</h1>
    <form @submit.prevent="criarTransferencia">
      <div>
        <label>Conta de Origem:</label>
        <input type="text" v-model="transferencia.contaOrigem" placeholder="" required>
      </div>
      <div>
        <label>Conta de Destino:</label>
        <input type="text" v-model="transferencia.contaDestino" placeholder="" required>
      </div>
      <div>
        <label>Valor:</label>
        <input type="number" v-model="transferencia.valor" step="0.01" required>
      </div>
      <div>
        <label>Data de Transferência:</label>
        <input type="date" v-model="transferencia.dataTransferencia" required>
      </div>
      <button type="submit" class="btn btn-custom">Agendar Transferência</button>
    </form>

    <div v-if="transferencias.length > 0" class="mt-5">
      <h2 class="fonte-style-h">Transferências Agendadas</h2>
      <table class="table table-striped">
        <thead>
          <tr>
            <th>Conta Origem</th>
            <th>Conta Destino</th>
            <th>Valor</th>
            <th>Taxa</th>
            <th>Data Transferência</th>
            <th>Data Agendamento</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="item in transferencias" :key="item.id">
            <td>{{ item.contaOrigem }}</td>
            <td>{{ item.contaDestino }}</td>
            <td>{{ item.valor }}</td>
            <td>{{ item.taxa }}</td>
            <td>{{ item.dataTransferencia }}</td>
            <td>{{ item.dataAgendamento }}</td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
import ThemeToggle from './components/ThemeToggle.vue';

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

  components: {
      ThemeToggle,
    },

  methods: {
    async criarTransferencia() {
      // Define a dataAgendamento como hoje se não estiver preenchida
      if (!this.transferencia.dataAgendamento) {
        this.transferencia.dataAgendamento = new Date().toISOString().split('T')[0];
      }
      try {
        console.log(this.transferencia);
        const response = await axios.post('http://localhost:8080/transferencias', this.transferencia);
        console.log(response);  // Usando a variável 'response' para debugar
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
      console.log(error);
        alert('Erro ao agendar a transferência: ' + error.message);
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