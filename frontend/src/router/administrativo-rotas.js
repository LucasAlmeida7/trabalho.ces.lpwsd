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
    },
    {
        path: '/grafico/resultados',
        name: 'Gráfico Resultados',
        components: {
            header: Header,
            default: () => import('../views/administrativo/graficos/GraficoResultados.vue')
        },
    },
    {
        path: '/grafico/pendentes',
        name: 'Gráfico Pendentes',
        components: {
            header: Header,
            default: () => import('../views/administrativo/graficos/GraficoPendentes.vue')
        },
    }
]

export default routes;
