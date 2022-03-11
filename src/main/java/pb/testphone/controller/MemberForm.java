package pb.testphone.controller;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class MemberForm {

    private Long id;

    @NotEmpty(message = "이름은 필수값입니다.")
    private String name;
    private String department;

}
