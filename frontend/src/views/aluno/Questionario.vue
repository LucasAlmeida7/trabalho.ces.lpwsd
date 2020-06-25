<template src="./Questionario.html"></template>

<script>
import vm from "vue";
import Http from "@/plugins/axios";
//import router from '@/router'

export default {
  name: "questionario",
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
      iniciado: false,
      provaIniciada: [],
      indexQuestao: 0,
      nota: 0
    };
  },
  created() {
    this.buscarProvas();
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
    iniciarProva(idProva) {
      this.iniciado = !this.iniciado;
      Http.get("prova-manager/prova/" + idProva, {})
        .then(result => {
          if (result.data != "") {
            this.provaIniciada = result.data;
            this.provaIniciada.idProva = idProva;
            console.log("PROVA", this.provaIniciada);
          } else {
            vm.$toast.open({
              message: "Nenhuma questão encontrada.",
              type: "warning"
            });
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
    anteriorQuestao() {
      this.indexQuestao--;
    },
    proximaQuestao() {
      this.indexQuestao++;
    },
    confirmarQuestao() {
      this.questaoAtual.confirmada = true;
      if (this.indexQuestao != this.provaIniciada.questoes.length - 1) {
        this.indexQuestao++;
      }
    },
    cancelarProva() {
      this.iniciado = !this.iniciado;
    },
    finalizarProva() {
      let count = 0;
      this.provaIniciada.questoes.forEach(pontuacao);

      function pontuacao(item) {
        if (item.idTipoQuestao == 1) {
          item.alternativaCorreta == item.alternativaMarcada ? count++ : null;
        } else {
          count++;
        }
      }

      this.nota = count;
    }
  },
  computed: {
    questaoAtual() {
      return this.provaIniciada.questoes[this.indexQuestao];
    }
  }
};
</script>

<style lang="scss" src="./Questionario.scss" scoped></style>

