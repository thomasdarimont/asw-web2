package de.asw.training.beans;

import java.util.List;

public interface TodoService {

   Todo create(Todo newTodo);

   List<Todo> findAll();

   Todo findById(Long id);

   Todo update(Long id, Todo newTodo);

   boolean delete(Long id);
}


class TodoServiceImpl implements TodoService {

	@Override
	public Todo create(Todo newTodo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Todo> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Todo findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Todo update(Long id, Todo newTodo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		return false;
	}
	
}