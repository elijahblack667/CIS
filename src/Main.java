public class Main {

    public static void main(String[] args) {
        Cat cat = new Cat();
        System.out.println("Name is currently " + cat.getName());

        cat.setName("Garfield");
        System.out.println("Name has been changed to " + cat.getName());

        cat.setFavoriteFood("sardines");
        System.out.println("Favorite food has been set to " + cat.getFavoriteFood());

        cat.setAge(4);
        System.out.println("Cat age has been set to " + cat.getAge());

        cat.setName("Buster");
        cat.setName("chupe");
        System.out.print("Here is a history of this cat's names: ");
        cat.getNames().forEach(catName-> System.out.print(catName + " "));
        System.out.println();

        System.out.println("The average length of the cats names is " + cat.getAverageNameLength());

        Data data = new Data("insert_DB_String_HERE");
        data.insert("Cat", cat);
    }


}
