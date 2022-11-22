import BasePage from "../pages/BasePage";
import CreatePage from "../pages/CreatePage";
import DashboardPage from "../pages/DashboardPage";
import DeletePage from  "../pages/DeletePage";
import DetalhesPage from "../pages/DetalhesPage";


const BASE_PAGE = new BasePage;
const CREATE_PAGE = new CreatePage;
const DASHBOARD_PAGE = new DashboardPage;
const DELETE_PAGE = new DeletePage;
const DETALHES_PAGE = new DetalhesPage;



context('Dashboard Page', () => {

    it('Pesquisar Usuario - Search', () => {
        
        let hashFaker = CREATE_PAGE.criarNovoUsuario()
        DASHBOARD_PAGE.escreverCampoSearch(hashFaker.email)
        DASHBOARD_PAGE.clicarBtnSearch()

        DASHBOARD_PAGE.validarEmail(hashFaker.email)

    })


    it('Validar Deletar Usuario', () => {
        
        let hashFaker = CREATE_PAGE.criarNovoUsuario()

        DASHBOARD_PAGE.escreverCampoSearch(hashFaker.email)
        DASHBOARD_PAGE.clicarBtnSearch()
        DASHBOARD_PAGE.clicarBtnDelete()
        DELETE_PAGE.clicarBtnDelete();

        DASHBOARD_PAGE.escreverCampoSearch(hashFaker.email)
        DASHBOARD_PAGE.clicarBtnSearch()
        DASHBOARD_PAGE.validarMensagemErroAoBuscarUsuario("No Match")

    })

    it('Validar Botao listar informações do usuario', () => {

        let hashFaker = CREATE_PAGE.criarNovoUsuario()
        DASHBOARD_PAGE.escreverCampoSearch(hashFaker.email)
        DASHBOARD_PAGE.clicarBtnSearch()
        DASHBOARD_PAGE.clicarBtnDetalhesUsusario()

        DETALHES_PAGE.validarNome(hashFaker.nome)
        DETALHES_PAGE.validarAddress(hashFaker.address)
        DETALHES_PAGE.validarCity(hashFaker.city)
        DETALHES_PAGE.validarCompany(hashFaker.company)
        DETALHES_PAGE.validarPhone(hashFaker.phone)
        DETALHES_PAGE.validarEmail(hashFaker.email)
    })

})