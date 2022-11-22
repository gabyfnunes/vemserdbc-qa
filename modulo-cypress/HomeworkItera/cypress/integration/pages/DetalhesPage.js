import BasePage from "./BasePage";

const BASE_PAGE = new BasePage();

let campoNome = 'body > div > div > dl > dd:nth-child(2)'
let campoCompany = 'body > div > div > dl > dd:nth-child(4)'
let campoAddress = 'body > div > div > dl > dd:nth-child(6)'
let campoCity = 'body > div > div > dl > dd:nth-child(8)'
let campoPhone = 'body > div > div > dl > dd:nth-child(10)'
let campoEmail = 'body > div > div > dl > dd:nth-child(12)'

export default class DetalhesPage {

    validarName(text) {
        BASE_PAGE.validarText(campoNome, text)
    }

    validarCompany(text) {
        BASE_PAGE.validarText(campoCompany, text)
    }

    validarAddress(text) {
        BASE_PAGE.validarText(campoAddress, text)
    }

    validarCity(text) {
        BASE_PAGE.validarText(campoCity, text)
    }

    validarPhone(text) {
        BASE_PAGE.validarText(campoPhone, text)
    }

    validarEmail(text) {
        BASE_PAGE.validarText(campoEmail, text)
    }

}