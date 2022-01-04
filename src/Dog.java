public class Dog extends Pet {

    public Dog() {
        super();
    }

    public Dog(String initialName) {
        super(initialName);
    }

    public String getTableName() {
        return "Dog";
    }
    public void speak(){
        speak("woof");
    }

}
