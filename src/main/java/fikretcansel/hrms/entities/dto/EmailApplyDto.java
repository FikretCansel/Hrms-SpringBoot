package fikretcansel.hrms.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
public class EmailApplyDto {
    @Min(0)
    private int userId;
    @Length(max = 4,min=4)
    private String code;
}
