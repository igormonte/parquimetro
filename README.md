# [FIAP][TECH-CHALENGE] PARQUIMETRO

É um projeto desenvolvido pela FIAP como parte do desafio técnico. O objetivo do projeto é criar um sistema de parquímetro inteligente que facilite o pagamento e controle do estacionamento nas cidades. O sistema utiliza tecnologias avançadas para oferecer uma experiência conveniente e eficiente aos usuários, permitindo o pagamento através de aplicativo móvel, cartão de crédito ou dinheiro. Além disso, o parquímetro é equipado com sensores e câmeras para monitorar a ocupação das vagas de estacionamento e detectar violações. Com o [FIAP][TECH-CHALENGE] PARQUIMETRO, a gestão do estacionamento se torna mais ágil e eficaz, proporcionando uma solução inovadora para os desafios urbanos relacionados ao estacionamento.

## DEPLOY DO PROJETO

### Deploy através do Docker:

```
//Execute o comando de build do projeto
mvn package -B -DskipTest


//Execute o comando do compositor docker
docker compose up
```

### Execução localmente:

- O projeto pode ser executado localmente:
    - Certifique-se que o arquivo de propriedades da aplicação está com o profile “dev”.
    - Realize a criação da tabela “parquimetro” em uma instância do banco “Postgres”, libere a porta padrão do banco para ser acessível.
    - Execute o projeto localmente.
