package br.com.zup.GerenciadordeContas.conta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    private ContaServico contaServico;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarConta(Conta conta) {
        contaServico.salvarConta(conta);
    }
}
