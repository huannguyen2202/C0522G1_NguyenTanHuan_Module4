package validate_form.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class UserDto implements Validator {
    private int id;
    @NotBlank(message = "Khong duoc de trong!")
    @Size(min = 5, max = 45, message = "Tên co tu 5-45 ki tu")
    private String firstName;
    @NotBlank(message = "Khong duoc de trong!")
    @Size(min = 5, max = 45, message = "Tên co tu 5-45 ki tu")
    private String lastName;
    @NotBlank(message = "Khong duoc de trong!")
    @Pattern(regexp = "[0][0-9]{9}", message = "So dien thoai phai bat dau bang so 0 va 9 so bat ki theo sau")
    private String phoneNumber;
    @NotBlank(message = "Khong duoc de trong!")
    @Max(value = 80, message = "Tuoi phai nho hon hoac bang 80 tuoi")
    @Min(value = 18, message = "Tuoi phai lon hon hoac bang 18 tuoi")
    private String age;
    @NotBlank(message = "Khong duoc de trong!")
    @Pattern(regexp = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]{2,}(\\.[A-Za-z0-9]{2,}){1,2}$", message = "Email phai dung dinh dang")
    private String email;

    public UserDto() {
    }

    public UserDto(int id, String firstName, String lastName, String phoneNumber, String age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        if ("admin".equals(userDto.getFirstName())) {
            errors.rejectValue("firstName", "", "Khong duoc dung admin");
        }
    }
}
