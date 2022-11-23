Feature: user

    Scenario: Criar novo user
        Given  que estou logado
        And que clico em create user
        And que preencho todos os campos validos
        When clico em create
        Then  devo ver usuario criado

    Scenario: Tentar criar user com campos vazios
        Given que estou logado
        And que clico em create user
        And que nao preencho os campos obrigatorios
        When clico em create
        Then nao devo criar usuario

    Scenario: Editar usuário corretamente
        Given que estou logado
        And que crio um usuario valido
        And que clico em editar
        And preencho todos os campos corretamente
        When clico em salvar
        Then devo ter editado um usuario

    Scenario: Tentar editar um usuário deixando camposn ão preenchidos
        Given que estou logado
        And que crio um usuario valido
        And que clico em editar
        And que nao preencho os campos obrigatorios
        When clico em salvar
        Then devo validar que não foi editado

    Scenario: Deletar um usuário
        Given que estou logado
        And que crio um usuario valido
        And clico em Deletar
        When clico em confirmar Deletar
        Then devo ter deletado o usuario