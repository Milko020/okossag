package hu.locomotiveexam2.dto;

import hu.locomotiveexam2.enumeration.Driving;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LocomotiveListItem {
    private String name;
    private Driving driving;
}
