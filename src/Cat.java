public class Cat extends Pet {

    public Cat() {
       super();
    }

    public Cat(String initialName) {
        super(initialName);
    }

    public String getTableName() {
        return "Cat";
    }

    public void speak(){
        speak("meow");
    }

}
