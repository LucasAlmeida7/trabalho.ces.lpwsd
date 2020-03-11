import Vue from 'vue'
import Vuetify from 'vuetify'
import 'vuetify/dist/vuetify.min.css'
import * as variables from "@/assets/styles/variables.scss";
import "@mdi/font/css/materialdesignicons.css";

const vuetify = new Vuetify({
    iconfont: "md",
    theme: {
      themes: {
        light: {
          primary: variables.primary,
          secondary: variables.secondary,
          accent: variables.accent,
          error: variables.error,
          warning: variables.warning,
          info: variables.info,
          success: variables.success
        },
        dark: {
          primary: variables.primary,
          secondary: variables.secondary,
          accent: variables.accent,
          error: variables.error,
          warning: variables.warning,
          info: variables.info,
          success: variables.success
        }
      }
    }
  });

Vue.use(Vuetify)

export default vuetify;