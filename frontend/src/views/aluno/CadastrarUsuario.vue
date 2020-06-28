<template src="./CadastrarUsuario.html"></template>

<script>
import vm from "vue";
import Http from "@/plugins/axios";
import router from "@/router";

export default {
  name: "CadastrarUsuario",
  data() {
    return {
      usuario: {
        nome: "",
        email: "",
        senha: "",
        repetirSenha: "",
      },
      exibirSenha: false,
      finalizado: false,
      rules: [
        value => !!value || "Required.",
        value => (value && value.length >= 3) || "Min 3 characters"
      ]
    };
  },
  methods: {
    cadastrarUsuario() {
      if (!this.validarCampos()) return;

      Http.post("usuario-manager/usuario/", {
        emailUsuario: this.usuario.email,
        idTipoUsuario: 2,
        nomeUsuario: this.usuario.nome,
        senhaUsuario: this.usuario.senha
      })
        .then(res => {
          console.log("Sucesso", res);
          vm.$toast.open({
            message: "Cadastro realizado com sucesso.",
            type: "success"
          });
          this.finalizado = true;
        })
        .catch(err => {
          console.log("Erro", err.response);
          vm.$toast.open({
            message:
              "Ocorreu um erro ao cadastrar o usuário, tente novamente mais tarde.",
            type: "error"
          });
        });
    },
    navegarLogin() {
      router.push("/");
    },
    validarCampos() {
      let mensagens = [];

      if (this.usuario.nome == "") mensagens.push("O campo nome deve ser informado!");

      if (this.usuario.email == "")
        mensagens.push("O campo e-mail deve ser informado!");

      if (this.usuario.senha == "") mensagens.push("O campo senha deve ser informado!");

      if (this.usuario.repetirSenha == "")
        mensagens.push("O campo repetir senha deve ser informado!");

      if (this.usuario.senha != this.usuario.repetirSenha)
        mensagens.push("As senha devem ser iguais!");

      if (mensagens.length > 0) {
        vm.$toast.open({
          message: mensagens.join("<br>"),
          type: "error"
        });

        return false;
      }

      return true;
    }
  }
};
</script>

<style lang="scss" src="./CadastrarUsuario.scss" scoped></style>