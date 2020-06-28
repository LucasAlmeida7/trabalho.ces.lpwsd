<template src="./GraficoResultados.html"></template>

<script>
import vm from "vue";
import Http from "@/plugins/axios";
import graficoResultado from "@/components/ui/GraficoResultado.vue";

export default {
  name: "grafico-resultados",
  components: {
    graficoResultado
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
