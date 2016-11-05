package Overseer.Task;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import Overseer.Task.bean.ResultJson;
import Overseer.Task.bean.ResultMessageEnum;
import Overseer.Task.bean.TaskBean;
import Overseer.Task.service.TaskService;

@Path("/task")
public class TaskResource {

	@Autowired
	private TaskService taskService;

	/**
	 * Get All Tasks
	 * 
	 * @return
	 */
	@GET
	@Path("/getTasks")
	@Produces(MediaType.APPLICATION_JSON)
	public ResultJson getTaskList() {

		try {

			List<TaskBean> result = taskService.getTaskList();
			return new ResultJson(1, result, ResultMessageEnum.SEARCH_SUCCESS.getMessage(), "");

		} catch (Exception exception) {

			return new ResultJson(0, null, ResultMessageEnum.SEARCH_FAILED.getMessage(), exception.getMessage());

		}

	}

	/**
	 * Get a Task by ID
	 * 
	 * @param task
	 * @return
	 */
	@POST
	@Path("/getTask")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ResultJson getTask(TaskBean task) {

		try {

			TaskBean result = taskService.getTask(task);
			return new ResultJson(1, result, ResultMessageEnum.SEARCH_SUCCESS.getMessage(), "");

		} catch (Exception exception) {

			return new ResultJson(0, null, ResultMessageEnum.SEARCH_FAILED.getMessage(), exception.getMessage());

		}

	}

	/**
	 * Use to Create new Task or Edit existing Task
	 * 
	 * @param task
	 * @return
	 */
	@POST
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ResultJson saveTask(TaskBean task) {

		try {

			TaskBean result = taskService.saveTask(task);
			return new ResultJson(1, result, ResultMessageEnum.SAVE_SUCCESS.getMessage(), "");

		} catch (Exception exception) {

			return new ResultJson(0, null, ResultMessageEnum.SAVE_FAILED.getMessage(), exception.getMessage());

		}

	}

	/**
	 * Update Status
	 * 
	 * @param task
	 * @return
	 */
	@POST
	@Path("/updateStatus")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ResultJson updateStatus(TaskBean task) {

		try {

			Boolean result = taskService.updateStatus(task);
			return new ResultJson(1, result, ResultMessageEnum.SAVE_SUCCESS.getMessage(), "");

		} catch (Exception exception) {

			return new ResultJson(0, false, ResultMessageEnum.SAVE_FAILED.getMessage(), exception.getMessage());

		}

	}

	/**
	 * Delete Task
	 * 
	 * @param task
	 * @return
	 */
	@POST
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ResultJson deleteTask(TaskBean task) {

		try {

			Boolean result = taskService.deleteTask(task);
			return new ResultJson(1, result, ResultMessageEnum.DELETE_SUCCESS.getMessage(), "");

		} catch (Exception exception) {

			return new ResultJson(0, false, ResultMessageEnum.DELETE_FAILED.getMessage(), exception.getMessage());

		}

	}

}
