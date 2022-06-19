package crud;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Specialties {

    private ArrayList<Specialty> spec = new ArrayList<>();

    public void addSpecialty(Specialty specialty) {
        spec.add(specialty);
    }

    public ArrayList<Specialty> getSpecialties() {
        return spec;
    }

    public Specialty getElement(int i) {
        return spec.get(i);
    }

    public int size() {
        return spec.size();
    }

    public static void main(String[] args) {


    }

}

class SpecOUT {
    public void Out(Specialties specialties) {
        SpecIN in = new SpecIN();
        Specialties check = new Specialties();
        check = in.In();
        int count = 0;
        if(check!=null) {
            for(int i=0; i<check.size();i++) {
                if(check.getElement(i).toString().equals(specialties.getElement(0).toString()))
                {count++;}
            }
        }
        if(count==0 & check!=null) {
            check.getSpecialties().addAll(specialties.getSpecialties());
            try(FileWriter writer = new FileWriter("C:\\TestCRUD\\TestSpecRepository.json");) {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                gson.toJson(check,writer);
            } catch(IOException e) {
                System.out.println(e);
            }
        } else if (count>0) {
            System.out.println("Элемент уже есть в файле Spec");
        }
        if(check==null) {
            try(FileWriter writer = new FileWriter("C:\\TestCRUD\\TestSpecRepository.json");) {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                gson.toJson(specialties,writer);
                System.out.println("Spec file is created!");
            } catch(IOException e) {
                System.out.println(e);
            }
        }
    }


}


class SpecIN {
    public Specialties In() {
        Specialties sp = new Specialties();
        try(FileReader reader = new FileReader("C:\\TestCRUD\\TestSpecRepository.json");) {
            Gson gson = new Gson();
            sp = gson.fromJson(reader, Specialties.class);
            return sp;
        }
        catch(IOException e) {
            return null;
        }
    }
}