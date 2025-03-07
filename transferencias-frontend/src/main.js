  import { createApp } from 'vue';
  import App from './App.vue';
  import { BootstrapVueNext } from 'bootstrap-vue-next';

  import 'bootstrap/dist/css/bootstrap.min.css';
  import 'bootswatch/dist/cyborg/bootstrap.min.css';
  import 'bootstrap-vue-next/dist/bootstrap-vue-next.css';


  import './assets/styles.css';

  const app = createApp(App);
  app.use(BootstrapVueNext);
  app.mount('#app');