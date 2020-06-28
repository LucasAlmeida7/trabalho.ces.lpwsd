package trabalho.ces.trabalho.ces.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import trabalho.ces.trabalho.ces.backend.services.GraficoService;
import trabalho.ces.trabalho.ces.backend.viewmodels.Grafico.OutputGraficoResultadoViewModel;
import trabalho.ces.trabalho.ces.backend.viewmodels.Resultado.OutputResultadoProvaViewModel;

import java.util.List;

@RestController
@RequestMapping("grafico-manager")
public class GraficoController {

    @Autowired
    GraficoService graficoService;

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/ultimos-resultados/{id}")
    public List<OutputGraficoResultadoViewModel> UltimosResultados(@PathVariable(value="id") Integer id){
        return graficoService.UltimosResultados(id);
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/porcentagem-completo/{id}")
    public OutputResultadoProvaViewModel BuscarUsuario(@PathVariable(value="id") Integer id){
        return graficoService.Pendentes(id);
    }
}
