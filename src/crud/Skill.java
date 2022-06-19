package crud;

public class Skill {
    private String skill;
    private Status status;

    public static void main(String[] args) {


    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill=skill;
    }

    public void setStatus(Status status) {
        this.status=status;
    }

    public Status getStatus() {
        return status;
    }


    public String toString() {
        return skill;
    }

}
