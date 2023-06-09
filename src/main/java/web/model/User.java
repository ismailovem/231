package web.model;

import javax.persistence.*;

@Table(name="users")
@Entity(name="User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="lastName")
    private String lastName;

    public User() {}

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "User: " +
                "id=" + id
                + ", name='" + name
                + ", lastName='" + lastName;
    }
}
