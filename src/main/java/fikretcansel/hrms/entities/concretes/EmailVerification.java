package fikretcansel.hrms.entities.concretes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="EmailVerification")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailVerification{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="code")
    private String code;

    @Column(name="isVerified")
    private boolean isVerified;

    @Column(name="user_id")
    private int userId;

    @Column(name = "saveDate")
    private Date saveDate;

    public boolean isVerified() {
        return this.isVerified;
    }

}
