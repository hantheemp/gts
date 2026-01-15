package com.muratkagan.gts.dao;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.muratkagan.gts.entities.Instrumentation;

public interface IInstrumentationDao {

	List<Instrumentation> getAll();

	Optional<Instrumentation> getById(Integer id);

	public List<Instrumentation> getByIds(Collection<Integer> ids);

	Instrumentation insert(Instrumentation instrumentation);

	Instrumentation update(Instrumentation instrumentation);

	boolean delete(Integer id);

}
