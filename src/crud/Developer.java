package crud;

import java.util.ArrayList;
import java.util.List;

public class Developer {

    private int id;
    private String firstName;
    private String lastName;
    private ArrayList <Skill> skills;
    private Specialty specialty;
    private Status status = Status.ACTIVE;

    public Developer() {
        skills = new ArrayList<Skill>();

//		Developers d = new Developers();
//		DevIN di = new DevIN();
//		d = di.In();
//		if(d==null) {
//			this.id=1;
//		}
//		int idEN = 0;
//		if(d!=null) {
//			for(int i=0; i<d.size(); i++) {
//				if(d.getElement(i).getId()>idEN) {
//					idEN=d.getElement(i).getId();
//				}
//			}
//		this.id=idEN;
//		}
    }

    public void setFirstName(String firstName) {
        this.firstName=firstName;
        setId();
    }

    public String getFirstName() {
        return firstName;

    }

    public void setLastName(String lastName) {
        this.lastName=lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setSkills(String skill) {
        Skill s = new Skill();
        s.setSkill(skill);
        s.setStatus(Status.ACTIVE);
        skills.add(s);

        Skills sk = new Skills();
        sk.addSkill(s);
        SkillOUT out = new SkillOUT();
        out.Out(sk);
    }

    public ArrayList<Skill> getSkills() {
        return skills;
    }

    public void setId() {
        //this.id=id;

        Developers d = new Developers();
        DevIN di = new DevIN();
        d = di.In();
        if(d==null) {
            this.id=1;
        }
        int idEN = 0;
        if(d!=null) {
            for(int i=0; i<d.size(); i++) {
                if(d.getElement(i).getId()>idEN) {
                    idEN=d.getElement(i).getId();
                }
            }
            this.id=idEN+1;
        }


    }

    public int getId() {
        return id;
    }

    public void setSpecialty(String s) {
        specialty=new Specialty();
        specialty.setSpecialty(s);
        specialty.setStatus(Status.ACTIVE);

        Specialties spec = new Specialties();
        spec.addSpecialty(specialty);
        SpecOUT out = new SpecOUT();
        out.Out(spec);

//		Specialty specIN=new Specialty();
//		this.specialty=specIN;
//		this.specialty.setSpecialty(specialty);
//		Specialties spec = new Specialties();
//		spec.addSpecialty(specIN);
//		SpecOUT out = new SpecOUT();
//		out.Out(spec);
    }

    public String getSpecialty() {
        return specialty.getSpecialty();
    }

    public String toString() {
        return "ID: "+id+", "+lastName+" "+firstName+", spec: "+specialty+", skills: "+skills+". STATUS: "+status+".";
    }


    public static void main(String[] args) {


    }

}
