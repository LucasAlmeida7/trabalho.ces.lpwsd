<template src="./RelatorioAlunos.html"></template>

<script>
import vm from "vue";
import Http from "@/plugins/axios";

export default {
  name: "relatorio-alunos",
  created() {
    this.buscarAlunos();
  },
  data() {
    return {
      alunos: [],
      options: {
        layout: "fitColumns",
        columns: [
          { title: "ID", field: "idUsuario", width: 150 },
          { title: "Nome", field: "nomeUsuario" },
          { title: "Email", field: "emailUsuario" }
        ]
      }
    };
  },
  methods: {
    buscarAlunos() {
      Http.get("relatorio-manager/alunos/", {})
        .then(result => {
          if (result.data != "") {
            this.alunos = result.data;
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
      this.$refs.tabulator.getInstance().download("pdf", "relatorio-alunos.pdf", {
        orientation: "portrait",
        title: "Relatório de Alunos Cadastrados"
      });
    }
  }
};
</script>