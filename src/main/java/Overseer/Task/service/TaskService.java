package Overseer.Task.service;

import java.util.List;

import Overseer.Task.bean.TaskBean;

public interface TaskService {

	/**
	 * Get All Task
	 * 
	 * @return List<TaskBean>
	 */
	public List<TaskBean> getTaskList() throws Exception;

	/**
	 * Get Task by ID
	 * 
	 * @param task
	 * @return TaskBean
	 */
	public TaskBean getTask(TaskBean task) throws Exception;

	/**
	 * Save Task
	 * 
	 * @param task
	 * @return TaskBean
	 */
	public TaskBean saveTask(TaskBean task) throws Exception;

	/**
	 * Update Status
	 * 
	 * @param task
	 * @return Boolean
	 */
	public Boolean updateStatus(TaskBean task) throws Exception;

	/**
	 * Delete Task
	 * 
	 * @param task
	 * @return Boolean
	 */
	public Boolean deleteTask(TaskBean task) throws Exception;

}
