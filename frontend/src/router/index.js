import Vue from 'vue'
import VueRouter from 'vue-router'
import Header from "@/components/base/Header.vue";
import admRotas from "./administrativo-rotas"
import alunoRotas from "./aluno-rotas"

Vue.use(VueRouter)
  const routes = [
  {
    path: '/',
    name: 'Login',
    component: () => import('../views/Login.vue')
  },
  {
    path: '/home',
    name: 'Home',
    components: {
      header: Header,
      default: () => import('../views/Home.vue'),
    },
  },
  ...admRotas,
  ...alunoRotas
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
