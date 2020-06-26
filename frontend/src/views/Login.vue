<template src="./Login.html"></template>

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
        mensagem: '',
        exibirSenha: false,
        rules: [
          value => !!value || 'Required.',
          value => (value && value.length >= 3) || 'Min 3 characters',
        ],
      }
    },
    methods: {
      loginUsuario() {
        Http.post('usuario-manager/usuario/login/', {
          emailUsuario: this.email,
          senhaUsuario: this.senha,
        }).then(result => {
          if(result.data != ''){
            this.$store.state.usuario = result.data;
            localStorage.setItem('usuario', JSON.stringify(result.data));
            router.push("/")
          }
          else{
            vm.$toast.open({
              message: 'Usuário ou senha inválidos.',
              type: 'warning',
            })
          }          
        }).catch(err => {
          console.log('Erro', err.response);
          vm.$toast.open({
            message: 'Ocorreu um erro ao acessar o sistema, tente novamente mais tarde.',
            type: 'error',
          })
        })
      },
      cadastrar() {
        router.push('cadastrar-usuario')
      }
    }
  }
</script>

<style lang="scss" src="./Login.scss" scoped></style>