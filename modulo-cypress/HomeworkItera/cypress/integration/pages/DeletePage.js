import BasePage from "./BasePage";

const BASE_PAGE = new BasePage();

let btnDelete = 'body > div > div > form > div > input'


export default class DeletePage {

    clicarBtnDelete() {
        BASE_PAGE.click(btnDelete)
    }
}