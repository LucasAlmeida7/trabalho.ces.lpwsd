<template src="./Header.html"></template>

<script>
import router from "@/router";

export default {
  name: "HeaderApp",
  data() {
    return {
      drawer: false
    };
  },
  methods: {
    home() {
      router.push("home");
    },
    gerenciarQuestao() {
      router.push("questoes");
    },
    gerenciarProvas() {
      router.push("provas");
    },
    acessarQuestionario() {
      router.push("questionario");
    }
  }
};
</script>