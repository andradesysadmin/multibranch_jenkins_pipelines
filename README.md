<div align="center">
<h1> Pipeline CI/CD multibranch com Jenkins, Docker e Deploy na AWS 🤵🏻‍♂️🐳</h1>  <br>

<img src="https://www.jenkins.io/images/logos/jenkins/jenkins.svg" align="center" />

Este projeto foi desenvolvido como base em uma tarefa que recebi em minha atual empresa, a tarefa consistia em criar pipelines de deploy automático para múltiplas APIs em Node.js e frontends em React, com integração e entrega contínuas (CI/CD) na AWS. A demanda foi para a criação de pipelines distintas para cada serviço, e para organizar esse processo de maneira escalável, optei por centralizar todos os Jenkinsfiles em um único repositório, utilizando múltiplas ramificações (branches).

Com isso, consegui implementar uma solução eficiente e modular que facilita a manutenção e evolução das pipelines para diferentes microserviços, garantindo uma automação robusta e ágil em cada fase do ciclo de vida do software.


</div>

<h2>Stack</h2>
## Tecnologias Utilizadas:
- **Jenkins**: Automação de integração e entrega contínuas (CI/CD), com pipelines configuradas para múltiplas ramificações.
- **Docker**: Contêineres para garantir ambientes isolados e reprodutíveis durante os processos de build e deploy.
- **Git**: Controle de versão para gerenciar o código-fonte e as diversas branches das APIs e frontends.
- **Groovy**: Linguagem usada nos Jenkinsfiles para definir as pipelines e orquestrar os processos de build, testes e deploy.
- **Jest**: Framework de testes para garantir a qualidade do código, utilizado principalmente nas APIs Node.js e no frontend React.


- **Jenkins**: Automação de integração e entrega contínuas (CI/CD), com pipelines configuradas para múltiplas ramificações.
- **Docker**: Contêineres para garantir ambientes isolados e reprodutíveis durante os processos de build e deploy.
- **Git**: Controle de versão para gerenciar o código-fonte e as diversas branches das APIs e frontends.
- **Groovy**: Linguagem usada nos Jenkinsfiles para definir as pipelines e orquestrar os processos de build, testes e deploy.
- **Jest**: Framework de testes para garantir a qualidade do código, utilizado principalmente nas APIs Node.js e no frontend React.
