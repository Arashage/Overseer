package Overseer.Task.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import Overseer.Task.bean.TaskBean;
import Overseer.Task.dao.TaskDao;

@Repository("taskDao")
public class TaskDaoImpl implements TaskDao {

	@Override
	public List<TaskBean> getTaskList(Session session) throws Exception {

		Transaction tx = session.beginTransaction();

		try {
			Criteria criteria = session.createCriteria(TaskBean.class);
			List<TaskBean> taskList = criteria.list();
			tx.commit();
			return taskList;
		} catch (Exception exception) {
			throw exception;
		}

	}

	@Override
	public TaskBean getTaskById(Session session, TaskBean task) throws Exception {

		Transaction tx = session.beginTransaction();

		try {
			Criteria criteria = session.createCriteria(TaskBean.class);
			criteria.add(Restrictions.eq("id", task.getId()));
			tx.commit();
			return (TaskBean) criteria.list().get(0);
		} catch (Exception exception) {
			throw exception;
		}

	}

	@Override
	public TaskBean saveTask(Session session, TaskBean task) throws Exception {

		Transaction tx = session.beginTransaction();

		try {
			session.save(task);
			session.flush();
			tx.commit();
			return task;
		} catch (Exception exception) {
			tx.rollback();
			throw exception;
		}

	}

	@Override
	public TaskBean updateTask(Session session, TaskBean task) throws Exception {

		Transaction tx = session.beginTransaction();

		try {
			session.update(task);
			session.flush();
			tx.commit();
			return task;
		} catch (Exception exception) {
			tx.rollback();
			throw exception;
		}

	}

	@Override
	public Boolean deleteTask(Session session, TaskBean task) throws Exception {

		Transaction tx = session.beginTransaction();

		try {
			session.delete(task);
			session.flush();
			tx.commit();
			return true;
		} catch (Exception exception) {
			tx.rollback();
			throw exception;
		}

	}

}
