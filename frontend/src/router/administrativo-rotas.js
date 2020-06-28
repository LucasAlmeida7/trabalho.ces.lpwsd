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
    },
    {
        path: '/relatorio/relatorio-alunos',
        name: 'Relatório Alunos',
        components: {
            header: Header,
            default: () => import('../views/administrativo/relatorios/RelatorioAlunos.vue')
        },
    },
    {
        path: '/relatorio/relatorio-pendentes',
        name: 'Relatório Alunos Pendentes',
        components: {
            header: Header,
            default: () => import('../views/administrativo/relatorios/RelatorioPendentes.vue')
        },
    },
    {
        path: '/relatorio/relatorio-resultados',
        name: 'Relatório Resultados',
        components: {
            header: Header,
            default: () => import('../views/administrativo/relatorios/RelatorioResultados.vue')
        },
    },
]

export default routes;
