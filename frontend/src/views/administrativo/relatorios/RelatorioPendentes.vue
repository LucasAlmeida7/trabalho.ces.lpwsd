<template src="./RelatorioPendentes.html"></template>

<script>
import vm from "vue";
import Http from "@/plugins/axios";

export default {
  name: "relatorio-pendentes",
  created() {
    this.buscarProvas();
  },
  data() {
    return {
      idProva: 0,
      provas: [],
      alunos: [],
      options: {
        layout: "fitColumns",
        columns: [
          { title: "ID", field: "idUsuario", width: 150 },
          { title: "Nome", field: "nomeUsuario" },
          { title: "Email", field: "emailUsuario" }
        ]
      },
      existeDados: false
    };
  },
  methods: {
    buscarProvas() {
      Http.get("prova-manager/provas/", {})
        .then(result => {
          if (result.data != "") {
            this.provas = result.data;
          }
        })
        .catch(err => {
          console.log("Erro", err.response);
          vm.$toast.open({
            message:
              "Ocorreu um erro ao acessar os dados, tente novamente mais tarde.",
            type: "error"
          });
        });
    },
    buscarAlunos() {
      Http.get("relatorio-manager/alunos-pendentes/" + this.idProva, {})
        .then(result => {
          if (result.data != "") {
            this.alunos = result.data;
            this.existeDados = true;
          } else {
            this.alunos = [];
            this.existeDados = false;
          }
        })
        .catch(err => {
          console.log("Erro", err.response);
          vm.$toast.open({
            message:
              "Ocorreu um erro ao acessar os dados, tente novamente mais tarde.",
            type: "error"
          });
        });
    },
    downloadPdf() {
      this.$refs.tabulator
        .getInstance()
        .download("pdf", "relatorio-alunos-pendentes.pdf", {
          orientation: "portrait",
          title: "Relatório Alunos Pendentes da Prova " + this.idProva
        });
    }
  },
  watch: {
    idProva() {
      this.buscarAlunos();
    }
  }
};
</script>