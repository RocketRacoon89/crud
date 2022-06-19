package crud;

public class Specialty {

    private String specialty;
    private Status status;


    public static void main(String[] args) {

    }

    public boolean equals(Specialty s1, Specialty s2) {
        if(this.specialty==s2.toString()) return true;
        else
            return false;
    }

    public void setSpecialty(String specialty) {
        this.specialty=specialty;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setStatus(Status status) {
        this.status=status;
    }

    public Status getStatus() {
        return status;
    }


    public String toString() {
        return specialty;
    }

}
