package classes;

public class Employe {
    private String id;
    private String lastname;
    private String firstname;
    private String job;
    private Integer startYear;
    private Integer salary;

    public Employe(String id, String lastname, String firstname, String job, Integer startYear, Integer salary) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.job = job;
        this.startYear = startYear;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getJob() {
        return job;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public Integer getSalary() {
        return salary;
    }

    public String display() {
        return "Employé : Immatriculation : " + this.id + " - " + this.lastname + " " + this.firstname + " (" + this.job + ") - Salaire : " + this.salary + "€";
    }
}
