

import BasePage from "./BasePage";

const BASE_PAGE = new BasePage();

let btnCreateNew = "body > div > div > p:nth-child(4) > a"
let entradaSearch = "#searching"
let btnSearch = "body > div > div > form > input.btn.btn-secondary.my-2.my-sm-0"
let btnDelete = 'body > div > div > table > tbody > tr:nth-child(2) > td:nth-child(7) > a.btn.btn-outline-danger'
let emailDaTabela = 'body > div > div > table > tbody > tr:nth-child(2) > td:nth-child(6)'
let msgErrorAoBuscarUsuario = 'body > div > div > table > tbody > tr:nth-child(2) > td'
let btnDetalhesUsuario = 'body > div > div > table > tbody > tr:nth-child(2) > td:nth-child(7) > a.btn.btn-outline-info'


export default class DashboardPage {

    clicarBtnCreateNew() {
        BASE_PAGE.click(btnCreateNew)
    }

    clicarBtnDelete() {
        BASE_PAGE.click(btnDelete)
    }

    clicarBtnSearch() {
        BASE_PAGE.click(btnSearch)
    }

    clicarBtnDetalhesUsusario() {
        BASE_PAGE.click(btnDetalhesUsuario)
    }

    escreverCampoSearch(text) {
        BASE_PAGE.escreverEntrada(entradaSearch, text)
    }

    validarEmail(text) {
        BASE_PAGE.validarText(emailDaTabela, text)
    }

    validarMensagemErroAoBuscarUsuario(text) {
        BASE_PAGE.validarText(msgErrorAoBuscarUsuario, text)
    }

}