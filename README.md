Overseer
===================

How to run
===================
**Require:** 
: Git, Maven, Deployment tool such as Tomcat

1. Clone project to your workspace

2. Build project by command line

  > mvn package

3. Copy war file from Target folder to deployment location and start server



**Resource Path:**	/Task/webapi/task/getTasks
**Method:**	GET
**Description:**	Get all task list

**Resource Path:** 	/Task/webapi/task/getTask
**Method:** POST
**Description:**	Get specific task by id

**Resource Path:**	/Task/webapi/task/save
**Method:** POST
**Description:**	Create new task or update existing task and return lasted value of that task. If it is created case, it will return value with id. If it is update case, it will return the same value if save success.

**Resource Path:** 	/Task/webapi/task/updateStatus
**Method:** POST
**Description:**	Update status of specific task

**Resource Path:** 	/Task/webapi/task/delete
**Method:** POST
**Description:**	Delete specific task
