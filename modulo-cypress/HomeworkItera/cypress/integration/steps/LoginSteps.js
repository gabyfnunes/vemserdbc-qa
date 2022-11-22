/// <reference types="cypress" />

import LoginPage from "../pages/LoginPage";

const LOGIN_PAGE = new LoginPage;

context('LoginPage', () => {


    it('Validar Login Com Sucesso', () => {
        LOGIN_PAGE.loginNoSistem();
    })

    it('Validar tentavia de login com senha errada', () => {
        LOGIN_PAGE.loginNoSistemComSenhaErrada();
    })

})