package fikretcansel.hrms.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResultDto<T> {

    private T user;

    private boolean isEmailVerified;


}
