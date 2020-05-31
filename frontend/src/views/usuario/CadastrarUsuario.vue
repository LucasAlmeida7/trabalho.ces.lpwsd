<template>
  <div class="page">
    <HeaderApp />
    <h3>Cadastrar Usuário</h3>
    <div class="box">
      <span>Nome: </span>
      <input type="text" name="nome">
    </div>

    <div class="box">
      <span>Email: </span>
      <input type="email" name="email">
    </div>

    <div class="box">
      <span>Senha: </span>
      <input type="password" name="senha">
    </div>

    <div class="box">
      <span>Repetir Senha: </span>
      <input type="password" name="RepetirSenha">
    </div>

    <div class="box">
      <button>Cadastrar</button>
    </div>
  </div>
</template>

<script>
import HeaderApp from '@/components/base/Header.vue'

export default {
  name: 'CadastrarUsuario',
  components: {
    HeaderApp,    
  }
}
</script>

<style scoped>
.box {
  padding-bottom: 15px;
}
</style>
