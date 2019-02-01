import org.junit.Assert;
import org.junit.Test;

public class SimulationTest {
    @Test
    public void givenOneFemale_whenSimulate_thenReturnsCorrectly() {
        // given
        Simulation simulation = new Simulation(0, 1, 1000);

        // when
        int actual = simulation.simulate();

        // then
        Assert.assertEquals(actual, 11);
    }
}
