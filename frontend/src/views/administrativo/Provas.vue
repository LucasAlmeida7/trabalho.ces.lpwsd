<template src="./Provas.html"></template>

<script>
import vm from "vue";
import Http from "@/plugins/axios";
import router from '@/router'

export default {
  name: "provas",
  data() {
    return {
      pesquisa: "",
      headers: [
        {
          text: "ID",
          align: "start",
          value: "idProva"
        },
        { text: "Data", value: "dataProva" },
        { text: "Nº Questões", value: "numQuestoes" },
        { text: "Ações", value: "actions", sortable: false, align: "center" }
      ],
      provas: [],
    };
  },
  created() {
    this.buscarProvas();
  },
  methods: {
    gerenciarProva(){
      router.push("/provas/gerenciar");
    },
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
    }
  }
};
</script>

<style lang="scss" src="./Provas.scss" scoped></style>