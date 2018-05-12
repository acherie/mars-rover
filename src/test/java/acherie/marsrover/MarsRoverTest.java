package acherie.marsrover;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author wangjie
 * @date 2018/5/12
 */
public class MarsRoverTest {

    @Test
    public void shouldAtRightPositionWhenInit() {
        // given
        MarsRover rover = new MarsRover(0, 0, Direction.N);
        // when
        String position = rover.position();
        // then
        assertThat(position).isEqualTo("0 0 N");
    }

    @Test
    public void shouldNWhenLInN() {
        // given
        MarsRover rover = new MarsRover(0, 0, Direction.N);
        // when
        rover.exec(new LeftCommand());
        // then
        assertThat(rover.position()).isEqualTo("0 0 W");
    }

    @Test
    public void shouldSouthWhenTurnLeftInWest() {
        MarsRover rover = new MarsRover(0, 0, Direction.W);
        rover.exec(new LeftCommand());
        assertThat(rover.position()).isEqualTo("0 0 S");
    }

    @Test
    public void shouldEastWhenSouthTurnLeft() {
        MarsRover rover = new MarsRover(0, 0, Direction.S);
        rover.exec(new LeftCommand());
        assertThat(rover.position()).isEqualTo("0 0 E");
    }

    @Test
    public void shouldNorthWhenEastTurnLeft() {
        MarsRover rover = new MarsRover(0, 0, Direction.E);
        rover.exec(new LeftCommand());
        assertThat(rover.position()).isEqualTo("0 0 N");
    }
}
