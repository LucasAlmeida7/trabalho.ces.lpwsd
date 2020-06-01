<template>
  <div class="page">
    <HeaderApp />
    <h3>Cadastrar Usuário</h3>
    <div class="box">
      <span>Nome: </span>
      <input type="text" name="nome" v-model="nome">
    </div>

    <div class="box">
      <span>Email: </span>
      <input type="email" name="email" v-model="email">
    </div>

    <div class="box">
      <span>Senha: </span>
      <input type="password" name="senha" v-model="senha">
    </div>

    <div class="box">
      <span>Repetir Senha: </span>
      <input type="password" name="RepetirSenha">
    </div>

    <div class="box">
      <button @click="cadastrarUsuario()">Cadastrar</button>
    </div>
  </div>
</template>

<script>
import HeaderApp from '@/components/base/Header.vue'
import Http from '@/plugins/axios'

export default {
  name: 'CadastrarUsuario',
  components: {
    HeaderApp,    
  },
  data(){
		return {
      nome: '',
      email: '',
      senha: '',
		}
	},
  methods: {
    cadastrarUsuario() {
      Http.post('usuario/', {
        emailUsuario: this.email,
        idTipoUsuario: 1,
        nomeUsuario: this.nome,
        senhaUsuario: this.senha,
      })
      .then(res => {
        console.log('Sucesso', res);
      }).catch(err => {
        console.log('Erro', err.response);
      })
    },
  }
}
</script>

<style scoped>
  .box {
    padding-bottom: 15px;
  }
</style>
