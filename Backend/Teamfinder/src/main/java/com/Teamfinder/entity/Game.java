package com.Teamfinder.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "games")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Game {
    @TableGenerator(
            name = "gamesGenerator",
            allocationSize = 1,
            initialValue = 1)
    @Id
    @GeneratedValue(
            strategy=GenerationType.TABLE,
            generator="gamesGenerator")
    @Column(name = "\"ID_game\"")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "filename")
    private String filename;
}
