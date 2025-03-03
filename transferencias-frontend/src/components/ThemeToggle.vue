<!-- ThemeToggle.vue -->
<template>
  <div class="theme-toggle">
    <label for="theme-select">Selecione o tema:</label>
    <select
      id="theme-select"
      v-model="selectedTheme"
      @change="changeTheme"
      class="btn-custom"
    >
      <option value="auto">Automático</option>
      <option value="light">Claro</option>
      <option value="dark">Escuro</option>
    </select>
  </div>
</template>

<script>
export default {
  data() {
    return {
      selectedTheme: 'auto',
    };
  },
  mounted() {
    this.loadTheme();
  },
  methods: {
    changeTheme() {
      document.documentElement.classList.remove('light-theme', 'dark-theme');
      if (this.selectedTheme === 'dark') {
        document.documentElement.classList.add('dark-theme');
        localStorage.setItem('theme', 'dark');
      } else if (this.selectedTheme === 'light') {
        document.documentElement.classList.add('light-theme');
        localStorage.setItem('theme', 'light');
      } else {
        localStorage.removeItem('theme');
        this.applyAutoTheme();
      }
    },
    loadTheme() {
      const savedTheme = localStorage.getItem('theme');
      if (savedTheme) {
        this.selectedTheme = savedTheme;
        this.changeTheme();
      } else {
        this.applyAutoTheme();
      }
    },
    applyAutoTheme() {
      const prefersDark = window.matchMedia(
        '(prefers-color-scheme: dark)'
      ).matches;
      if (prefersDark) {
        document.documentElement.classList.add('dark-theme');
      } else {
        document.documentElement.classList.add('light-theme');
      }
    },
  },
};
</script>

<style scoped>
.theme-toggle {
  position: fixed;
  top: 5px;
  right: 5px;
  background: var(--background-color);
  color: var(--text-color);
  padding: 10px;
  border-radius: 5px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

select {
  margin-left: 10px;
}
</style>