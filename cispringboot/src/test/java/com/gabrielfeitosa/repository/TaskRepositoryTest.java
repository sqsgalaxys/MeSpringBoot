package com.gabrielfeitosa.repository;

import com.gabrielfeitosa.Application;
import com.gabrielfeitosa.entity.Task;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.TransactionSystemException;

import javax.persistence.RollbackException;
import javax.validation.ConstraintViolationException;

// import org.springframework.boot.test.SpringApplicationConfiguration;
// import org.springframework.boot.test.WebIntegrationTest;


// @RunWith(SpringJUnit4ClassRunner.class)
// @SpringApplicationConfiguration(classes = Application.class)
// @WebIntegrationTest({ "server.port=0" })
// 更新
// https://stackoverflow.com/questions/42395225/springapplicationconfiguration-not-found-erroneous-spring-boot-starter-test-con/42788074#42788074
// 1.4.3.RELEASE --> 1.5.9.RELEASE
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration

public class TaskRepositoryTest {

    @Autowired
    TaskRepository taskRepository;

    @Before
    public void clean() {
        taskRepository.deleteAll();
    }

    @Test(expected = ConstraintViolationException.class)
    public void shouldBeFailToSaveWithoutDescription() {
        try {
            taskRepository.save(new Task());
        } catch (ConstraintViolationException e) {
            e.getConstraintViolations().forEach(c -> {
                c.getPropertyPath().forEach(f -> Assert.assertEquals("description", f.getName()));
            });
            throw e;
        }
    }

    @Test
    public void shouldBeSuccessToSave() {
        Task task = new Task("Test");
        taskRepository.save(task);
        Assert.assertTrue(taskRepository.count() == 1);
    }

    @Test
    public void shouldListAll() {
        Task task = new Task("Test");
        taskRepository.save(task);
        Iterable<Task> tasks = taskRepository.findAll();
        Assert.assertTrue(tasks.iterator().hasNext());
        tasks.forEach(t -> Assert.assertEquals("Test", t.getDescription()));
    }

    @Test(expected = TransactionSystemException.class)
    public void shouldBeFailToUpdateWithoutDescription() {
        try {
            Task task = taskRepository.save(new Task("Test"));
            task.setDescription(null);
            taskRepository.save(task);
        } catch (TransactionSystemException e) {
            ((ConstraintViolationException) ((RollbackException) e.getCause()).getCause()).getConstraintViolations().forEach(c -> {
                c.getPropertyPath().forEach(f -> Assert.assertEquals("description", f.getName()));
            });
            throw e;
        }
    }

    @Test
    public void shouldBeSuccessToUpdate() {
        Task task = taskRepository.save(new Task("Test"));
        task.setDescription("Buy Laptop");
        taskRepository.save(task);
        Task updated = taskRepository.findOne(task.getId());
        Assert.assertEquals("Buy Laptop", updated.getDescription());
    }

    @Test
    public void shouldBeSuccessToDelete() {
        Long id = taskRepository.save(new Task("Buy Sugar")).getId();
        taskRepository.save(new Task("Clear room"));
        Assert.assertTrue(taskRepository.count() == 2);
        taskRepository.delete(id);
        Assert.assertTrue(taskRepository.count() == 1);
    }
}
