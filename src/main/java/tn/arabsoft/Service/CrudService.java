package tn.arabsoft.Service;

import java.util.List;

public interface CrudService <T>  {

	public T save(T t);
	public List<T> getAll();
	public T getOne(int id);
	public int delete(int id);
	
}
