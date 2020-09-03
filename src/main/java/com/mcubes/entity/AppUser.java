package com.mcubes.entity;

import com.mcubes.validator.Gender;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.*;


/**
 * Created by A.A.MAMUN on 9/2/2020.
 */
@Entity
public class AppUser {

    @NotBlank(message = "Username must not be blank")
    @Size(min = 3, max = 20, message = "Username mus be at lest 3 character, maximum 20 character")
    private String name;


    @NotNull(message = "Age must not be blank")
    @Min(value = 18, message = "Age less than 18 is not allow")
    @Max(value = 100, message = "Maximum value of age is 100")
    private int age;

    @NotBlank(message = "Gender must not be blank")
    @Gender(message = "Invalid gender type", types = {"Male", "Female"})
    private String gender;

    @Pattern(regexp = "[0-9]+", message = "Invalid phone number")
    private String phone;

    @Id
    @NotBlank(message = "Email address must not be blank")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Password must not be blank")
    @Size(min = 8, message = "Password length must be at lest 8 character")
    private String password;


    public AppUser() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
        return "AppUser{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
