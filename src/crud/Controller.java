package crud;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {

    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.homeFolder();
        controller.start();
    }

    public void start() {
        System.out.println("Для создания нового Developer введите \"1\"");
        System.out.println("Для создания нового Skill введите \"2\"");
        System.out.println("Для создания нового Speciality введите \"3\"");
        System.out.println("Для получения списка Developer \"4\"");
        System.out.println("Для получения списка Skill введите \"5\"");
        System.out.println("Для получения списка Speciality введите \"6\"");
        System.out.println("Для удаления Developer \"7\"");
        System.out.println("Для удаления Skill введите \"8\"");
        System.out.println("Для удаления Speciality введите \"9\"");
        System.out.println("Для выхода введите \"0\"");

        Scanner s = new Scanner(System.in);
        int i = s.nextInt();
        if(i==1) createDev();
        if(i==2) createSkill();
        if(i==3) createSpecialty();
        if(i==4) viewDev();
        if(i==5) viewSkill();
        if(i==6) viewSpec();
        if(i==7) delDev();
        if(i==8) delSkill();
        if(i==9) delSpec();
        if(i==0) System.exit(0);
    }

    public void createDev() {

        Developer dev = new Developer();
        System.out.println("Создание нового Developer.");
        System.out.println("Введите firstName");
        Scanner f = new Scanner(System.in);
        String firstName = f.next();
        dev.setFirstName(firstName);

        System.out.println("Введите lastName");
        Scanner l = new Scanner(System.in);
        String lastName = f.next();
        dev.setLastName(lastName);

        System.out.println("Введите speciality");
        Scanner sp = new Scanner(System.in);
        String specialty = sp.next();
        dev.setSpecialty(specialty);

        int com = 1;
        while(com==1) {
            System.out.println("Введите Skill");
            Scanner sk = new Scanner(System.in);
            String Skill = sk.next();
            dev.setSkills(Skill);
            System.out.println("Если требуется ввести еще один skill введите \"1\"");
            Scanner scanner = new Scanner(System.in);
            int res = scanner.nextInt();
            com=res;
        }
        Developers developers = new Developers();
        developers.addDevelopers(dev);
        DevOUT out = new DevOUT();
        out.Out(developers);
        System.out.println("Developer создан");
        start();
    }

    public void createSkill() {
        System.out.println("Создание нового Skill.");
        Scanner scanner = new Scanner(System.in);
        String skill = scanner.next();
        Skill s = new Skill();
        s.setSkill(skill);
        Skills skills = new Skills();
        skills.addSkill(s);
        SkillOUT out = new SkillOUT();
        out.Out(skills);
        start();
    }

    public void createSpecialty() {
        System.out.println("Создание нового Specialty.");
        Scanner scanner = new Scanner(System.in);
        String specialty = scanner.next();
        Specialty s = new Specialty();
        s.setSpecialty(specialty);
        Specialties spec = new Specialties();
        spec.addSpecialty(s);
        SpecOUT out = new SpecOUT();
        out.Out(spec);
        start();
    }

    public void viewDev() {
        Developers devs = new Developers();
        DevIN in = new DevIN();
        devs = in.In();
        for(int i=0; i<devs.size(); i++) {
            System.out.println(devs.getElement(i));
        }
        start();
    }

    public void viewSkill() {
        Skills skills = new Skills();
        SkillIN in = new SkillIN();
        skills = in.In();
        for(int i=0; i<skills.size(); i++) {
            System.out.println(skills.getElement(i));
        }
        start();
    }

    public void viewSpec() {
        Specialties spec = new Specialties();
        SpecIN in = new SpecIN();
        spec = in.In();
        for(int i=0; i<spec.size(); i++) {
            System.out.println(spec.getElement(i));
        }
        start();
    }

    public void delDev() {
        System.out.println("Введите ID Developer для изменения");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        Developers dev = new Developers();
        DevIN in = new DevIN();
        dev=in.In();
        for(int i=0; i<dev.size(); i++) {
            if(dev.getElement(i).getId()==id) {
                if(dev.getElement(i).getStatus()==Status.ACTIVE) {dev.getElement(i).setStatus(Status.DELETED); break;}
                if(dev.getElement(i).getStatus()==Status.DELETED) {dev.getElement(i).setStatus(Status.ACTIVE); break;}
            }
        }
        try {
            File file = new File("C:\\TestCRUD\\TestDevRepository.json");
            file.delete();
            DevOUT out = new DevOUT();
            out.Out(dev);
        } catch(Exception e) {

        }
        start();
    }

    public void delSkill() {
        System.out.println("Введите String Skill для изменения");
        Scanner scanner = new Scanner(System.in);
        String sk = scanner.next();
        Skills skills = new Skills();
        SkillIN in = new SkillIN();
        skills = in.In();
        for(int i=0; i<skills.size(); i++) {
            if(skills.getElement(i).getSkill().equals(sk)) {
                if(skills.getElement(i).getStatus()==Status.ACTIVE) {skills.getElement(i).setStatus(Status.DELETED); break;}
                if(skills.getElement(i).getStatus()==Status.DELETED) {skills.getElement(i).setStatus(Status.ACTIVE); break;}
            }

        }
        try {
            File file = new File("C:\\TestCRUD\\TestSkillRepository.json");
            file.delete();
            SkillOUT out = new SkillOUT();
            out.Out(skills);
        } catch (Exception e) {

        }
        start();
    }

    public void delSpec() {
        System.out.println("Введите String Specialty для изменения");
        Scanner scanner = new Scanner(System.in);
        String sp = scanner.next();
        Specialties spec = new Specialties();
        SpecIN in = new SpecIN();
        spec = in.In();
        for(int i=0; i<spec.size(); i++) {
            if(spec.getElement(i).getSpecialty().equals(sp)) {
                if(spec.getElement(i).getStatus()==Status.ACTIVE) {spec.getElement(i).setStatus(Status.DELETED); break;}
                if(spec.getElement(i).getStatus()==Status.DELETED) {spec.getElement(i).setStatus(Status.ACTIVE); break;}
            }
        }
        try {
            File file = new File("C:\\TestCRUD\\TestSpecRepository.json");
            file.delete();
            SpecOUT out = new SpecOUT();
            out.Out(spec);
        } catch (Exception e) {

        }
        start();
    }

    public void homeFolder() {
        File file = new File("C:\\TestCRUD\\");
        if(!file.exists()) {
            try {
                file.mkdir();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

}


