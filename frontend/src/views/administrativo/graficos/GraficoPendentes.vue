<template src="./GraficoPendentes.html"></template>

<script>
import graficoPendente from "@/components/ui/GraficoPendente.vue";
import vm from "vue";
import Http from "@/plugins/axios";

export default {
  name: "grafico-pendentes",
  components: {
    graficoPendente
  },
  data() {
    return {
      idProva: 0,
      provas: []
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
    }
  }
};
</script>
