package com.Teamfinder.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_types")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Role {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "\"ID_user_type\"")
    private Long id;
    @Column(name = "name")
    private String name;
}
