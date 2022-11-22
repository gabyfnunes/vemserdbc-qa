import BasePage from "./BasePage";
import LoginPage from "./LoginPage";
import DashboardPage from "./DashboardPage";

import { faker } from '@faker-js/faker/locale/pt_BR';



const BASE_PAGE = new BasePage();
const LOGIN_PAGE = new LoginPage();
const DASHBOARD_PAGE = new DashboardPage();

let entradaName = "#Name"
let entradaCompany = "#Company"
let entradaAdress = "#Address"
let entradaCity = "#City"
let entradaPhone = "#Phone"
let entradaEmail = "#Email"
let btnCreate = "body > div > form > div > div:nth-child(9) > div > input"
let btnBackToList = "body > div > div > a"

export default class CreatePage {

        escreverCampoName(text) {
            BASE_PAGE.escreverEntrada(entradaName, text)
        }

        escreverCampoCompany(text) {
            BASE_PAGE.escreverEntrada(entradaCompany, text)
        }

        escreverCampoAdress(text) {
            BASE_PAGE.escreverEntrada(entradaAdress, text)
        }

        escreverCampoCity(text) {
            BASE_PAGE.escreverEntrada(entradaCity, text)
        }

        escreverCampoPhone(text) {
            BASE_PAGE.escreverEntrada(entradaPhone, text)
        }

        escreverCampoEmail(text) {
            BASE_PAGE.escreverEntrada(entradaEmail, text)
        }

        clicarBtnCreateNew() {
            BASE_PAGE.click(btnCreate)
        }

        clicarBtnBackToList() {
            BASE_PAGE.click(btnBackToList)
        }

        criarNovoUsuario() {
            
            let hashFaker = new Map();

            LOGIN_PAGE.loginNoSistem();
            DASHBOARD_PAGE.clicarBtnCreateNew();

            hashFaker.nome = (faker.name.firstName());
            hashFaker.company = (faker.company.name());
            hashFaker.address =(faker.address.streetAddress());
            hashFaker.city =(faker.address.cityName());
            hashFaker.phone =(faker.phone.number());
            hashFaker.email =(faker.internet.email());

            this.escreverCampoName(hashFaker.nome)
            this.escreverCampoCompany(hashFaker.company)
            this.escreverCampoAdress(hashFaker.address)
            this.escreverCampoCity(hashFaker.city)
            this.escreverCampoPhone(hashFaker.phone)
            this.escreverCampoEmail(hashFaker.email)
            this.clicarBtnCreateNew();

            return hashFaker
        }

}