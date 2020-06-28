import Vue from 'vue'
import VueRouter from 'vue-router'
import Header from "@/components/base/Header.vue";
import admRotas from "./administrativo-rotas"
import alunoRotas from "./aluno-rotas"

Vue.use(VueRouter)
const routes = [
  {
    path: '/login',
    name: 'Login',
    component: () => import('../views/Login.vue')
  },
  {
    path: '/',
    name: 'Home',
    components: {
      header: Header,
      default: () => import('../views/Home.vue'),
    },
  },
  {
    path: '/sobre',
    name: 'sobre',
    components: {
      header: Header,
      default: () => import('../views/Sobre.vue'),
    },
  },
  {
    path: '/404',
    name: '404',
    components: {
      default: () => import('../views/404.vue'),
    },
  },
  ...admRotas,
  ...alunoRotas,
  { path: '*', redirect: '/404' }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

router.beforeEach((to, from, next) => {
  const logado = localStorage.getItem('usuario');
  const usuario = JSON.parse(logado)

  const publicas = ['/login', '/cadastrar-usuario'];
  const userRotas = ['/', '/questionario'];

  let rotaPublica = publicas.includes(to.path);
  let semAutorizacao = false;

  if (logado && usuario.idTipoUsuario == 2) {
    semAutorizacao = !userRotas.includes(to.path);
  }

  if (!rotaPublica && !logado) {
    return next('/login');
  }

  if (semAutorizacao && logado) {
    return next('/');
  }

  next();
})

export default router
