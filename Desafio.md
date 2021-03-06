Gerenciador de contas. 


Faça uma API para gerenciar as terríveis contas que devemos pagar todos os meses. Essa API deve funcionar como um organizador, dessa forma ela vai permitir cadastrar, visualizar, atualizar e deletar contas do sistema (nosso famoso CRUD).


Cadastrando a conta: 
Toda conta do sistema deve ter:
tipo: ENUM
nome: String
valor: double
dataDeVencimento: LocalDate
dataDePagamento: LocalDateTime
status: ENUM

Para cadastrar uma conta a requisição deve seguir o seguinte padrão: 

Endpoint: /contas
Verbo HTTP: POST
corpo: 
{
      "nome": "ENEL",
      "valor": 190.00,
      "tipo": "LUZ",
      "dataDeVencimento": "2021-11-27"
}

a resposta deve ser: 
STATUS 201
corpo: 
{
      "id": 1,
      "nome": "ENEL",
      "valor": 190.00,
      "tipo": "LUZ",
      "dataDeVencimento": "2021-11-27",
      "dataDePagamento": null
      "status": "Aguardando"
}

 Os Enum;

O enum de Status deve conter as opções; AGUARDANDO, PAGO e VENCIDA;
O enum de Tipo deve conter as opções; LUZ, AGUA, COMIDA, LASER e OUTROS

Entrega Mínima: ✔CHECK

O sistema deve permitir que uma conta seja cadastrada no sistema.✔CHECK

Sempre que uma conta com a data de vencimento for anterior ao dia do cadastro 
será preenchido AUTOMATICAMENTE pelo sistema o STATUS VENCIDA, em todos os 
outros casos o STATUS padrão para as contas novas cadastradas é 
de AGUARDANDO.✔CHECK 

O Sistema também deve permitir visualizar a lista com todas as contas.✔CHECK
 
Essa lista deve conter apenas os campos ID, Nome, Valor, Status.✔CHECK 

Por fim, o sistema deve permitir fazer uma requisição para informar que a 
conta foi paga. ✔CHECK

Essa requisição deve seguir o seguinte padrão. 

Endpoint: /contas/{id}
Verbo HTTP: PUT
{
      "status":"PAGO"
}

a resposta: 
Status 200
{
      "id": 1,
      "nome": "ENEL",
      "valor": 190.00,
      "tipo": "LUZ",
      "dataDeVencimento": "2021-11-27",
      "dataDePagamento": “2021-11-10 10:00:00”
      "status": "PAGO"
}

IMPORTANTE: SEMPRE QUE UMA CONTA FOR PAGA O CAMPO dateDePagamento 
DEVE SER PREENCHIDA PELO SISTEMA ✔CHECK

Entrega MÉDIA✔CHECK

O sistema realiza todas as validações de campos obrigatórios 
para cadastrar uma conta. 
São eles; NOME, VALOR e TIPO ✔CHECK
O sistema responderá de forma coerente todos os erros de validação como 
por exemplo 422 para erros causados por validação ou 404 quando 
o cliente tentar atualizar uma conta que não existe. ✔CHECK 

Para isso será necessário o controller advice. ✔CHECK

O sistema também permitirá visualizar uma conta específica 
com todos os detalhes.✔CHECK 

IMPORTANTE: Entrega média válida APENAS se a mínima estiver perfeita.
Entrega Maxima.

O sistema deve permitir que sejam feitos alguns filtros na lista de contas. 

1 - filtro de contas por status ✔CHECK
2 - filtro de contas por tipo ✔CHECK
3 - filtro de contas com valor APROXIMADO 
(use o @QUERY é bem mais fácil para fazer isso) 

Por fim, o sistema deve permitir DELETAR uma conta caso seja necessário. A requisição deve seguir o seguinte padrão. 

Endpoint: /contas/{id}
Verbo HTTP: DELETE

Resposta Status 204

IMPORTANTE: Entrega máxima válida APENAS se a média estiver perfeita.
