package Overseer.Task.dao;

import java.util.List;

import org.hibernate.Session;

import Overseer.Task.bean.TaskBean;

public interface TaskDao {

	/**
	 * Get All Task List
	 * 
	 * @param session
	 * @return List<TaskBean>
	 */
	public List<TaskBean> getTaskList(Session session) throws Exception;

	/**
	 * Get Task by Id
	 * 
	 * @param session
	 * @param task
	 * @return TaskBean
	 */
	public TaskBean getTaskById(Session session, TaskBean task) throws Exception;

	/**
	 * Save Task and return with lasted value include ID
	 * 
	 * @param session
	 * @param task
	 * @return TaskBean
	 */
	public TaskBean saveTask(Session session, TaskBean task) throws Exception;

	/**
	 * Update Task and return with lasted value
	 * 
	 * @param session
	 * @param task
	 * @return TaskBean
	 */
	public TaskBean updateTask(Session session, TaskBean task) throws Exception;

	/**
	 * Delete Task
	 * 
	 * @param session
	 * @param task
	 * @return Boolean
	 */
	public Boolean deleteTask(Session session, TaskBean task) throws Exception;

}
