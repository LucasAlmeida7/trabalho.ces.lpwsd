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
        { text: "Tipo Questão", value: "nomeTipoQuestao" },
        { text: "Ações", value: "actions", sortable: false, align: "center" }
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
      msgErro: {
        descricaoQuestaoErro: "",
        alternativaAErro: "",
        alternativaBErro: "",
        alternativaCErro: "",
        alternativaDErro: "",
        alternativaEErro: ""
      },
      estadoSelecionado: "",
      estados: [
        { value: 1, text: "Ativada" },
        { value: 2, text: "Desativada" }
      ],
      tiposQuestao: [
        { value: 1, text: "Objetiva" },
        { value: 2, text: "Discursiva" }
      ],
      bloquearCampos: false
    };
  },
  created() {
    this.buscarQuestoes();
  },
  methods: {
    buscarQuestoes() {
      Http.get("questao-manager/questoes/todas", {})
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
            message:
              "Ocorreu um erro ao acessar os dados, tente novamente mais tarde.",
            type: "error"
          });
        });
    },
    salvarModal() {
      if (!this.validarEntrada()) return;

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
              message:
                "Ocorreu um erro ao cadastrar, tente novamente mais tarde.",
              type: "error"
            });
          });
      } else {
        Http.put(
          "questao-manager/questao/" + this.questao.idQuestao,
          this.questao
        )
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
              message:
                "Ocorreu um erro ao atualizar o registro, tente novamente mais tarde.",
              type: "error"
            });
          });
      }
    },
    cancelarModal() {
      this.dialog = false;
    },
    validarEntrada() {
      let count = 0;

      if (this.questao.descricaoQuestao == "") {
        this.msgErro.descricaoQuestaoErro = "Informe a descrição da questão";
        count++;
      }

      if (this.questao.idTipoQuestao == 1) {
        if (this.questao.alternativaA == "") {
          this.msgErro.alternativaAErro = "Informe a alternativa A";
          count++;
        }

        if (this.questao.alternativaB == "") {
          this.msgErro.alternativaBErro = "Informe a alternativa B";
          count++;
        }

        if (this.questao.alternativaC == "") {
          this.msgErro.alternativaCErro = "Informe a alternativa C";
          count++;
        }

        if (this.questao.alternativaD == "") {
          this.msgErro.alternativaDErro = "Informe a alternativa D";
          count++;
        }

        if (this.questao.alternativaE == "") {
          this.msgErro.alternativaEErro = "Informe a alternativa E";
          count++;
        }
      }

      return count == 0;
    }
  },
  computed: {
    habilitarCampo() {
      return this.questao.idTipoQuestao == 2;
    }
  },
  watch: {
    habilitarCampo(habilitado) {
      if (habilitado) {
        this.questao.alternativaA = "";
        this.questao.alternativaB = "";
        this.questao.alternativaC = "";
        this.questao.alternativaD = "";
        this.questao.alternativaE = "";
      }
    }
  }
};
</script>

<style lang="scss" src="./Questoes.scss" scoped></style>

