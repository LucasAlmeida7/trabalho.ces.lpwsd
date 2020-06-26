package trabalho.ces.trabalho.ces.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import trabalho.ces.trabalho.ces.backend.enums.FiltroQuestaoEnum;
import trabalho.ces.trabalho.ces.backend.services.GraficoService;
import trabalho.ces.trabalho.ces.backend.viewmodels.Grafico.OutputGraficoResultadoViewModel;
import trabalho.ces.trabalho.ces.backend.viewmodels.Questao.GridQuestaoViewModel;

import java.util.List;

@RestController
@RequestMapping("grafico-manager")
public class GraficoController {

    @Autowired
    GraficoService graficoService;

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/resultados")
    public List<OutputGraficoResultadoViewModel> UltimosResultados(){
        return graficoService.UltimosResultados();
    }
}
