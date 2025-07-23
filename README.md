# 📧 E-mail Microservice - SendGift
Este microserviço é responsável pelo envio de e-mails relacionados à funcionalidade principal da aplicação SendGift, permitindo notificações automáticas para os usuários que enviam ou recebem presentes. Faz parte de um [projeto pessoal de estudos](https://github.com/bragabriel/project-sendgift) para aplicar conceitos e ferramentas de nível intermediário-avançado no desenvolvimento de APIs e microserviços.

## ✨ Funcionalidade
Quando um usuário envia um presente, ele recebe um e-mail de confirmação informando que o presente foi enviado com sucesso ao destinatário.

Quando um usuário recebe um presente, ele recebe um e-mail notificando que foi presenteado, com a data do envio e o nome do remetente.

## 🧩 Arquitetura
Este serviço segue os princípios da Arquitetura Hexagonal (Ports & Adapters), promovendo uma separação clara entre as regras de negócio e a infraestrutura (como o provedor de e-mail). Isso facilita testes, manutenção e evolução.

Além disso, foram utilizados:

OpenFeign para comunicação entre os serviços.

Amazon Simple Email Service (AWS SES) como solução de envio de e-mails.

## ⚙️ Tecnologias e Ferramentas
- Java 21
- Spring Boot 3.2
- Spring Cloud / OpenFeign
- Arquitetura Hexagonal
- AWS SES (Simple Email Service)
- Testes com JUnit e Mockito

## 📬 Integrações
Este microserviço é consumido pela aplicação principal SendGift, que aciona o envio de e-mails ao detectar eventos de envio ou recebimento de presentes.

## Testes
Cobertura com JUnit e Mockito. Mock de chamadas externas (AWS SES e Feign).
