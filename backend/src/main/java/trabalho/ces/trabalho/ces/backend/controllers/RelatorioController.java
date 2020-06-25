package trabalho.ces.trabalho.ces.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import trabalho.ces.trabalho.ces.backend.services.RelatorioService;

@RestController
@RequestMapping("relatorio-manager")
public class RelatorioController {

    @Autowired
    RelatorioService relatorioService;

}
