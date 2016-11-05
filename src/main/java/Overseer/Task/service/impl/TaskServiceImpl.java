package Overseer.Task.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Overseer.Task.bean.TaskBean;
import Overseer.Task.dao.TaskDao;
import Overseer.Task.service.TaskService;
import Overseer.util.HibernateUtil;

@Service("taskService")
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskDao taskDao;

	@Override
	public List<TaskBean> getTaskList() throws Exception {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		List<TaskBean> taskList = taskDao.getTaskList(session);
		session.close();
		return taskList;

	}

	@Override
	public TaskBean getTask(TaskBean task) throws Exception {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		task = taskDao.getTaskById(session, task);
		session.close();
		return task;

	}

	@Override
	public TaskBean saveTask(TaskBean task) throws Exception {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Integer id = task.getId();

		if (id == null || id < 0) {
			task = taskDao.saveTask(session, task);
		} else {
			task = taskDao.getTaskById(session, task);
			task = taskDao.updateTask(session, task);
		}

		session.close();
		return task;

	}

	@Override
	public Boolean updateStatus(TaskBean task) throws Exception {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		task = taskDao.getTaskById(session, task);
		task = taskDao.updateTask(session, task);
		session.clear();
		return task != null;

	}

	@Override
	public Boolean deleteTask(TaskBean task) throws Exception {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		task = taskDao.getTaskById(session, task);
		Boolean result = taskDao.deleteTask(session, task);
		session.close();
		return result;

	}

}
