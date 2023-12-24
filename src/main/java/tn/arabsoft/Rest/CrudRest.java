package tn.arabsoft.Rest;

import java.util.List;

public interface CrudRest <T>  {

	public T save(T t);
	public List<T> getAll();
	public T getOne(int id);
	public int delete(int id);
	
}
