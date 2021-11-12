package br.com.zup.GerenciadordeContas.conta.controller;

import br.com.zup.GerenciadordeContas.conta.Conta;
import br.com.zup.GerenciadordeContas.conta.dtos.CadastroContaDTO;
import br.com.zup.GerenciadordeContas.conta.dtos.ContaAtualizadaDTO;
import br.com.zup.GerenciadordeContas.conta.dtos.ContaSaidaDTO;
import br.com.zup.GerenciadordeContas.conta.dtos.ResumoContaDTO;
import br.com.zup.GerenciadordeContas.conta.enuns.Status;
import br.com.zup.GerenciadordeContas.conta.servico.ContaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    private ContaService contaService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContaSaidaDTO cadastrarConta(@RequestBody @Valid CadastroContaDTO contaDTO) {
        Conta conta = modelMapper.map(contaDTO, Conta.class);
        contaService.salvarConta(conta);
        return modelMapper.map(conta, ContaSaidaDTO.class);
    }

    @GetMapping
    public List<ResumoContaDTO> exibirContasCadastradas() {
        List<ResumoContaDTO> listaDeContas = new ArrayList<>();

        for (Conta referencia : contaService.exibirTodasAsContas()) {
            ResumoContaDTO resumoContaDTO = modelMapper.map(referencia, ResumoContaDTO.class);
            listaDeContas.add(resumoContaDTO);
        }
        return listaDeContas;
    }

    @PutMapping("/{id}")
    public ContaSaidaDTO atualizarConta(@PathVariable int id, @RequestBody ContaAtualizadaDTO atualizarContaDTO) {
        Conta conta = contaService.atualizarConta(id);
        conta.setStatus(atualizarContaDTO.getStatus());

        if (conta.getStatus().equals(Status.PAGO)) {
            return modelMapper.map(conta, ContaSaidaDTO.class);
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Esta opção é para pagar contas apenas");
    }
}
