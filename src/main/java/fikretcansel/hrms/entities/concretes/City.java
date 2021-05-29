package fikretcansel.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="cities")
@NoArgsConstructor
@AllArgsConstructor
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cityId")
    int id;
    @Column(name="cityName")
    String cityName;

    @OneToMany(mappedBy = "city")
    List<JobAdvertisement> jobAdvertisements;
}
