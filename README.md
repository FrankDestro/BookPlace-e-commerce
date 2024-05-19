# BookPlace E-commerce

[![NPM](https://img.shields.io/npm/l/react)](https://github.com/FrankDestro/SupportService-v3.0?tab=MIT-1-ov-file) 

# About Project / Sobre o projeto

https://bookplace.com - ainda não implementado

O BookPalce é um sistema de e-commerce desenvolvido para facilitar a venda e compra de livros online. Com uma interface intuitiva e recursos avançados, o BookPalce oferece uma experiência de compra conveniente e segura para os amantes da leitura.

Principais Recursos:
1. Catálogo de Livros: O sistema possui um amplo catálogo de livros, organizados por gênero, autor e outros critérios de pesquisa.
2. Gestão de Estoque: Permite o controle eficiente do estoque de livros, garantindo que os itens estejam sempre atualizados e disponíveis para compra.
3. Carrinho de Compras: Os usuários podem adicionar livros ao carrinho de compras e revisar seus pedidos antes de finalizar a compra.
4. Integração com API de Pagamento: O sistema está integrado com a API da PagSeguro para processamento seguro e confiável de pagamentos.
5. Gerenciamento de Pedidos: Os administradores podem acompanhar e gerenciar os pedidos dos clientes, incluindo status de entrega e histórico de transações.
6. Sistema de Autenticação e Autorização: Implementa um sistema de autenticação seguro para usuários e administradores, garantindo que apenas usuários autorizados tenham acesso às funcionalidades do sistema.
7. Design Responsivo: O sistema possui um design responsivo que se adapta a diferentes dispositivos e tamanhos de tela, proporcionando uma experiência de usuário consistente em desktops, tablets e smartphones.

## Layout web Login
![Login](https://github.com/FrankDestro/Imagens-Readme/blob/main/loginmobile.png)

## Layout - Catálogo Produtos
![catalogo](https://github.com/FrankDestro/Imagens-Readme/blob/main/catalogo.png)

## Layout - Detalhes do Produto
![DetailsProduct](https://github.com/FrankDestro/Imagens-Readme/blob/main/details.png)

## Layout - Carrinho de compras
![cart](https://github.com/FrankDestro/Imagens-Readme/blob/main/cart.png)

## Layout - Payment
![payment](https://github.com/FrankDestro/Imagens-Readme/blob/main/payment.png)

## Modelo conceitual

![Modelo Conceitual](https://github.com/FrankDestro/Imagens-Readme/blob/main/modeloConceituralBook.png)

# Tecnologias utilizadas
## Back end
- Java 21
- Spring Boot versão 3.0
- JPA / Hibernate
- Maven
- OAuth 2.0
- Swagger
- Integração API PagSeguro (processamento de pagamentos - Boleto, PIX, Cartão de Credito.)
## Front end
- HTML5 / CSS3 / Javascript / TypeScript
- ReactJS 18.0
- Vite
- Tailwind CSS
- Bootstrap 5.3
## Implantação Homologação 
- Backend (API) - Docker 24.0
- FrontEnd : ....
- Banco de dados: Postgresql com Docker compose em um ambiente de WSL Linux Ubuntu 22.04

# Como executar o projeto

## Back end
Pré-requisitos: Java 11 - Desenvolvido na IDE intellij

```bash
# clonar repositório
git clone https://github.com/FrankDestro/BookPlace-e-commerce

# entrar na pasta do projeto back end
cd book\BookPlace\BookPlace

# Abrir pelo Intellij ou IDE de preferência.
```

## Front end web
Pré-requisitos: npm / yarn - desenvolvido com React JS 18.0

```bash
# clonar repositório
git clone https://github.com/FrankDestro/BookPlace-e-commerce

# entrar na pasta do projeto front end web
cd book\frontend

# instalar dependências
yarn install

# abrir projeto no Visual Code 
code . 

# executar o projeto
yarn dev 
```

# Autor

Franklyn Destro Damaceno.
https://www.linkedin.com/in/franklyn-damaceno-441baa143/

