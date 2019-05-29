package com.maave.maps2go.modelo;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TemaDAO extends AbstractDAO<Tema>{
    
    public TemaDAO() {
        super();
    }

    @Override
    public void agregar(Tema tema) {
        super.agregar(tema);
    }

    @Override
    public void actualizar(Tema tema) {
        super.actualizar(tema);
    }

    @Override
    public void borrar(Tema tema) {
        super.borrar(tema);
    }

    public Tema consultar(String id) {
        return super.consultarString(Tema.class, id);
    }

    public List<Tema> consultarTodos() {
        return super.consultarTodos(Tema.class);
    }
        
    public boolean existeTema(String tipoTema){
        Tema t = null;
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            String hql = "from Tema where tipo_tema = :tipoTema";
            Query query = session.createQuery(hql);
            query.setParameter("tipoTema", tipoTema);
            t = (Tema)query.uniqueResult();
            tx.commit();
        }catch(HibernateException e){
            if(tx != null){
                tx.rollback();
            }
        }finally{
            session.close();
        }
        return t!=null;
                
    }
    
    public boolean esPropio(int id, int user){
        Tema obj = null;
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = "from Tema where tipo_tema = :id and id_usuario = :user";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            query.setParameter("user", user);
            obj = (Tema) query.uniqueResult();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();

        }
        if(obj == null)
            return false;
        else
            return true;
    }

    
    
    public boolean existeColor(String color){
        Tema t = null;
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            String hql = "from Tema where color = :color";
            Query query = session.createQuery(hql);
            query.setParameter("color", color);
            t = (Tema)query.uniqueResult();
            tx.commit();
        }catch(HibernateException e){
            if(tx != null){
                tx.rollback();
            }
        }finally{
            session.close();
        }
        return t!=null;
    }

}
