<template src="./Header.html"></template>

<script>
import router from "@/router";

export default {
  name: "HeaderApp",
  data() {
    return {
      drawer: false
    };
  },
  methods: {
    home() {
      router.push("/");
    },
    gerenciarQuestao() {
      router.push("/questoes");
    },
    gerenciarProvas() {
      router.push("/provas");
    },
    acessarQuestionario() {
      router.push("/questionario");
    },
    acessarGraficoResultados() {
      router.push("/grafico/resultados");
    },
    acessarGraficoPendentes() {
      router.push("/grafico/pendentes");
    },
    logout() {
      localStorage.removeItem("usuario");
      router.push("/login");
    }
  },
  computed: {
    usuarioLogado() {
      let usuario = localStorage.getItem("usuario");

      if (!usuario) {
        this.logout();
        return {
          idUsuario: 0,
          nomeUsuario: "",
          emailUsuario: "",
          senhaUsuario: "",
          idTipoUsuario: 0
        };
      }

      return JSON.parse(usuario);
    }
  }
};
</script>