package com.demo.task.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserDto {

	    private int userId;

	    @NotNull(message = "Name cannot be null")
	    @Size(min = 3, max = 100, message = "Name must be between 3 and 100 characters")
	    private String name;
	    
	    private String email;
	    
	    private String password;

	    // Getters and setters
	    public int getUserId() {
	        return userId;
	    }

	    public void setUserId(int userId) {
	        this.userId = userId;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		@Override
		public String toString() {
			return "UserDto [userId=" + userId + ", name=" + name + ", email=" + email + ", password=" + password + "]";
		}
	    
	    
}


