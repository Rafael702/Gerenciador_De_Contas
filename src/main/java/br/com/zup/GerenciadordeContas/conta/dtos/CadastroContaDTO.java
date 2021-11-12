package br.com.zup.GerenciadordeContas.conta.dtos;

import br.com.zup.GerenciadordeContas.conta.enuns.Tipo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CadastroContaDTO {
    @Size(min = 2, max = 30, message = "O Nome Deve conter no minimo 2 Caracteres")
    @NotBlank(message = "Nome é um campo que obrigatoriamente deve ser preenchido.")
    private String nome;
    @Min(value = 1, message = "O Valor desta conta deve ser de no minimo $1,00")
    @NotNull(message = " Valor é um campo que obrigatoriamente deve ser preenchido.")
    private double valor;
    @NotNull(message = "Tipo é um campo que obrigatoriamente deve ser preenchido.")
    private Tipo tipo;
    @NotNull(message = "Data de Vencimento é um campo que obrigatoriamente deve ser preenchido.")
    private LocalDate dataDeVencimento;
}
