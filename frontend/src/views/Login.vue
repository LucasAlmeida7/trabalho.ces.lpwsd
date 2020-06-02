<template>
  <div class="login-app">
    <h2>SIMULADO ENADE</h2>
    <hr>
    <h5>Bem vindo ao Simulado Enade, acesse com:</h5>
    
    <div class="login-section">
      <span class="login-field">E-mail: </span>
      <input name="email" type="text" v-model="email" >
    </div>
    
    <div class="login-section">
      <span class="login-field">Senha: </span>
      <input name="senha" type="password" v-model="senha">
    </div>
    
    <div class="login-section">
      <button value="Login" @click="loginUsuario">Login</button>
    </div>
    
    <hr>

    <h5>Não possui cadastro? </h5>
    <router-link to="/cadastrar-usuario">
      <button value="Cadastrar">Cadastrar</button>
    </router-link>
    <p>{{ mensagem }}</p>
  </div>
</template>

<script>
import vm from 'vue'
import Http from '@/plugins/axios'
import router from '@/router'

export default {
  name: 'login',
  data(){
		return {
      email: '',
      senha: '',
      mensagem: ''
		}
	},
  methods: {
    loginUsuario() {
      Http.post('usuario/login/', {
        emailUsuario: this.email,
        senhaUsuario: this.senha,
      }).then(res => {
        if(res.data != ''){
          router.push('home')
        }
        vm.$toast.open({
          message: 'Usuário ou senha inválidos!',
          type: 'warning',
        })
      }).catch(err => {
        console.log('Erro', err.response);
      })
    }
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