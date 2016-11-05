Overseer
===================
**Resource Path:**	/Task/webapi/task/getTasks
**Method:**	GET
**Description:**	Get all task list
**Output:**

Field | Content | Type
- |-|-
ResultJson |	Result Json
success|Status|Integer (0 = Failed, 1 = Success)
result|Result Object|TaskBean
message|Response Message|String
errorMessage|Error Message|String
TaskBean|Task Data
id|Task ID|Integer
subject|Task Subject|String
detail|Task Detail|String
Status|Task Status|Integer (0 = Inactive, 1 = Active)


Example Output:
: -Error case
>{
>     success: 0,
>     result: {null},
>     message: “SEARCH_FAILED”,
>     errorMessage: “Connection refused”
>}
: -Success case with data
>{
>     success: 1,
>     result: [ { id: 1,
>                       subject: “Study English”,
>                       detail: “English 101 – Friday Night”,
>                       status: 1 },
>                     { id: 2,
>                       subject: “Math Homework”,
>                       detail: “Due date 9 November”,
>                       status: 0 } ],
>     message: “SEARCH_SUCCESS”,
>     errorMessage: “”
>}

-	Success case with no data
{
     success: 1,
     result: “”,
     message: “SEARCH_SUCCESS”,
     errorMessage: “”
}




Resource Path: 	/Task/webapi/task/getTask
Method:	POST
Description:	Get specific task by id
Input:
Field	Content	Input	Type
TaskBean	Task Data
Id	Task ID	Mandatory	Integer
Subject	Task Subject	Optional	String
detail	Task Detail	Optional	String
status	Task Status	Optional	Integer (0 = Inactive, 1 = Active)

Output:
Field	Content	Type
ResultJson	Result Json
success	Status	Integer (0 = Failed, 1 = Success)
result	Result Object	TaskBean
message	Response Message	String
errorMessage	Error Message	String
TaskBean	Task Data
id	Task ID	Integer
subject	Task Subject	String
detail	Task Detail	String
Status	Task Status	Integer (0 = Inactive, 1 = Active)


Example Input:
{
     id: 1
}

Example Output:
-	Error case
{
     success: 0,
     result: {null},
     message: “SEARCH_FAILED”,
     errorMessage: “Connection refused”
}

-	Success case
{
     success: 1,
     result: { id: 1,
                     subject: “Study English”,
                     detail: “English 101 – Friday Night”,
                     status: 1 },
     message: “SEARCH_SUCCESS”,
     errorMessage: “”
}


Resource Path: 	/Task/webapi/task/save
Method:	POST
Description:	Create new task or update existing task and return lasted value of that task. If it is created case, it will return value with id. If it is update case, it will return the same value if save success.
Input:
Field	Content	Input	Type
TaskBean	Task Data
Id	Task ID	Optional	Integer
Subject	Task Subject	Mandatory	String
detail	Task Detail	Optional	String
status	Task Status	Optional	Integer (0 = Inactive, 1 = Active)

Output:
Field	Content	Type
ResultJson	Result Json
success	Status	Integer (0 = Failed, 1 = Success)
result	Result Object	TaskBean
message	Response Message	String
errorMessage	Error Message	String
TaskBean	Task Data
id	Task ID	Integer
subject	Task Subject	String
detail	Task Detail	String
Status	Task Status	Integer (0 = Inactive, 1 = Active)

Example Input:
-	Create new task
{
     subject: “Shopping Grocerry”,
     detail: “Meat, vegetables and beverages”
}

-	Update existing task
{
     id: 2
     subject: “Shopping Grocerry”,
     detail: “Milk, eggs, chess, butter, cream, yellow pepper, avocados and bananas”,
     status: 1
}

Example Output:
-	Error case
{
     success: 0,
     result: {null},
     message: “SAVE_FAILD”,
     errorMessage: “Cannot find data to update”
}


-	Success case
{
     success: 1,
     result: { id: 1,
                     subject: “Study English”,
                     detail: “English 101 – Friday Night”,
                     status: 1 },
     message: “SAVE_SUCCESS”,
     errorMessage: “”
}













Resource Path: 	/Task/webapi/task/updateStatus
Method:	POST
Description:	Update status of specific task
Input:
Field	Content	Input	Type
TaskBean	Task Data
Id	Task ID	Mandatory	Integer
Subject	Task Subject	Optional	String
detail	Task Detail	Optional	String
status	Task Status	Mandatory	Integer (0 = Inactive, 1 = Active)

Output:
Field	Content	Type
ResultJson	Result Json
success	Status	Integer (0 = Failed, 1 = Success)
result	Result Object	Boolean
message	Response Message	String
errorMessage	Error Message	String

Example Input:
{
     id: 1,
     status: 0,
}
Example Output:
-	Error case
{
     success: 0,
     result: false,
     message: “SAVE_FAILED”,
     errorMessage: “Connection refused”
}

-	Success case
{
     success: 1,
     result: true,
     message: “SAVE_SUCCESS”,
     errorMessage: “”
}








Resource Path: 	/Task/webapi/task/delete
Method:	POST
Description:	Delete specific task
Input:
Field	Content	Input	Type
TaskBean	Task Data
Id	Task ID	Mandatory	Integer
Subject	Task Subject	Optional	String
detail	Task Detail	Optional	String
status	Task Status	Optional	Integer (0 = Inactive, 1 = Active)

Output:
Field	Content	Type
ResultJson	Result Json
success	Status	Integer (0 = Failed, 1 = Success)
result	Result Object	Boolean
message	Response Message	String
errorMessage	Error Message	String

Example Input:
{
     id: 1
}

Example Output:
-	Error case
{
     success: 0,
     result: false,
     message: “DELETE_FAILED”,
     errorMessage: “Connection refused”
}

-	Success case
{
     success: 1,
     result: true,
     message: “DELETE_SUCCESS”,
     errorMessage: “”
}

