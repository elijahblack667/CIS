import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Pet {

    private String name;
    private int age;
    private String favoriteFood;
    private List<String> names = new ArrayList<>();
    private int speakCounter;

    public Pet() {
        name = "";
        //initializes random age from 5 to 10
        Random random = new Random();
        age = random.nextInt(6) + 5;
        favoriteFood = "";
    }

    public Pet(String initialName) {
        this();
        setName(initialName);
    }

    public double getAverageNameLength(){
        double total = 0.0;
        if(names.size()==0) {
            return total;
        }
        for(String name:names){
            total += name.length();
        }
        return total / names.size();
    }
    public String getName() {
        return name;
    }
    public List<String> getNames() {
        return names;
    }
    public int getAge() {
        return age;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public abstract String getTableName();

    public void setName (String newName) {
        name = newName;
        names.add(newName);
    }

    public void  setAge (int newAge) {
        age = newAge;
    }

    public void  setFavoriteFood ( String newFavoriteFood) {
        favoriteFood = newFavoriteFood;
    }

    public void speak(String input){
        System.out.println(input);
        checkSpeech();
    }

    public abstract void speak();

    public void checkSpeech(){
        speakCounter++;
        //increment age every 5 times the pet speaks. Reset speech counter.
        if(speakCounter==5){
            age++;
            speakCounter=0;
        }
    }

}
