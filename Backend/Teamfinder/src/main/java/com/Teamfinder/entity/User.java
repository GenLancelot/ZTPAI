package com.Teamfinder.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "\"ID_user\"")
    private Long id;
    @Column(name = "email")
    private String login;
    @ManyToOne
    @JoinColumn(name = "\"ID_user_type\"")
    private Role role;
    @Column(name = "password")
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String login, Role role, String password) {
        this.login = login;
        this.role = role;
        this.password = password;

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Long getId() {
        return this.id;
    }


    public Role getRole() {
        return this.role;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isAdmin(){
        return this.role.getName().equals("admin");
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof User))
            return false;
        User user = (User) o;
        return Objects.equals(this.id, user.id) && Objects.equals(this.login, user.login)
                && Objects.equals(this.role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.login, this.role);
    }

    @Override
    public String toString() {
        return "User{" + "id=" + this.id + ", login='" + this.login + '\'' + ", role='" + this.role + '\'' + '}';
    }
}