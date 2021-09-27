# estactionamento-web-api

## Título: Projeto de teste utilizando Spring Boot e AngularJS.
## Descrição: O sistema simula o gerenciamento de um estacionamento.
## Autor: Filipe Oliveira

## Instruções para executar:
  -Para executar o 'estacionament-api' - utilize o maven e de preferencia em conjunto com a IDE STS (Spring Tools Suite). É necessário ter o java instalado nas versões 11+.
  -Para executar o 'estacionament-web' é necessário ter o nodejs e npm instalados no computador, assim como também o angular Js. Execute *npm install* e *npm start* para executar.

### Entidades envolvidas:
  -Cliente;
  -Veículo;
  -Rotativo.

### Técnologias: 
      Backend: Spring Boot;
      FrontEnd: AngularJS.

### Rotas da API:
      Cliente:
        GET: /clientes
             /clientes/{id}
        POST: /clientes
        DELETE: /clientes/{id}
        PUT: /clientes/{id}

### Veículo:
      GET: /veiculos
           /veiculos/{id}
      POST: /veiculos
      DELETE: /veiculos/{id}
      PUT: /veiculos/{id}

### Rotativo:
      GET: /rotativos
           /rotativos/{filterEstacionados}
           /rotativos/{placa}/{idCliente}
      POST: //rotativos
      DELETE: /rotativos/{placa}/{idCliente}
      PUT: /rotativos/{placa}/{idCliente}



