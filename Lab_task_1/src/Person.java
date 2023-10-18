import java.time.LocalDate;

public class Person {
    private String id;
    private String name;
    private LocalDate birthDay;
    private String email;
    private LocalDate joiningDay;


    public Person(String id, String name, LocalDate birthDay, String email, LocalDate joiningDay) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
        this.email = email;
        this.joiningDay = joiningDay;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getJoiningDay() {
        return joiningDay;
    }

    public void setJoiningDay(LocalDate joiningDay) {
        this.joiningDay = joiningDay;
    }
    public void showDetails(){
        System.out.println("ID: "+getId());
        System.out.println("Name: "+getName());
        System.out.println("Email: "+getEmail());
        System.out.println("Birthday: "+getBirthDay());
        System.out.println("Joining data:"+ getJoiningDay());
    }
}
