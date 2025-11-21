# EduGestor - CRM Educacional

## Tecnologias 🖥️
<ul>
    <li>Java 17
    <li>Spring Boot 3.5.8
    <li>JPA (Hibernate)
    <li>MySQL
</ul>

## Como testar o projeto 🚀

### Pré-requisitos

Antes de iniciar o projeto, é necessário baixar os itens a seguir:
<ul>
    <li>JDK 17
    <li>Git
    <li>Banco de dados MySQL
</ul>

### Clonando

Primeiro clone o projeto para uma pasta da sua máquina:

```bash
git clone https://github.com/MarcosHenriqueFr/EduGestor
```
Depois entre na pasta criada:

```bash 
cd EduGestor
```

### Configurando as variáveis de ambiente

#### Importante lembrar: 
O projeto não usa nenhuma configuração de WebSecurity Config, então não tem realmente um sistema de autenticação no login
que controle o mapeamento de ENDPOINTS.

#### 1. application.properties

Dentro de `backend/src/main/resources` configure  `application.properties` de acordo com seu banco.
**É muito importante que você TENHA UM BANCO DE DADOS CRIADO.**
<br>
Se preferir, pode usar o arquivo que já está presente no repositório do projeto. Basta lembrar de remapeaar a porta para o seu server MySQL.
```bash
spring.application.name=edugestor

spring.datasource.url=jdbc:mysql://localhost:3306/[Seu banco]
spring.datasource.username=[Seu usuario]
spring.datasource.password=[Sua senha]
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

spring.thymeleaf.prefix=classpath:/templates/
spring.thymeleaf.suffix=.html
spring.thymeleaf.mode=HTML
spring.thymeleaf.encoding=UTF-8
spring.thymeleaf.cache=false

# Caso prefira pode remover essas informações do log
logging.level.org.springframework.web=DEBUG
logging.level.org.thymeleaf=DEBUG
```

### Começando o projeto

Agora é só rodar o projeto, o maven precisa estar instalado globalmente:
Ou use uma IDE de sua preferência.

```bash
mvn spring-boot:run
```

Caso não possua o maven digite:
```bash
./mvnw spring-boot:run
```

Para testar o sistema **basta usar o seu navegador mapeando para a porta padrão 8080.**
<br> <br>
**ATENÇÃO!!!** Como o projeto não tem mapeamento para cursos é necessário que
você crie manualmente alguns cursos de exemplo antes de criar novos alunos.
<br>
Então abra seu cliente MySQL (Workbench, terminal, etc...) e use como exemplo esse seguinte comando:
```SQL
INSERT INTO cursos(categoria, nome, curso) values('GRADUACAO', 'Administração', 'MATUTINO');
```


## Endpoints 🚩

| Endpoint                           | Descrição                                          
|------------------------------------|-----------------------------------------------------
| <kbd>GET / </kbd>                  | Mostra a página de cadastro
| <kbd>GET /home  </kbd>             | Mostra a página da home
| <kbd>GET /usuario/perfil  </kbd>   | Mostra a página de perfil com dados da Sessão
| <kbd>GET /alunos  </kbd>           | Mostra a página com uma lista dos alunos cadastrados
| <kbd>GET /alunos/novo   </kbd>     | Mostra a página para o cadastro de um novo usuário em um curso
| <kbd>POST /alunos   </kbd>         | Cria um novo usuário no banco
| <kbd>POST /auth/cadastro    </kbd> | Cria um novo usuário (Funcionário)

Link do repositório: https://github.com/MarcosHenriqueFr/EduGestor

**Obrigado pela sua atenção. Qualquer feedback é bem-vindo!**