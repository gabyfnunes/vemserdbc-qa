/// <reference types = "cypress"/>

import LoginPage from "../pages/LoginPage";
const loginPage = new LoginPage;

context('Login', () => {

    it ('Validar login com sucesso', () => {
        loginPage.loginNoSistema();
    });

    it ('Validar tentativa de login com senha errada', () => {
        loginPage.loginNoSistemaComSenhaErrada();
    });

});