import Header from "@/components/base/Header.vue";

const routes = [
    {
        path: '/cadastrar-usuario',
        name: 'CadastrarUsuario',
        components: {
            default: () => import('../views/aluno/CadastrarUsuario.vue')
        },
    },
    {
        path: '/questionario',
        name: 'Questionario',
        components: {
            header: Header,
            default: () => import('../views/aluno/Questionario.vue')
        },
    }
]

export default routes;
