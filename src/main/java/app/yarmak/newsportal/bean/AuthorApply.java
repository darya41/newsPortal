package app.yarmak.newsportal.bean;

import java.io.Serializable;
import java.util.Objects;

public class AuthorApply implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String firstName;
	private String lastName;
	private String email;
	private String bio;
	private String specialization;
	private String workExamples;
	private String phone;
	private String socialLinks;
	    
	public AuthorApply(String firstName, String lastName, String email, String bio, String specialization, String workExamples, String phone, String socialLinks) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.bio = bio;
		this.specialization = specialization;
		this.workExamples = workExamples;
		this.phone = phone;
		this.socialLinks = socialLinks;
	}

	public AuthorApply() {
		
	}
	  
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBio() {
	   return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	    public String getWorkExamples() {
	        return workExamples;
	    }

	    public void setWorkExamples(String workExamples) {
	        this.workExamples = workExamples;
	    }

	    public String getPhone() {
	        return phone;
	    }

	    public void setPhone(String phone) {
	        this.phone = phone;
	    }

	    public String getSocialLinks() {
	        return socialLinks;
	    }

	    public void setSocialLinks(String socialLinks) {
	        this.socialLinks = socialLinks;
	    }
	    
	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj) return true;
	        if (obj == null || getClass() != obj.getClass()) return false;
	        AuthorApply that = (AuthorApply) obj;
	        return Objects.equals(firstName, that.firstName) &&
	                Objects.equals(lastName, that.lastName) &&
	                Objects.equals(email, that.email) &&
	                Objects.equals(bio, that.bio) &&
	                Objects.equals(specialization, that.specialization) &&
	                Objects.equals(workExamples, that.workExamples) &&
	                Objects.equals(phone, that.phone) &&
	                Objects.equals(socialLinks, that.socialLinks) ;
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(firstName, lastName, email, bio, 
	        		specialization, workExamples, phone, socialLinks);
	    }
	    
	    @Override
	    public String toString() {
	        return "AuthorApply{" +
	                "firstName='" + firstName + '\'' +
	                ", lastName='" + lastName + '\'' +
	                ", email='" + email + '\'' +
	                ", bio='" + bio + '\'' +
	                ", specialization='" + specialization + '\'' +
	                ", workExamples='" + workExamples + '\'' +
	                ", phone='" + phone + '\'' +
	                ", socialLinks='" + socialLinks + '\'' +
	                '}';
	    }
}



