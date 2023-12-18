package sakibul.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private int id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$", message = "Incorrect email format")
    @Column(name = "email")
    private String email;

    @NotNull
    @Past
    @AgeLimit
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name="gender")
    private Gender gender;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "quota")
    private Quota quota = Quota.NOTHING;

    @Enumerated(EnumType.STRING)
    @Column(name = "country")
    private Country country=Country.BANGLADESH;

    public Student() {
    }

    public Student(int id, String name, String email, LocalDate dateOfBirth, Gender gender, Quota quota, Country country) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.quota = quota;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Quota getQuota() {
        return quota;
    }

    public void setQuota(Quota quota) {
        this.quota = quota;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
