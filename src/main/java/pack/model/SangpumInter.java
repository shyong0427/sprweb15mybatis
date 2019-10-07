package pack.model;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface SangpumInter {
	List list() throws DataAccessException;
	
}