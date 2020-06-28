<template src="./RelatorioResultados.html"></template>

<script>
import vm from "vue";
import Http from "@/plugins/axios";

export default {
  name: "relatorio-resultados",
  created() {
    this.buscarProvas();
    this.buscarResultados();
  },
  data() {
    return {
      idProva: 0,
      provas: [],
      resultados: [],
      options: {
        layout: "fitColumns",
        columns: [
          { title: "Usuário", field: "nomeUsuario"  },
          { title: "Valor Obtido", field: "valorObtido", width: 250 },
          { title: "Nº Questões", field: "numeroQuestoes", width: 250 }
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
    buscarResultados() {
      Http.get("relatorio-manager/resultados/" + this.idProva, {})
        .then(result => {
          if (result.data != "") {
            this.resultados = result.data;
            this.existeDados = true;
          } else {
            this.resultados = [];
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
        .download("pdf", "relatorio-resultados-prova" + + this.idProva + ".pdf", {
          orientation: "portrait",
          title: "Relatório Resultados Prova " + this.idProva
        });
    }
  },
  watch: {
    idProva() {
      this.buscarResultados();
    }
  }
};
</script>