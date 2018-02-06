package xyz.sydns.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import xyz.sydns.entity.Task;

/**
 * @author sqsgalaxys
 */
@RepositoryRestResource
public interface TaskRepository extends CrudRepository<Task, Long> {

}
