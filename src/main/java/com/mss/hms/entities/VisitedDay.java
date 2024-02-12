package com.mss.hms.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "visited_days")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VisitedDay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "day's name can't be empty!!")
    @Size(min = 3, max = 20, message = "day's name must be min of 3 to 100 character")
    private String name;

}
