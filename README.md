# TestesCondominio

  Projeto desenvolvido para TownSQ com intuito de testar uma nova feature chamada "fila de espera".
  O projeto foi elaborado via BDD, acessando o arquivo "BDD Town.txt", dá para visualizar os casos de testes utilizados no projeto.
Para rodá-lo, deve-se inicialmente ter o Java 11 instalado, após a instalção, deve-se acessar a classe TestesCondominioApplicationTest na pasta src/test/java e dar Run na classe para rodar todos os testes ou rodar um teste escolhido dentro da própria classe.
  O projeto conta com log na pasta log4j, basta acessar o arquivo log.out.

1. para o problema acima,

- que tipo de teste(s) você teria feito para evitar o problema de reservas enfrentado pelo TownSq?
  
  Foram criados 4 tipos de testes: Teste para gerar uma reserva; teste para gerar um conflito de reserva; teste para se inscrever na fila de espera; teste para gerar uma reserva a partir da fila de espera.

- que tipo de cenários de testes você faria para a funcionalidade de Reservas?
  
  Os cenários foram descritos acima, validando tanto a funcionalidade de reserva quanto a fila de espera.
  
2. para a realização da tarefa de testes/qualidade,

- que abordagem você utilizou para testar a aplicação (tipos de testes que você
escolheu, funcionalidades que você testou, critérios que você utilizou para testar, etc.)?
  
  Escolhi a abordagem BDD para criar cenários de testes, e os critérios escolhidos foram: Se a função foi implementada corretamente e se a função faz o que deveria fazer.

- ferramentas que você utilizou ?
  
  Foi utilizada a linguagem gherkin para criar os cenários, foi utilizado selenium para desenvolver os testes automatizados e o log4j para gerar os logs.
- caso opte por escrever testes automatizados, que tecnologias que você escolheu?
  
  Respondido na pergunta acima, foi utilizado selenium em Java.
