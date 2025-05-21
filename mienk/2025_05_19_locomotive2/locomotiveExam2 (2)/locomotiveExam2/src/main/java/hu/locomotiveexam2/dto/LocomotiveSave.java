package hu.locomotiveexam2.dto;

import hu.locomotiveexam2.enumeration.Driving;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LocomotiveSave {
    private String name;
    private Integer lengthCm;
    private Double maxSpeed;
    private Driving driving;
}
