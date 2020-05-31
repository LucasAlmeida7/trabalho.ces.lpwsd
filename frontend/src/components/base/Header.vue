<template>
  <header class="header-app">
    <div>SIMULADO ENADE</div>
    <div>
      <router-link to="/">
        Sair
      </router-link>
    </div>
  </header>
</template>

<script>
export default {
  name: 'HeaderApp',
}
</script>

<style scoped>
.header-app{
  border-bottom: 3px solid royalblue;
  display: flex;
  justify-content: space-between;
}
</style>
