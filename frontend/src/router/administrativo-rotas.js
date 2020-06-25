import Header from "@/components/base/Header.vue";

const routes = [
    {
        path: '/questoes',
        name: 'Questoes',
        components: {
            header: Header,
            default: () => import('../views/administrativo/Questoes.vue')
        },
    },
    {
        path: '/provas',
        name: 'Provas',
        components: {
            header: Header,
            default: () => import('../views/administrativo/Provas.vue')
        },
    },
    {
        path: '/provas/gerenciar',
        name: 'Gerenciar Prova',
        components: {
            header: Header,
            default: () => import('../views/administrativo/GerenciarProva.vue')
        },
    }
]

export default routes;
