import java.util.Arrays;
import java.util.List;

public class DataTasks {

    Data data;

    public  DataTasks() {
        data = new Data("databaseURL");
    }

    public static void main(String[] args) {
        DataTasks task = new DataTasks();

        Cat cat = new Cat("trixie");
        task.insertPet(cat);
        Dog dog = new Dog("meeko");
        task.insertPet(dog);
    }

    public void insertPet(Pet pet) {
        //only proceed if no exception is thrown from beginning the transaction
        if(data.beginTran())
        {
            //only commit transaction if no exception is thrown by inserting
            if(data.insert(pet.getTableName(), pet) > -1) {
                data.commit();
            }
            //rollback if exception was thrown
            else {
                data.rollback();
            }
        }

    }

    public void savePetShop() {
        List<Pet> newPets = Arrays.asList(
                new Cat("kittenboi"),
                new Cat("terpy"),
                new Cat("sudi"),
                new Dog("milo"),
                new Dog("buster"),
                new Dog("chenzo")
                );

        newPets.forEach( (pet) -> insertPet(pet));

    }
}
