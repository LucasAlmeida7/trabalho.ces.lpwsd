import Vue from 'vue'
import VueRouter from 'vue-router'
import Header from "@/components/base/Header.vue";

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
  {
    path: '/cadastrar-usuario',
    name: 'CadastrarUsuario',
    components: {
      default: () => import('../views/aluno/CadastrarUsuario.vue')
    },
  },
  {
    path: '/questoes',
    name: 'Questoes',
    components: {
      header: Header,
      default: () => import('../views/administrativo/Questoes.vue')
    },
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
