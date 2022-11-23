/// <reference types="cypress" />

import { should } from "chai";
import LoginPage from "../pages/LoginPage";
const loginPage = new LoginPage;

//Cenário Positivo Login:

Given("que preencho o username válido", () =>{
    loginPage.inserirCampoUsername;

});

And("preencho a senha correta", () => {
    loginPage.inserirCampoPassword;
});

When("clico no botão 'login'", ()=>{
    loginPage.clicarBotãoLogin;
});

Then("devo validar que sou redirecionado para tela Dashboard", () =>{
    cy.get('#body > div > div > h1').should('contain', "Dashboard")
});