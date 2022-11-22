// Suite
context('User', () => {

    // Cenario
    it('Buscar todos os Usuarios', () => {
  
      cy.request({
        method: 'GET',
        url: 'https://jsonplaceholder.typicode.com/todos/1',
        failOnStatusCode: false
      }).as('response').get('@response').should((response) =>{
        expect(response.status).to.eq(200);
        expect(response.body.userId).to.eq(1);
        expect(response.body.id).to.eq(1);
        expect(response.body.title).to.eq("delectus aut autem");
  
      })
  
    });
  
  
  });