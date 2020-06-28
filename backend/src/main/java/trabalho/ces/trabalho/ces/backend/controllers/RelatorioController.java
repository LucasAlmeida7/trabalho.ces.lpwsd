package trabalho.ces.trabalho.ces.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import trabalho.ces.trabalho.ces.backend.services.RelatorioService;
import trabalho.ces.trabalho.ces.backend.viewmodels.Relatorio.OutputRelatorioResultadoViewModel;
import trabalho.ces.trabalho.ces.backend.viewmodels.Usuario.OutputUsuarioViewModel;

import java.util.List;

@RestController
@RequestMapping("relatorio-manager")
public class RelatorioController {

    @Autowired
    RelatorioService relatorioService;

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/ultimos-resultados/{id}")
    public List<OutputRelatorioResultadoViewModel> UltimosResultados(@PathVariable(value="id") Integer id){
        return relatorioService.BuscarResultados(id);
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/alunos")
    public List<OutputUsuarioViewModel> BuscarAlunos(){
        return relatorioService.BuscarAlunos();
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/alunos-pendentes/{id}")
    public List<OutputUsuarioViewModel> BuscarPendentes(@PathVariable(value="id") Integer id){
        return relatorioService.AlunosPendentes(id);
    }
}
