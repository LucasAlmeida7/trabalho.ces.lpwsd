<template src="./CadastrarUsuario.html"></template>

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