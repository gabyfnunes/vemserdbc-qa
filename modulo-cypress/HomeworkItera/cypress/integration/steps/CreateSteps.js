import LoginPage from "../pages/LoginPage";
import DashboardPage from "../pages/DashboardPage";
import CreatePage from "../pages/CreatePage";
import BasePage from "../pages/BasePage";

import { faker } from '@faker-js/faker/locale/pt_BR';

const LOGIN_PAGE = new LoginPage;
const DASHBOARD_PAGE = new DashboardPage;
const CREATE_PAGE = new CreatePage;
const BASE_PAGE = new BasePage;


context('CreatePage', () => {

    it('Validar criação de usuario com dados validos', () => {

        LOGIN_PAGE.loginNoSistem();
        DASHBOARD_PAGE.clicarBtnCreateNew();
        CREATE_PAGE.escreverCampoName(faker.name.firstName());
        CREATE_PAGE.escreverCampoCompany(faker.company.name());
        CREATE_PAGE.escreverCampoAdress(faker.address.streetAddress());
        CREATE_PAGE.escreverCampoCity(faker.address.cityName());
        CREATE_PAGE.escreverCampoPhone(faker.phone.number());
        CREATE_PAGE.escreverCampoEmail(faker.internet.email());
        CREATE_PAGE.clicarBtnCreateNew();

        cy.url().should('eq', 'https://itera-qa.azurewebsites.net/Dashboard')
    })

    it('Validar Mensagem de erro quando tentar criar usuario com campos não preenchidos', () => {

        LOGIN_PAGE.loginNoSistem();
        DASHBOARD_PAGE.clicarBtnCreateNew();
        CREATE_PAGE.escreverCampoName(faker.name.firstName());
        CREATE_PAGE.escreverCampoCompany(faker.company.name());
        CREATE_PAGE.escreverCampoAdress(faker.address.streetAddress());
        CREATE_PAGE.clicarBtnCreateNew();


        cy.url().should('eq', 'https://itera-qa.azurewebsites.net/Customer/Create')
    })

})
