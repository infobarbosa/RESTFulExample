package com.barbosa.dao;

import junit.framework.TestCase;
import com.barbosa.model.Interessado;
import com.barbosa.dao.InteressadoDao;

import org.apache.log4j.Logger;

public class InteressadoDaoTest extends TestCase{
	public static final Logger logger = Logger.getLogger(InteressadoDaoTest.class);
	
	public void testInsereInteressado(){
		Interessado interessado = new Interessado(-1, "Marcelo Barbosa", "8181-1939", "infobarbosa@yahoo.com.br", "inform‡tica");
		
		InteressadoDao dao = new InteressadoDao();
		dao.insereInteressado(interessado);
		
		logger.debug("Interessado inserido: " + interessado);
		
		assert interessado.getId() != -1;
	}
	
	public void testObtemInteressado(){
		Interessado interessado = null;
		
		InteressadoDao dao = new InteressadoDao();
		
		interessado = dao.obtemInteressado(2);
		
		assertNotNull(interessado);
		
		logger.debug("obtem interessado: " + interessado);
	}
}
