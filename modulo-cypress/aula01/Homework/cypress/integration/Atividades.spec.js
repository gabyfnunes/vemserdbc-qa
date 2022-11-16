///<reference types="cypress" />

const id = 1;

// Suite
context('Atividades', () => {

    // Cenario
    it('Buscar todas as Atividades', () => {
  
      cy.request({
        method: 'GET',
        url: 'https://fakerestapi.azurewebsites.net/api/v1/Activities',
        failOnStatusCode: false
      }).as('response').get('@response').should((response) => {
        expect(response.status).to.eq(200);
        expect(response.body).to.not.be.empty;
      })
  
    });
  
    it('Postar Nova Atividade', () => {
  
      cy.request({
        method: 'POST',
        url: 'https://fakerestapi.azurewebsites.net/api/v1/Activities',
        failOnStatusCode: false, 
        body: {
          "id": 17,
          "title": "Homework",
          "dueDate": "2022-11-16T09:00:10.775Z",
          "completed": true
        }
      }).as('response').get('@response').should((response) => {
        expect(response.status).to.eq(200);
        expect(response.body.id).to.eq(17);
        expect(response.body.title).to.eq("Homework");
  
      })
  
    });

    it('Postar Nova Atividade com Id Nulo', () => {
  
      cy.request({
        method: 'POST',
        url: 'https://fakerestapi.azurewebsites.net/api/v1/Activities',
        failOnStatusCode: false, 
        body: {
          "id": null,
          "title": "Homework",
          "dueDate": "2022-11-16T09:00:10.775Z",
          "completed": true
        }
      }).as('response').get('@response').should((response) => {
        expect(response.status).to.eq(400);
        })
  
    });

    it("Buscar Atividade por Id", () => {
      cy.request({
        method: 'GET',
        url: 'https://fakerestapi.azurewebsites.net/api/v1/Activities/' + id,
        failOnStatusCode: false
      }).as('response').get('@response').should((response) =>{
        expect(response.status).to.eq(200);
        expect(response.body.id).to.eq(1);
      })
    });

    it("Buscar Atividade por Id inexistente", () => {
      cy.request({
        method: 'GET',
        url: 'https://fakerestapi.azurewebsites.net/api/v1/Activities/-9873',
        failOnStatusCode: false
      }).as('response').get('@response').should((response) =>{
        expect(response.status).to.eq(404);
      })
    });

    it('Atualizar Atividade Existente', () => {
      cy.request({
        method: 'PUT',
        url: 'https://fakerestapi.azurewebsites.net/api/v1/Activities/' + id,
        failOnStatusCode: false,
        body: {
          "id": 1,
          "title": "Teste",
          "dueDate": "2022-11-16T08:54:49.649Z",
          "completed": true
        }
      }).as('response').get('@response').should((response) => {
        expect(response.status).to.eq(200);
        expect(response.body.title).to.eq("Teste")
      })
    })

    it('Deletar Atividade Existente',  () => {
      cy.request({
        method: 'DELETE',
        url: 'https://fakerestapi.azurewebsites.net/api/v1/Activities/17',
        failOnStatusCode: false
      }).as('response').get('@response').should((response) => {
        expect(response.status).to.eq(200);
      })
    })

  });