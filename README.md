## Descrição
TodoList

Para realização da implementação do sistema de uma TodoList foi realizada uma análise do que poderia ser feito. De forma geral, 
o que deve ser feito no sistema está descrito como requisito. Algumas regras mais específicas foram descritas, 
assim como restrições impostas ao sistema.

## Requisitos

### Usuário
- [ ] [R01] O programa deve permitir cadastro de um novo usuário.
- [ ] [R02] O programa deve permitir o login de um usuário.
- [ ] [R03] O programa deve permitir o usuário realizar logout.
### Página
- [ ] [R04] O usuario deve poder visualizar todas as páginas da agenda.
- [ ] [R05] O usuario deve poder criar nova página.
### Tarefa
- [ ] [R06] O usuario deve poder visualizar todas as tarefas da página.
- [ ] [R07] O usuario deve poder criar tarefa por página.

## Regras de negócio 
- [ ] [RN01] Cada usuário cadastrado tem uma agenda.
- [ ] [RN02] Cada agenda pode ter zero ou várias páginas.
- [ ] [RN03] Cada páginas pode ter zero ou várias tarefas.

## Restrições
- [ ] [RE01] O **name** deve ter no **mínimo** 5 caractéres e no máximo 20 caractéres.
- [ ] [RE02] O **username** deve ter no **mínimo** 5 caractéres e no máximo 20 caractéres.
- [ ] [RE03] O **password** deve ter no **mínimo** 5 caractéres e no máximo 20 caractéres.
- [ ] [RE04] **Não** deve ser permitido o cadastro com **username** já cadastrado.
- [ ] [RE05] Apenas realizar login de usuário cadastrado.
- [ ] [RE06] Apenas realizar logout de usuário logado.
- [ ] [RE07] O nome de cada **página** deve ter no **mínimo** 1 caractere .
- [ ] [RE08] O nome de cada **tarefa** deve ter no **mínimo** 1 caractere.
- [ ] [RE09] Todas as entidades do sistema devem ser ter um 🆔 no formato UUID.


