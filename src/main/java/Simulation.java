import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private final int DEATH_TIME = 96;
    private final int FEMALE_BREED = 14;
    private final int MALE_BREED = 5;

    private List<Rabbit> femaleRabbits;
    private List<Rabbit> maleRabbits;

    private int maleCount;
    private int femaleCount;
    private long limit;

    public Simulation(int maleCount,
                      int femaleCount,
                      long limit) {
        this.maleCount = maleCount;
        this.femaleCount = femaleCount;
        this.limit = limit;

        maleRabbits = new ArrayList<Rabbit>();
        femaleRabbits = new ArrayList<Rabbit>();
    }

    public int simulate() {
        init();

        int months = 0;
        while(getRabbitsCount() < limit) {
            age();
            breed();
            kill();

            months++;
        }

        return months;
    }

    private void init() {
        for (int i = 0; i < maleCount; i++) {
            maleRabbits.add(new Rabbit());
        }
        for (int i = 0; i < femaleCount; i++) {
            femaleRabbits.add(new Rabbit());
        }
    }

    private void breed() {
        int maleRabbitsToAdd = 0;
        int femaleRabbitsToAdd = 0;

        for (Rabbit rabbit : femaleRabbits) {
            if(rabbit.isFertile()) {
                maleRabbitsToAdd += MALE_BREED;
                femaleRabbitsToAdd += FEMALE_BREED;
            }
        }

        addRabbits(maleRabbits, maleRabbitsToAdd);
        addRabbits(femaleRabbits, femaleRabbitsToAdd);
    }

    private void addRabbits(List<Rabbit> rabbits, int count) {
        for (int i = 0; i < count; i++) {
            rabbits.add(new Rabbit());
        }
    }

    private void kill() {
        killRabbits(maleRabbits);
        killRabbits(femaleRabbits);
    }

    private void age() {
        ageRabbits(maleRabbits);
        ageRabbits(femaleRabbits);
    }

    private void ageRabbits(List<Rabbit> rabbits) {
        for (Rabbit rabbit : rabbits) {
            rabbit.age();
        }
    }

    private void killRabbits(List<Rabbit> rabbits) {
        List<Rabbit> rabbitsToRemove = new ArrayList<Rabbit>();

        for (Rabbit rabbit : rabbits) {
            if(rabbit.getAge() == DEATH_TIME) {
                rabbitsToRemove.add(rabbit);
            }
        }
        rabbits.removeAll(rabbitsToRemove);
    }

    private int getRabbitsCount() {
        return maleRabbits.size() + femaleRabbits.size();
    }
}
