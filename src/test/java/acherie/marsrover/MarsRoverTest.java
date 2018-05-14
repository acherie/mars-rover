package acherie.marsrover;

import acherie.marsrover.command.LeftPositionCommand;
import acherie.marsrover.command.MoveCommand;
import acherie.marsrover.command.RightPositionCommand;
import org.junit.Test;

import static acherie.marsrover.Direction.*;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author wangjie
 * @date 2018/5/12
 */
public class MarsRoverTest {

    @Test
    public void shouldAtRightPositionWhenInit() {
        // given
        MarsRover rover = new MarsRover(0, 0, N);
        // when
        String position = rover.position();
        // then
        assertThat(position).isEqualTo("0 0 N");
    }

    @Test
    public void shouldNWhenLInN() {
        testTurnLeftCommand(N, W);
    }

    @Test
    public void shouldSouthWhenTurnLeftInWest() {
        testTurnLeftCommand(W, S);
    }

    @Test
    public void shouldEastWhenSouthTurnLeft() {
        testTurnLeftCommand(S, E);
    }

    @Test
    public void shouldNorthWhenEastTurnLeft() {
        testTurnLeftCommand(E, N);
    }

    private void testTurnLeftCommand(Direction original, Direction target) {
        MarsRover rover = new MarsRover(0, 0, original);
        rover.exec(new LeftPositionCommand());
        assertThat(rover.position()).isEqualTo("0 0 " + target);
    }

    @Test
    public void shouldEastWhenNorthTurnRight() {
        testTurnRightCommand(N, E);
    }

    @Test
    public void shouldSouthWhenEastTurnRight() {
        testTurnRightCommand(E, S);
    }

    @Test
    public void shouldWestWhenSouthTurnRight() {
        testTurnRightCommand(S, W);
    }

    @Test
    public void shouldNorthWhenWestTurnRight() {
        testTurnRightCommand(W, N);
    }

    private void testTurnRightCommand(Direction original, Direction target) {
        MarsRover rover = new MarsRover(0, 0, original);
        rover.exec(new RightPositionCommand());
        assertThat(rover.position()).isEqualTo("0 0 " + target);
    }

    @Test
    public void shouldYPlus1WhenNorthMove() {
        MarsRover rover = new MarsRover(0, 0, N);
        rover.exec(new MoveCommand());
        assertThat(rover.position()).isEqualTo("0 1 " + N);
    }
}
