package Overseer.Task.bean;

public enum ResultMessageEnum {

	DELETE_SUCCESS("Delete Success"), //
	DELETE_FAILED("Delete Failed"), //
	SAVE_SUCCESS("Save Success"), //
	SAVE_FAILED("Save Failed"), //
	SEARCH_SUCCESS("Search Success"), //
	SEARCH_FAILED("Search Failed"), //
	;

	private String message;

	private ResultMessageEnum(String message) {
		this.message = message;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

}
