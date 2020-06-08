package trabalho.ces.trabalho.ces.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import trabalho.ces.trabalho.ces.backend.models.TipoQuestao;
import trabalho.ces.trabalho.ces.backend.repositories.TipoQuestaoRepository;

import java.util.List;

@RestController
@RequestMapping("tipoquestao-manager")
public class TipoQuestaoController {

    @Autowired
    TipoQuestaoRepository tipoQuestaoRepository;

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/tiposquestao")
    public List<TipoQuestao> BuscarTiposQuestao(){
        return tipoQuestaoRepository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/tipoquestao/{id}")
    public TipoQuestao BuscarTipoQuestao(@PathVariable(value="id") Integer id){
        return tipoQuestaoRepository.findById(id);
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping("/tipoquestao")
    public TipoQuestao InserirTipoQuestao(@RequestBody TipoQuestao tipoQuestao) {
        return tipoQuestaoRepository.save(tipoQuestao);
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @DeleteMapping("/usuario/{id}")
    public void RemoverTipoQuestao(@PathVariable(value="id") long id){
        tipoQuestaoRepository.deleteById(id);
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @PutMapping("/tipoquestao")
    public void AtualizaTipoQuestao(@RequestBody TipoQuestao tipoQuestao) {
        tipoQuestaoRepository.save(tipoQuestao);
    }

}
