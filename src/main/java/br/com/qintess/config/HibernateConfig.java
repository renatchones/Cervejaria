package br.com.qintess.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

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
import br.com.qintess.venda.Venda;

public class HibernateConfig {

	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory(){

		if(sessionFactory==null) {

			try {

				Configuration configuration = new Configuration();

				Properties prop = new Properties();

				prop.put(Environment.DRIVER, "com.mysql.jdbc.Driver");

				prop.put(Environment.URL, "jdbc:mysql://localhost:3307/ambev2");

				prop.put(Environment.USER, "root");

				prop.put(Environment.PASS, "");

				//Prestar atenção nisso em banco de dados de produção

				prop.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5InnoDBDialect");

				prop.put(Environment.SHOW_SQL, "true");

				//Principalmente nessa linha que pode F#der tudo.

				prop.put(Environment.HBM2DDL_AUTO, "create-drop");

				configuration.setProperties(prop);

				configuration.addAnnotatedClass(Cerveja.class);

				configuration.addAnnotatedClass(Cidade.class);

				configuration.addAnnotatedClass(Cliente.class);

				configuration.addAnnotatedClass(Estado.class);

				configuration.addAnnotatedClass(Estilo.class);

				configuration.addAnnotatedClass(Grupo.class);

				configuration.addAnnotatedClass(ItenVenda.class);

				configuration.addAnnotatedClass(Permissao.class);

				configuration.addAnnotatedClass(Usuario.class);

				configuration.addAnnotatedClass(Venda.class);
				
				configuration.addAnnotatedClass(GrupoPermissao.class);
				
				configuration.addAnnotatedClass(UsuarioGrupo.class);



				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

				sessionFactory = configuration.buildSessionFactory(serviceRegistry);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return sessionFactory;

	}

}	