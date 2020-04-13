package br.com.qintess.DAO;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;

import br.com.qintess.config.HibernateConfig;

public class GenericDao<T> {

	private Session session;
	private Class<T> persistedClass;
	
	public GenericDao() {
	}
	
	public GenericDao(Class<T> persistedClass) {
		this.persistedClass = persistedClass;
	}
	
	//essa função retorna uma sessão aberta
	private Session getSession() {
		return session = HibernateConfig.getSessionFactory().openSession();
	}
	
	public T salvar(T entidade) {
		try (Session ses = getSession()){
		ses.getTransaction().begin();
		ses.persist(entidade);
		ses.flush();
		ses.getTransaction().commit();
		return entidade;
		} catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public T atualizar(T entidade) {
		try (Session ses = getSession()){
		ses.getTransaction().begin();
		ses.merge(entidade);
		ses.flush();
		ses.getTransaction().commit();
		return entidade;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public T encontrarPorId(Long id) {
		try (Session ses = getSession()){
		return session.find(persistedClass, id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<T> encontrarTodos(){
		try (Session ses = getSession()){
		CriteriaBuilder builder = ses.getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(persistedClass);
		query.from(persistedClass);
		return ses.createQuery(query).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void deletar(T entity) {
		try (Session ses = getSession()){
		ses.getTransaction().begin();
		ses.remove(entity);
		ses.flush();
		ses.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
