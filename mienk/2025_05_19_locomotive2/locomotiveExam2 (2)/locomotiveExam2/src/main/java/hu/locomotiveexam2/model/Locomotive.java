package hu.locomotiveexam2.model;

import hu.locomotiveexam2.enumeration.Driving;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Locomotive {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer lengthCm;
    private Double maxSpeed;

    @Column(name = "driving_id")
    @Enumerated(EnumType.STRING)
    private Driving driving;
}
