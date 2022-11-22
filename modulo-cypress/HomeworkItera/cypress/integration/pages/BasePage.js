/// <reference types = "cypress" />

export default class BasePage {
 
    click(elemet){ 
       cy.get(elemet).click() 
    }
  
    clickForce(elemet){ 
       cy.get(elemet).click({force:true}) 
    }
  
    escreverEntrada(element, text){ 
      cy.get(element).type(text)
    }
  
    escreverEntradaComTeclaNoFinal(element, text, tecla){
       cy.get(element).type(text).type(tecla);
    }
  
    escreverEntradaForce(element, text){ 
       cy.get(element).type(text, {force:true})
    }
    
    tempo(tempo){ 
       cy.wait(tempo) 
    }
  
    select(element, value){ 
       cy.get(element).select(value) 
    }
  
    validarText(element, text){ 
       cy.get(element).should('contain', text) 
    }
  
   
  }
  