<script>
import vm from "vue";
import Http from "@/plugins/axios";
import { Bar } from "vue-chartjs";

export default {
  name: "grafico-resultado",
  extends: Bar,
  props: {
    label: {
      type: String,
      required: true
    },
    barColor: {
      type: String,
      default: "#272424"
    },
    idProva: {
      required: true
    },
  },
  data() {
    return {
      labels: [],
      data: [],

      options: {
        scales: {
          yAxes: [
            {
              ticks: {
                beginAtZero: true
              },
              gridLines: {
                display: true
              }
            }
          ],
          xAxes: [
            {
              gridLines: {
                display: false
              }
            }
          ]
        },
        legend: {
          display: true
        },
        responsive: true,
        maintainAspectRatio: false
      }
    };
  },
  mounted() {
    this.buscarDados();
  },
  methods: {
    buscarDados() {
      Http.get("grafico-manager/ultimos-resultados/" + this.idProva, {})
        .then(result => {
          if (result.data != "") {
            this.labels = result.data.map(
              x => "Prova " + x.idProva + " | " + x.nomeUsuario
            );
            this.data = result.data.map(x => x.resultadoPorcentagem);
          }
          else{
            this.labels = [];
            this.data = [];
          }
          this.renderChart(this.datacollection, this.options);
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
        labels: this.labels,
        datasets: [
          {
            label: this.label,
            backgroundColor: this.barColor,
            pointBackgroundColor: "white",
            borderWidth: 1,
            pointBorderColor: "#249EBF",
            data: this.data
          }
        ]
      };
    }
  },
  watch: {
    idProva() {
      this.buscarDados();
    }
  }
};
</script>