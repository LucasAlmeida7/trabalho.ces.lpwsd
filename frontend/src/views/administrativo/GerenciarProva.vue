<template src="./GerenciarProva.html"></template>

<script>
import vm from "vue";
import Http from "@/plugins/axios";
import router from "@/router";

export default {
  name: "gerenciar-prova",
  data() {
    return {
      pesquisa: "",
      headers: [
        {
          text: "ID",
          align: "start",
          value: "idQuestao"
        },
        { text: "Descrição", value: "descricaoQuestao" },
        { text: "Estado", value: "estadoQuestao" },
        { text: "Tipo Questão", value: "nomeTipoQuestao" }
      ],
      questoes: [],
      idProva: 7,
      prova: {
        dataProva: new Date().toISOString().substr(0, 10),
        questoes: []
      },
      selecionadas: [],
      calendario: false,
      inclusao: false,
    };
  },
  created() {
    this.buscarQuestoes();
  },
  methods: {
    buscarQuestoes() {
      Http.get("questao-manager/questoes/ativadas", {})
        .then(result => {
          if (result.data != "") {
            this.questoes = result.data;
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
    salvar() {
      if (this.selecionadas.length == 0) {
        vm.$toast.open({
          message: "Informe as questões da prova.",
          type: "error"
        });
        return;
      }

      if (this.inclusao) {
        Http.post("prova-manager/prova/", this.prova)
          .then(() => {
            vm.$toast.open({
              message: "Cadastro realizado com sucesso.",
              type: "success"
            });
            router.back();
          })
          .catch(err => {
            console.log("Erro", err.response);
            vm.$toast.open({
              message:
                "Ocorreu um erro ao cadastrar, tente novamente mais tarde.",
              type: "error"
            });
          });
      } else {
        Http.put("prova-manager/prova/" + this.idProva, this.prova)
          .then(res => {
            console.log("Sucesso", res);
            vm.$toast.open({
              message: "Registro atualizado com sucesso.",
              type: "success"
            });
            router.back();
          })
          .catch(err => {
            console.log("Erro", err.response);
            vm.$toast.open({
              message:
                "Ocorreu um erro ao atualizar o registro, tente novamente mais tarde.",
              type: "error"
            });
          });
      }
    },
    voltar() {
      router.back();
    },
    formatDate(date) {
      if (!date) return null;
      const [year, month, day] = date.split("-");
      return `${day}/${month}/${year}`;
    }
  },
  computed: {
    dataFormatada() {
      return this.formatDate(this.prova.dataProva);
    },
    tituloOperacao(){
      return this.inclusao ? "Cadastrar Prova" : "Atualizar Prova";
    }
  },
  watch: {
    selecionadas() {
      let items = [];
      this.selecionadas.filter(questao =>
        items.push({ idQuestao: questao.idQuestao })
      );
      this.prova.questoes = items;
    }
  }
};
</script>

<style lang="scss" src="./GerenciarProva.scss" scoped></style>