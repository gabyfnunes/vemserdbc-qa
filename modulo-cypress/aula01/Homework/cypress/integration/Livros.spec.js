///<reference types="cypress" />

const id = 7;

context('Livros', () => {
    it('Buscar todos os livros', () => {
        cy.request({
            method: 'GET',
            url: 'https://fakerestapi.azurewebsites.net/api/v1/Books',
            failOnStatusCode: false
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body).to.not.be.empty;
        })
    })

    it('Postar novo Livro', () => {
        cy.request({
            method: 'POST',
            url: 'https://fakerestapi.azurewebsites.net/api/v1/Books',
            failOnStatusCode: false,
            body: {
                "id": 987,
                "title": "It, A coisa",
                "description": "Melhor filme de criança lutando com demônio",
                "pageCount": 1104,
                "excerpt": "BEEP-BEEP RICHIE",
                "publishDate": "1986-07-15T07:35:04.735Z"
            }
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body.description).to.eq('Melhor filme de criança lutando com demônio')
            expect(response.body.id).to.eq(987)
        })
    })

    it('Buscar livro por id', () => {
        cy.request({
            method: 'GET',
            url: 'https://fakerestapi.azurewebsites.net/api/v1/Books/' + id,
            failOnStatusCode: false
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body.title).to.eq('Book 7')
        })
    })

    it('Atualizar livro por id', () => {
        cy.request({
            method: 'PUT',
            url: 'https://fakerestapi.azurewebsites.net/api/v1/Books/987',
            failOnStatusCode: false,
            body: {
                "id": 987,
                "title": "It, A coisa",
                "description": "Melhor filme de criança lutando com palhaço assassino",
                "pageCount": 1104,
                "excerpt": "BEEP-BEEP RICHIE!",
                "publishDate": "1986-07-15T07:35:04.735Z"
            }
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body.title).to.eq('It, A coisa')
        })
    })

    it('Deletar livros por id', () => {
        cy.request({
            method: 'DELETE',
            url: 'https://fakerestapi.azurewebsites.net/api/v1/Books/987',
            failOnStatusCode: false,
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
        })
    })
})