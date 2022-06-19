package crud;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Skills {

    private ArrayList<Skill> skills = new ArrayList<>();

    public void addSkill(Skill skill) {
        this.skills.add(skill);
    }

    public ArrayList<Skill> getSpecialties() {
        return skills;
    }

    public Skill getElement(int i) {
        return skills.get(i);
    }

    public int size() {
        return skills.size();
    }





    public static void main(String[] args) {

    }

}

class SkillOUT {
    public void Out(Skills skills) {
        SkillIN in = new SkillIN();
        Skills check = new Skills();
        check = in.In();
        int count = 0;
        if(check!=null) {
            for(int i=0; i<check.size();i++) {
                if(check.getElement(i).toString().equals(skills.getElement(0).toString()))
                {count++;}
            }
        }
        if(count==0 & check!=null) {
            check.getSpecialties().addAll(skills.getSpecialties());
            try(FileWriter writer = new FileWriter("C:\\TestCRUD\\TestSkillRepository.json");) {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                gson.toJson(check,writer);
            } catch(IOException e) {
                System.out.println(e);
            }
        } else if (count>0) {
            System.out.println("Элемент уже есть в файле Skill");
        }
        if(check==null) {
            try(FileWriter writer = new FileWriter("C:\\TestCRUD\\TestSkillRepository.json");) {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                gson.toJson(skills,writer);
                System.out.println("Skill file is created!");
            } catch(IOException e) {
                System.out.println(e);
            }
        }
    }




}

class SkillIN {
    public Skills In() {

        Skills s = new Skills();
        try(FileReader reader = new FileReader("C:\\TestCRUD\\TestSkillRepository.json");) {
            Gson gson = new Gson();
            s = gson.fromJson(reader, Skills.class);
            return s;
        }
        catch(IOException e) {
            return null;
        }
    }
}
