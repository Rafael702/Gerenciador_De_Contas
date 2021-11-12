package br.com.zup.GerenciadordeContas.conta.controller;

import br.com.zup.GerenciadordeContas.conta.Conta;
import br.com.zup.GerenciadordeContas.conta.dtos.CadastroContaDTO;
import br.com.zup.GerenciadordeContas.conta.dtos.ContaSaidaDTO;
import br.com.zup.GerenciadordeContas.conta.servico.ContaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    private ContaService contaService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContaSaidaDTO cadastrarConta(@RequestBody CadastroContaDTO contaDTO) {
        Conta conta = modelMapper.map(contaDTO, Conta.class);
        contaService.salvarConta(conta);
        return modelMapper.map(conta, ContaSaidaDTO.class);
    }
}
