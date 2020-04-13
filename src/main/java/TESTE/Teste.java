package TESTE;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import br.com.qintess.DAO.GenericDao;
import br.com.qintess.cerveja.Cerveja;
import br.com.qintess.cerveja.Estilo;
import br.com.qintess.cliente.Cidade;
import br.com.qintess.cliente.Cliente;
import br.com.qintess.cliente.Estado;
import br.com.qintess.grupo.Grupo;
import br.com.qintess.grupo.GrupoPermissao;
import br.com.qintess.grupo.Permissao;
import br.com.qintess.grupo.Usuario;
import br.com.qintess.grupo.UsuarioGrupo;
import br.com.qintess.venda.ItenVenda;
//import br.com.qintess.venda.ItenVenda;
import br.com.qintess.venda.Venda;

public class Teste {
	
	private static Date getNow() {
		return Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
	}
	
	public static void main(String[] args) {
		Long inicio = System.currentTimeMillis();
	//*****************************************************************************************************************
												//ESTADO
		
		Estado estado1 = new Estado(null, "São Paulo", "SP");
		
	
		
		
		
		
	//*****************************************************************************************************************
												//CIDADE
		
		
		Cidade cidade1 = new Cidade(null, "São Bernardo Do Campo");
		
		
		
		
		
		
	//*****************************************************************************************************************
												//CLIENTES

	Cliente c1 = new Cliente(null, "Diogo Dantas", "34712398845", "95643-9867", "diogao@gmail.com", "Av. Paulista", 123, null, "09892-210");
	
	//*************************************************************************************************************
											//BEBIDAS
	
	Cerveja bebida1 = new Cerveja(null, "Skol", 3.19, 4.47, "Pilsen", "Brasil", 1000);
	
	//************************************************************************************************************
											//ESTILOS
	
	Estilo estilo1 = new Estilo(null, "Artesanal");
	
	
	//**************************************************************************************************************
											//VENDA
	

	
	Venda v1 = new Venda(null, 120, 0, 0, getNow());
	
	//**************************************************************************************************************
											//ITENVENDA
	
	ItenVenda itenvenda1 = new ItenVenda(1, 3.19);
	
	//**************************************************************************************************************
											//PERMISSAO
	Permissao permissao1 = new Permissao(null, "permitido");
	
	//*************************************************************************************************************
											//GRUPO
	Grupo grupo1 = new Grupo(null, "Maiores de idade");
	
	
	//**************************************************************************************************************
											//GRUPOPERMISSAO
	
	GrupoPermissao grupopermissao1 = new GrupoPermissao(null);
	
	//**************************************************************************************************************
											//USUARIO
	
	Usuario usuario1 = new Usuario(null, "Renato", "renato@gmail.com", "renato123", "ativo");
	
	//**************************************************************************************************************
											//USUARIOGRUPO
	
	UsuarioGrupo usuariogrupo1 = new UsuarioGrupo(null);
	
	
	
	
	//**************************************************************************************************************
											//CONEXAO
	
	

	//**************************
	//ESTADO

	GenericDao<Estado> estadoDao = new GenericDao<>(Estado.class);
	estadoDao.salvar(estado1);
	
	//****************************
	//CIDADE
	GenericDao<Cidade> cidadeDao = new GenericDao<Cidade>(Cidade.class);
	cidade1.setEstado(estado1);
	cidadeDao.salvar(cidade1);
	
	
	//*****************************
	// CLIENTE
	GenericDao<Cliente> clienteDao = new GenericDao<>(Cliente.class);
	c1.setCidade(cidade1);
	clienteDao.salvar(c1);


	//******************************
	//ESTILO
	GenericDao<Estilo> estiloDao = new GenericDao<Estilo>(Estilo.class);
	estiloDao.salvar(estilo1);
	
	
	//*******************************
	//CERVEJA
	GenericDao<Cerveja> cervejaDao = new GenericDao<Cerveja>(Cerveja.class);
	bebida1.setEstilo(estilo1);
	cervejaDao.salvar(bebida1);

	//******************************************
	//PERMISSAO
	GenericDao<Permissao> permissaoDao = new GenericDao<Permissao>(Permissao.class);
	permissaoDao.salvar(permissao1);
//	//******************************************
//	//GRUPO
	GenericDao<Grupo> grupoDao = new GenericDao<Grupo>(Grupo.class);
	grupoDao.salvar(grupo1);
	
	//*******************************************
//	//GRUPOPERMISSAO
	GenericDao<GrupoPermissao> grupopermissaoDao = new GenericDao<GrupoPermissao>(GrupoPermissao.class);
	grupopermissao1.setGrupo(grupo1);
	grupopermissao1.setPermissao(permissao1);
	grupopermissaoDao.salvar(grupopermissao1);
//	//********************************************
//	//USUARIO
	GenericDao<Usuario> usuarioDao = new GenericDao<Usuario>(Usuario.class);
	usuarioDao.salvar(usuario1);
//	//********************************************
//	//USUARIOGRUPO
	GenericDao<UsuarioGrupo> usuariogrupoDao = new GenericDao<UsuarioGrupo>(UsuarioGrupo.class);
	usuariogrupo1.setGrupo(grupo1);
	usuariogrupo1.setUsuario(usuario1);
	usuariogrupoDao.salvar(usuariogrupo1);
//	//********************************************
//	//VENDA
	GenericDao<Venda> vendaDao = new GenericDao<Venda>(Venda.class);
	v1.setCliente(c1);
	v1.setUsuario(usuario1);
	vendaDao.salvar(v1);
//
//	//*********************************************
//	//ITENVENDA

	GenericDao<ItenVenda> itenvendaDao = new GenericDao<ItenVenda>(ItenVenda.class);
	itenvenda1.setVenda(v1);
	itenvenda1.setCerveja(bebida1);
	itenvendaDao.salvar(itenvenda1);
	
	
	long fim = System.currentTimeMillis();

	System.out.println("tempo de execução: " + (fim-inicio)/1000d + " Segundos");

	System.out.println("PRONTO!");
	
	
	}
	
	
}
