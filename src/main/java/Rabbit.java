public class Rabbit {
    private int age;

    public Rabbit() {
        age = 0;
    }

    public int getAge() {
        return age;
    }

    public void age() {
        age++;
    }

    public boolean isFertile() {
        return age >= 4;
    }
}
