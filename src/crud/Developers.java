package crud;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Developers {

    private ArrayList <Developer> developers = new ArrayList<>();


    public void addDevelopers(Developer developer) {
        developers.add(developer);
    }

    public ArrayList<Developer> getDevelopers() {
        return developers;
    }

    public Developer getElement(int i) {
        return developers.get(i);
    }

    public int size() {
        return developers.size();
    }

    public static void main(String[] args) {


    }


}

class DevOUT {
    public void Out(Developers developers) {

        DevIN in = new DevIN();
        Developers check = new Developers();
        //if((check = in.In()).size()!=0) {
        if((check = in.In())!=null) {
            for(int i=0; i<developers.size(); i++) {
                check.addDevelopers(developers.getElement(i));
            }

            try(Writer writer = new FileWriter("C:\\TestCRUD\\TestDevRepository.json");) {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                gson.toJson(check, writer);
            }
            catch (IOException e) {

            }
        }
        else {
            try (Writer writer = new FileWriter("C:\\TestCRUD\\TestDevRepository.json");)
            {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                gson.toJson(developers, writer);
                System.out.println("Done!");
            }
            catch(IOException e) {
                System.out.println(e);
            }
        }
    }
}

class DevIN {
    public Developers In() {
        Developers dev = new Developers();
        try (Reader reader = new FileReader("C:\\TestCRUD\\TestDevRepository.json");)
        {
            Gson gson = new Gson();
            dev = gson.fromJson(reader, Developers.class);
            return dev;


        }
        catch (IOException e) {
            System.out.println("File for developers is not exists!");
            try{
                File outFile = new File("C:\\TestCRUD\\TestDevRepository.json");
                outFile.createNewFile();
                System.out.println("File for developers create");
            }
            catch(IOException y) {
                System.out.println(y);
            }


            return null;

        }
    }
}
