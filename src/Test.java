import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Test {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    public void testCatAge() {
        Cat cat = new Cat();
        assert (cat.getAge() >= 5 && cat.getAge() <= 10);
    }

    public void testCatAverageNameLength() {
        Cat cat = new Cat();
        cat.setName("kitten");
        cat.setName("kitten2");
        cat.setName("kitten22");
        assert(cat.getAverageNameLength() == 7.0);
    }

    public void testCatFavoriteFood() {
        Cat cat = new Cat();
        cat.setFavoriteFood("sardines");

        assert(cat.getFavoriteFood().equals("sardines"));
    }

    public void testCatMeow() {
        System.setOut(new PrintStream(outputStream));
        Cat cat  = new Cat();
        cat.speak();
        assert (outputStream.toString().equals("meow\n"));
        System.setOut(System.out);
    }

    public void testCatName() {
        Cat cat = new Cat("testName");
        assert (cat.getName().equals("testName"));
    }

    public void testCatNamesList() {
        Cat cat = new Cat();
        cat.setName("polly");
        cat.setName("greta");
        cat.setName("amber");
        cat.setName("marsha");

        assert (cat.getNames().size() == 4);

    }

    public void testCatSpeak() {
        System.setOut(new PrintStream(outputStream));
        Cat cat  = new Cat();
        cat.speak("testSpeech");
        assert (outputStream.toString().equals("testSpeech\n"));
    }
}

