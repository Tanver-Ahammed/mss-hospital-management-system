package com.mss.hms.entities;

import jakarta.persistence.*;
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

    private String name;

}
