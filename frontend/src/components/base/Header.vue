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
    cadastrarQuestao() {
      router.push("questoes");
    }
  }
};
</script>