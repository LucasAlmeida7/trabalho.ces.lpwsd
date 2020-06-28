<script>
import vm from "vue";
import Http from "@/plugins/axios";
// eslint-disable-next-line no-unused-vars
import { Doughnut, mixins } from "vue-chartjs";

export default {
  extends: Doughnut,
  props: {
    idProva: {
      required: true
    },
  },
  data() {
    return {
      data: [],
      options: {
        borderWidth: "10px",
        hoverBackgroundColor: "red",
        hoverBorderWidth: "10px"
      },
    };
  },
  mounted() {
    this.buscarDados();
  },
  methods: {
    buscarDados() {
      Http.get("grafico-manager/porcentagem-completo/" + this.idProva, {})
        .then(result => {
          if (result.data != "") {
            this.data = [result.data.concluido, result.data.pendente];
            this.renderChart(this.datacollection, this.options);
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
  },
  computed: {
    datacollection() {
      return {
        hoverBackgroundColor: "red",
        hoverBorderWidth: 10,
        labels: ["Concluído %", "Pendente %"],
        datasets: [
          {
            label: "Data One",
            backgroundColor: ["#00D8FF", "#E46651"],
            data: this.data
          }
        ]
      };
    }
  },
  watch: {
    idProva(){
      this.buscarDados();
    }
  }
};
</script>