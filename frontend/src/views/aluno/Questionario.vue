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
      debugger;
      this.questaoAtual.confirmada = true;
      if (this.indexQuestao != this.provaIniciada.questoes.length - 1) {
        this.indexQuestao++;
      } else {
        this.questaoAtual.confirmada = true;
      }
    },
    cancelarProva() {
      this.iniciado = !this.iniciado;
    },
    finalizarProva() {
      let completo = true;
      let pontos = 0;

      this.provaIniciada.questoes.forEach(pendente);

      if (!completo) {
        vm.$toast.open({
          message: "Responda todas as questões antes de finalizar.",
          type: "error"
        });
        return;
      }

      this.provaIniciada.questoes.forEach(pontuacao);

      Http.post("resultado-manager/resultado/", {
        idProva: this.provaIniciada.idProva,
        idUsuario: JSON.parse(localStorage.getItem('usuario')).idUsuario,
        valorObtido: pontos
      })
        .then(res => {
          console.log("Sucesso", res);
          vm.$toast.open({
            message: "Prova finalizada com sucesso.",
            type: "success"
          });
          this.iniciado = false;
        })
        .catch(err => {
          console.log("Erro", err.response);
          vm.$toast.open({
            message:
              "Ocorreu um erro ao cadastrar o usuário, tente novamente mais tarde.",
            type: "error"
          });
        });

      function pendente(item) {
        if (item.idTipoQuestao == 1 && !item.confirmada) {
          completo = false;
        }
      }

      function pontuacao(item) {
        if (item.idTipoQuestao == 1) {
          item.alternativaCorreta == item.alternativaMarcada ? pontos++ : null;
        } else {
          pontos++;
        }
      }
    }
  },
  computed: {
    questaoAtual() {
      return this.provaIniciada.questoes[this.indexQuestao];
    }
  }
};
</script>
