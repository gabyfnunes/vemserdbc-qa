///<reference types="cypress" />

const id = 1;


context('Autores', () => {

    it('Buscar Todos os Autores', () => {
        cy.request({
            method: 'GET',
            url: 'https://fakerestapi.azurewebsites.net/api/v1/Authors',
            failOnStatusCode: false
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body).to.not.be.empty;
        })
    })

    it('Postar novo Autor', () => {
        cy.request({
            method: 'POST', 
            url: 'https://fakerestapi.azurewebsites.net/api/v1/Authors',
            failOnStatusCode: false,
            body: {
                "id": 123,
                "idBook": 456,
                "firstName": "Stephen",
                "lastName": "King"
            }
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body.lastName).to.eq("King")
        })
    })

    it('Postar novo Autor com Id nulo', () => {
        cy.request({
            method: 'POST', 
            url: 'https://fakerestapi.azurewebsites.net/api/v1/Authors',
            failOnStatusCode: false,
            body: {
                "id": null,
                "idBook": 456,
                "firstName": "Stephen",
                "lastName": "King"
            }
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(400);
        })
    })

    it('Buscar livro do Autor por ID Livro', () => {
        cy.request({
            method: 'GET',
            url: 'https://fakerestapi.azurewebsites.net/api/v1/Authors/authors/books/1',
            failOnStatusCode: false
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body[0].lastName).to.eq('Last Name 1')
        })
    })

    it('Buscar livro do Autor por ID Inexistente', () => {
        cy.request({
            method: 'GET',
            url: 'https://fakerestapi.azurewebsites.net/api/v1/Authors/authors/books/65974',
            failOnStatusCode: false
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
        })

    //A API retorna um JSON vazio, porém seria melhor se devolvesse o CÓDIGO de NOT FOUND (404)
    })

    it('Buscar Autor por id', () => {
        cy.request({
            method: 'GET',
            url: 'https://fakerestapi.azurewebsites.net/api/v1/Authors/' + id,
            failOnStatusCode: false
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body.id).to.eq(1)
        })
    })

    it('Atualizar Autor por id', () => {
        cy.request({
            method: 'PUT',
            url: 'https://fakerestapi.azurewebsites.net/api/v1/Authors/' + id,
            failOnStatusCode: false,
            body: {
                "id": 1,
                "idBook": 0,
                "firstName": "Edgar",
                "lastName": "Allan Poe"
            }
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body.lastName).to.eq("Allan Poe")
        })
    })

    it('Deletar Autor existente', () => {
        cy.request({
            method: 'DELETE',
            url: 'https://fakerestapi.azurewebsites.net/api/v1/Authors/123',
            failOnStatusCode: false
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
        })
    })
})