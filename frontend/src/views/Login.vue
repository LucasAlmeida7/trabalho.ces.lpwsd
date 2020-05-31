<template>
  <div class="login-app">
    <h2>SIMULADO ENADE</h2>
    <hr>
    <h5>Bem vindo ao Simulado Enade, acesse com:</h5>
    
    <div class="login-section">
      <span class="login-field">E-mail: </span>
      <input name="email" type="text">
    </div>
    
    <div class="login-section">
      <span class="login-field">Senha: </span>
      <input name="senha" type="password">
    </div>
    
    <div class="login-section">
      <router-link to="/home">
        <button value="Login">Login</button>
      </router-link>
    </div>
    
    <hr>

    <h5>Não possui cadastro? </h5>
    <router-link to="/cadastrar-usuario">
      <button value="Cadastrar">Cadastrar</button>
    </router-link>

  </div>
</template>

<script>

export default {
  name: 'login',
  components: {
    
  }
}
</script>

<style scoped>
.login-app{
  text-align: center;
  margin: 30px;
}

.login-section{
  padding-bottom: 15px;
}

</style>