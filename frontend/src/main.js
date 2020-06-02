import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import VueToast from './plugins/toast'
import vuetify from './plugins/vuetify'

import './plugins/axios'

Vue.config.productionTip = false

new Vue({
  router,
  store,
  VueToast,
  vuetify,
  render: h => h(App)
}).$mount('#app')
