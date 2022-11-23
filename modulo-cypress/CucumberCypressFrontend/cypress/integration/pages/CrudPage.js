import BasePage from "./BasePage";
const basePage = new BasePage;

import {
    faker
} from '@faker-js/faker';


export let campoName = "#Name";
export let campoCompany = "#Company";
export let campoAddress = "#Address";
export let campoCity = "#City";
export let campoPhone = "#Phone";
export let campoEmail = "#Email";

export let createBtn = "body > div > div > p:nth-child(4) > a"
export let campoBusca = "#searching"
export let botaoBusca = "body > div > div > form > input.btn.btn-secondary.my-2.my-sm-0";

export let nomeCriado = "body > div > div > table > tbody > tr:nth-child(2) > td:nth-child(1)";
export let editBtn = "body > div > div > table > tbody > tr:nth-child(2) > td:nth-child(7) > a.btn.btn-outline-primary";
export let saveButton = "body > div > form > div > div:nth-child(10) > div > input";
export let detailsBtn = "body > div > div > table > tbody > tr:nth-child(2) > td:nth-child(7) > a.btn.btn-outline-primary"
export let nomeDetalhes = "body > div > div > dl > dt:nth-child(1)";
export let deleteBtn = "body > div > div > table > tbody > tr:nth-child(2) > td:nth-child(7) > a.btn.btn-outline-danger";
export let confirmDelete = "body > div > div > form > div > input";
export let noMatchText = "body > div > div > table > tbody > tr:nth-child(2) > td";

export let nomeAnterior

export default class UserPage {

    criarUsuarioComCamposCorretos() {

    
        let nome = faker.name.firstName();
        let empresa = faker.company.name();
        let endereco = faker.address.street();
        let cidade = faker.address.cityName();
        let phone = faker.phone.number();
        let email = faker.internet.email();

       
        basePage.preencherInput(campoName, nome)
        basePage.preencherInput(campoCompany, empresa)
        basePage.preencherInput(campoAddress, endereco)
        basePage.preencherInput(campoCity, cidade)
        basePage.preencherInput(campoPhone, phone)
        basePage.preencherInput(campoEmail, email)

        return nome;
    }

    validarCriarUsuarioVazio() {

        basePage.limparInput(campoName)
        basePage.limparInput(campoCompany)
        basePage.limparInput(campoAddress)
        basePage.limparInput(campoCity)
        basePage.limparInput(campoPhone)
        basePage.limparInput(campoEmail)
    }

    editarUsuarioComCamposCorretos() {
    
        this.criarUsuarioComCamposCorretos();

    
        basePage.click(editBtn);

       
        basePage.limparInput(campoName)
        basePage.limparInput(campoCompany)
        basePage.limparInput(campoAddress)
        basePage.limparInput(campoCity)
        basePage.limparInput(campoPhone)
        basePage.limparInput(campoEmail)

     
        let nome = faker.name.firstName();
        let empresa = faker.company.name();
        let endereco = faker.address.street();
        let cidade = faker.address.cityName();
        let phone = faker.phone.number();
        let email = faker.internet.email();


        basePage.preencherInput(campoName, nome)
        basePage.preencherInput(campoCompany, empresa)
        basePage.preencherInput(campoAddress, endereco)
        basePage.preencherInput(campoCity, cidade)
        basePage.preencherInput(campoPhone, phone)
        basePage.preencherInput(campoEmail, email)

        basePage.click(saveButton);

        this.buscarNome(nome);
        basePage.validarText(nomeCriado, nome)

        
        this.deletarUsuario(nome)
    }

    tentaEditarUsuarioSemPreencherCampos() {
        this.criarUsuarioComCamposCorretos();


        basePage.click(editBtn);

      
        basePage.limparInput(campoName)
        basePage.limparInput(campoCompany)
        basePage.limparInput(campoAddress)
        basePage.limparInput(campoCity)
        basePage.limparInput(campoPhone)
        basePage.limparInput(campoEmail)

       
        let nome = "";
        let empresa = "";
        let endereco = "";
        let cidade = "";
        let phone = "";
        let email = "";

      
        basePage.preencherInput(campoName, nome)
        basePage.preencherInput(campoCompany, empresa)
        basePage.preencherInput(campoAddress, endereco)
        basePage.preencherInput(campoCity, cidade)
        basePage.preencherInput(campoPhone, phone)
        basePage.preencherInput(campoEmail, email)

        basePage.click(saveButton);

        this.buscarNome(nome);
        basePage.validarText(noMatchText, "No match")
    }

    deletarUsuario(nome) {
        this.buscarNome(nome)
        basePage.click(deleteBtn);
    }

    buscarUsuarioVazio() {
        basePage.limparInput(campoBusca);
        basePage.preencherInput(campoBusca, " ");
        basePage.click(botaoBusca);
        basePage.validarText(noMatchText, "No match")
    }

    verificarUsuario() {
        let nome = this.criarUsuarioComCamposCorretos();
        basePage.click(detailsBtn);
        basePage.validarText(nomeDetalhes, nome)
    }

    buscarNome(nome) {
        basePage.limparInput(campoBusca);
        basePage.preencherInput(campoBusca, nome);
        basePage.click(botaoBusca);

    }



}