const baseUrl = Cypress.env('API_BASE');

export default class Pessoa {

    async logar() {
        const options = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: '{"login":"admin","senha":"123"}'
        }

        let response = await fetch(`${baseUrl}/auth`, options);
        let token = await response.text()
        token = token.split(" ");
        console.log(token[1]);
        return token[1];
    }


    async pessoaRequest(payload, idNumber, token) {
        return cy.request({
            method: 'PUT',
            url: `${baseUrl}/pessoa/${idNumber}`,
            headers: {
                'Content-Type': 'application/json',
                Authorization: `Bearer ${token}`
            },
            body: payload,
            failOnStatusCode: false
        })
    }

    addPessoa(payload, token) {
        return cy.request({
            method: 'POST',
            url: `${baseUrl}/pessoa`,
            headers: {
                'Content-Type': 'application/json',
                Authorization: `Bearer ${token}`
            },
            body: payload,
            failOnStatusCode: false
        })
    }

    deletarPessoa(id, token) {
        return cy.request({
            method: 'DELETE',
            url: `${baseUrl}/pessoa/${id}`,
            headers: {
                Authorization: `Bearer ${token}`
            },
            failOnStatusCode: false
        })
    }

    listarPessoa(token) {
        return cy.request({
            method: 'GET',
            url: `${baseUrl}/pessoa`,
            headers: {
                'Content-Type': 'application/json',
                Authorization: `Bearer ${token}`
            },
            failOnStatusCode: false
        })
    }

    buscarPessoaPorCpf(cpf, token) {
        return cy.request({
            method: 'GET',
            url: `${baseUrl}/pessoa/${cpf}/cpf`,
            headers: {
                'Content-Type': 'application/json',
                Authorization: `Bearer ${token}`
            },
            failOnStatusCode: false
        })
    }

    pessoaRelatorio(id, token) {
        return cy.request({
            method: 'GET',
            url: `${baseUrl}/pessoa/relatorio`,
            qs: {
                "idPessoa": id
            },
            headers: {
                'Content-Type': 'application/json',
                Authorization: `Bearer ${token}`
            },
            failOnStatusCode: false
        })
    }

    listaCompleta(id, token) {
        return cy.request({
            method: 'GET',
            url: `${baseUrl}/pessoa/lista-completa`,
            qs: {
                "idPessoa": id
            },
            headers: {
                'Content-Type': 'application/json',
                Authorization: `Bearer ${token}`
            },
            failOnStatusCode: false
        })
    }

    listarPessoaComEndereco(id, token) {
        return cy.request({
            method: 'GET',
            url: `${baseUrl}/pessoa/lista-com-enderecos`,
            qs: {
                "idPessoa": id
            },
            headers: {
                'Content-Type': 'application/json',
                Authorization: `Bearer ${token}`
            },
            failOnStatusCode: false
        })
    }

    listarPessoaComContato(id, token) {
        return cy.request({
            method: 'GET',
            url: `${baseUrl}/pessoa/lista-com-contatos`,
            qs: {
                "idPessoa": id
            },
            headers: {
                'Content-Type': 'application/json',
                Authorization: `Bearer ${token}`
            },
            failOnStatusCode: false
        })
    }

    listarPessoaPorNome(nome, token) {
        return cy.request({
            method: 'GET',
            url: `${baseUrl}/pessoa/byname`,
            qs: {
                "nome": nome
            },
            headers: {
                'Content-Type': 'application/json',
                Authorization: `Bearer ${token}`
            },
            failOnStatusCode: false
        })
    }
}