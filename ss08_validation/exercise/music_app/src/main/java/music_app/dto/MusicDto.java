package music_app.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class MusicDto implements Validator {
    private int id;
    @NotBlank(message = "Khong duoc de trong")
    @Size(max = 800,message = "Khong qua 800 ki tu")
    @Pattern(regexp = "^[a-zA-Z0-9 \\+]*$",message = "Khong chua cac ki tu dac biet nhu @;,.=-+,...")
    private String name;
    @NotBlank(message = "Khong duoc de trong")
    @Size(max = 300,message = "Khong qua 300 ki tu")
    @Pattern(regexp = "^[a-zA-Z0-9 \\+]*$",message = "Khong chua cac ki tu dac biet nhu @;,.=-+,...")
    private String singer;
    @NotBlank(message = "Khong duoc de trong")
    @Size(max = 1000,message = "Khong qua 1000 ki tu")
    @Pattern(regexp = "^[a-zA-Z0-9, \\+]*$",message = "Khong chua ki tu dac biet (ngoai tru dau ',')")
    private String category;
    public MusicDto() {
    }

    public MusicDto(int id, String name, String singer, String category) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        MusicDto musicDto = (MusicDto) target;
        if ("admin".equals(musicDto.getName())) {
            errors.rejectValue("name", "", "Khong duoc dung admin");
        }
    }
}
