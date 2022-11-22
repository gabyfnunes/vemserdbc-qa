

import BasePage from "./BasePage";
import DashboardPage from "./DashboardPage";

const BASE_PAGE = new BasePage();
const createnew = new DashboardPage()

let username = "#Username";
let password = "#Password";
let loginBtn = "body > div > div:nth-child(4) > form > table > tbody > tr:nth-child(7) > td:nth-child(2) > input.btn.btn-primary"
let msgLogin = ".alert-danger";


export default class LoginPage {
    
    
    loginNoSistem() {
        BASE_PAGE.preencherInput(username, "teste123")
        BASE_PAGE.preencherInput(password, "12345")
        BASE_PAGE.click(loginBtn)
    }

    loginNoSistemComSenhaErrada() {
        BASE_PAGE.preencherInput(username, "teste123")
        BASE_PAGE.preencherInput(password, "senha_errada")
        BASE_PAGE.click(loginBtn)
        BASE_PAGE.validarText(msgLogin, "Wrong username or password")
    }
}