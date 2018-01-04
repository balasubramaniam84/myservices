package in.cdac.ageservice.ageservice.resource;

import io.swagger.annotations.ApiModelProperty;

public class User {

	@ApiModelProperty(notes="user Name")
	String userName;
	@ApiModelProperty(notes="user age")
	String age;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String userName, String age) {
		super();
		this.userName = userName;
		this.age = age;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

}
