<template src="./Questoes.html"></template>

<script>
import vm from "vue";
import Http from "@/plugins/axios";

export default {
  name: "questoes",
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
        { text: "Tipo Questão", value: "idTipoQuestao" },
        { text: "Ações", value: "actions", sortable: false, align: "end" }
      ],
      questoes: [],
      dialog: false,
      inclusao: false,
      tituloModal: "",
      questao: {
        descricaoQuestao: "",
        alternativaA: "",
        alternativaB: "",
        alternativaC: "",
        alternativaD: "",
        alternativaE: "",
        alternativaCorreta: "A",
        estadoQuestao: 1,
        idTipoQuestao: 1
      },
      questaoDefault: {
        descricaoQuestao: "",
        alternativaA: "",
        alternativaB: "",
        alternativaC: "",
        alternativaD: "",
        alternativaE: "",
        alternativaCorreta: "A",
        estadoQuestao: 1,
        idTipoQuestao: 1
      },
      estados: [
        { id: "1", descricao: "Ativa" },
        { id: "2", descricao: "Inativa" }
      ],
      tiposQuestao: [
        { idTipoQuestao: "1", descricao: "Discursiva" },
        { idTipoQuestao: "2", descricao: "Objetiva" }
      ]
    };
  },
  created() {
    this.buscarQuestoes();
  },
  methods: {
    buscarQuestoes() {
      Http.get("questao-manager/questoes/", {})
        .then(result => {
          if (result.data != "") {
            this.questoes = result.data;
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
            message: "Ocorreu um erro ao acessar os dados, tente novamente mais tarde.",
            type: "error"
          });
        });
    },
    incluirQuestao() {
      this.dialog = true;
      this.inclusao = true;
      this.tituloModal = "Incluir Questão";
      this.questao = Object.assign({}, this.questaoDefault);
    },
    editarQuestao(idQuestao) {
      this.dialog = true;
      this.inclusao = false;
      this.tituloModal = "Editar Questão";
      this.questao = Object.assign({}, this.questaoDefault);

      Http.get("questao-manager/questao/" + idQuestao, {})
        .then(result => {
          if (result.data != "") {
            this.questao = result.data;
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
            message: "Ocorreu um erro ao acessar os dados, tente novamente mais tarde.",
            type: "error"
          });
        });
    },
    salvarModal() {
      if (this.inclusao) {
        Http.post("questao-manager/questao/", this.questao)
          .then(res => {
            console.log("Sucesso", res);
            vm.$toast.open({
              message: "Cadastro realizado com sucesso.",
              type: "success"
            });
            this.dialog = false;
            this.buscarQuestoes();
          })
          .catch(err => {
            console.log("Erro", err.response);
            vm.$toast.open({
              message: "Ocorreu um erro ao cadastrar, tente novamente mais tarde.",
              type: "error"
            });
          });
      } else {
        Http.put("questao-manager/questao/" + this.questao.idQuestao, this.questao)
          .then(res => {
            console.log("Sucesso", res);
            vm.$toast.open({
              message: "Registro atualizado com sucesso.",
              type: "success"
            });
            this.dialog = false;
            this.buscarQuestoes();
          })
          .catch(err => {
            console.log("Erro", err.response);
            vm.$toast.open({
              message: "Ocorreu um erro ao atualizar o registro, tente novamente mais tarde.",
              type: "error"
            });
          });
      }
    },
    cancelarModal() {
      this.dialog = false;
    }
  }
};
</script>

<style lang="scss" src="./Questoes.scss" scoped></style>

