import Pessoa from "../service/pessoaService";
const pessoa = new Pessoa;
const pessoaPayload = require('../../fixtures/addPessoa.payload.json')
let token = 'eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ2ZW1zZXItYXBpIiwianRpIjoiMiIsImNhcmdvcyI6WyJST0xFX1VTVUFSSU8iLCJST0xFX01BUktFVElORyIsIlJPTEVfQURNSU4iXSwiaWF0IjoxNjY4NjU3ODgwLCJleHAiOjE2Njg3NDQyODB9.beqOeZRPmSjO3J8vDLggfQ5nJYirltWtsMVdEHkUJkM'



context('Pessoa', () => {
    it('PUT - Atualizar pessoa', () => {
        pessoa.pessoaRequest(pessoaPayload[0], 107, token)
            .then((response) => {
                expect(response.status).to.eq(200)
                expect(response.body.nome).to.eq("Phoebe Buffey");
                expect(response.body.dataNascimento).to.eq("1994-12-08");
                expect(response.body.cpf).to.eq("36985212");
                expect(response.body.email).to.eq("pheebs.buffey@email.com.br");
            })
    });

    it('PUT - Tentar atualizar pessoa com id inválido', () => {
        pessoa.pessoaRequest(pessoaPayload[0], 555, token)
            .then((response) => {
                expect(response.status).to.eq(404)

            })
    });

    it('POST - Adicionar pessoa', () => {
        pessoa.addPessoa(pessoaPayload[1], token)
            .then((response) => {
                expect(response.status).to.eq(200);
                expect(response.body.nome).to.eq("Ross Geller")
                expect(response.body.cpf).to.eq("968741289");
                expect(response.body.email).to.eq("dino.ross@email.com.br")
            })
    });

    it('POST - Tentar adicionar pessoa sem body', () => {
        pessoa.addPessoa('{}', token)
            .then((response) => {
                expect(response.status).to.eq(400);
                expect(response.body.status).to.eq(400)
            })
    });

    it('DELETE - Deletar pessoa', () => {
        let id = 0;
        pessoa.addPessoa(pessoaPayload[1], token)
            .then((response) => {
                id = response.body.idPessoa;
                pessoa.deletarPessoa(id, token)
                    .then((response) => {
                        expect(response.status).to.eq(200);
                    })
            });
    })

    it('DELETE - Tentar deletar pessoa inexistente', () => {
        pessoa.deletarPessoa(789654, token)
            .then((response) => {
                expect(response.status).to.eq(404);
            })
    });

    it('GET - Listar pessoas', () => {
        pessoa.listarPessoa(token)
            .then((response) => {
                expect(response.status).to.eq(200);
                expect(response.body.totalElements).to.be.greaterThan(10)
            })
    });

    //BUG - não retorna o body da requisição
    it('GET - Buscar pessoa por cpf', () => {
        let cpf = pessoaPayload[0].cpf;
        pessoa.buscarPessoaPorCpf(cpf, token)
            .then((response) => {
                expect(response.status).to.eq(200);
                expect(response.body.nome).to.eq("Phoebe Buffey")
            })

    });

    //BUG - retorna OK mesmo com cpf inexistente
    it('GET - Tentar buscar pessoa por cpf inválido', () => {
        let cpf = NaN;
        pessoa.buscarPessoaPorCpf(cpf, token)
            .then((response) => {
                expect(response.status).to.eq(404);

            })

    });

    it('GET - Buscar relatório', () => {
        let id = 119;
        pessoa.pessoaRelatorio(id, token)
            .then((response) => {
                expect(response.status).to.eq(200)
                expect(response.body[0].idPessoa).to.eq(119)
                expect(response.body[0].nomePessoa).to.eq("Werner")
                expect(response.body[0].email).to.eq("adrianne.dibbert@yahoo.com")
            })

    });

    it('GET - Tentar buscar relatório com id inválido', () => {
        let id = 1;
        pessoa.pessoaRelatorio(id, token)
            .then((response) => {
                expect(response.status).to.eq(200)
                expect(response.body).to.have.length(0)
            })

    });

    it('GET - Buscar lista completa', () => {
        let id = 119;
        pessoa.listaCompleta(id, token)
            .then((response) => {
                expect(response.status).to.eq(200)
                expect(response.body[0].idPessoa).to.eq(119)
                expect(response.body[0].nome).to.eq("Werner")
                expect(response.body[0].email).to.eq("adrianne.dibbert@yahoo.com")
            })

    });

    it('GET - buscar lista completa com id inválido', () => {
        let id = 1;
        pessoa.listaCompleta(id, token)
            .then((response) => {
                expect(response.status).to.eq(200)
                expect(response.body).to.have.length(0)
            })
    });

    it('GET - Buscar pessoa com endereços', () => {
        let id = 119;
        pessoa.listarPessoaComEndereco(id, token)
            .then((response) => {
                expect(response.status).to.eq(200);
                expect(response.body[0]).to.have.any.keys('enderecos')
            })

    });

    it('GET - buscar pessoa com endereços por id inválido', () => {
        let id = 0;
        pessoa.listarPessoaComEndereco(id, token)
            .then((response) => {
                expect(response.status).to.eq(404);
            })
    });

    it('GET - Buscar pessoa com endereços', () => {
        let id = 119;
        pessoa.listarPessoaComContato(id, token)
            .then((response) => {
                expect(response.status).to.eq(200);
                expect(response.body[0]).to.have.any.keys('contatos')
            })

    });

    it('GET - buscar pessoa com contatos passando id inválido', () => {
        let id = 0;
        pessoa.listarPessoaComContato(id, token)
            .then((response) => {
                expect(response.status).to.eq(404);
            })
    });

    it('GET - Listar pessoas por nome', () => {
        let nome = 'Phoebe'
        pessoa.listarPessoaPorNome(nome, token)
            .then((response) => {
                expect(response.status).to.eq(200)
                expect(response.body).length.to.be.greaterThan(1)
            })
    });

    it('GET - Tentar buscar pessoa por nome inválido', () => {
        let nome = 'SemNome'
        pessoa.listarPessoaPorNome(nome, token)
            .then((response) => {
                expect(response.status).to.eq(200)
                console.log(response.body);
                expect(response.body).to.be.empty
            })
    });

})