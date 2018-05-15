package acherie.marsrover;

import acherie.marsrover.command.LeftPositionCommand;
import acherie.marsrover.command.MoveCommand;
import acherie.marsrover.command.RightPositionCommand;
import acherie.marsrover.exception.PositionOutOfBoundsException;
import acherie.marsrover.position.Direction;
import org.junit.Test;

import static acherie.marsrover.position.Direction.*;
import static org.assertj.core.api.Assertions.*;

/**
 * @author wangjie
 * @date 2018/5/12
 */
public class MarsRoverTest {

    @Test
    public void shouldAt00PositionWhenNotSetPosition() {
        MarsRover rover = new MarsRover(E);
        assertThat(rover.position()).isEqualTo("0 0 E");
    }

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
        rover.setCoordinate(5, 5);
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
        rover.setCoordinate(5, 5);
        rover.exec(new RightPositionCommand());
        assertThat(rover.position()).isEqualTo("0 0 " + target);
    }

    @Test
    public void shouldYPlus1WhenNorthMove() {
        MarsRover rover = new MarsRover(2, 2, N);
        rover.exec(new MoveCommand());
        assertThat(rover.position()).isEqualTo("2 3 " + N);
    }

    @Test
    public void shouldXPlus1WhenEastMove() {
        MarsRover rover = new MarsRover(2, 2, E);
        rover.exec(new MoveCommand());
        assertThat(rover.position()).isEqualTo("3 2 " + E);
    }

    @Test
    public void shouldYMinus1WhenSouthMove() {
        MarsRover rover = new MarsRover(2, 2, S);
        rover.exec(new MoveCommand());
        assertThat(rover.position()).isEqualTo("2 1 " + S);
    }

    @Test
    public void shouldXMinus1WhenWestMove() {
        MarsRover rover = new MarsRover(2, 2, W);
        rover.exec(new MoveCommand());
        assertThat(rover.position()).isEqualTo("1 2 " + W);
    }

    @Test
    public void shouldSetCoordinateProperly() {
        MarsRover rover = new MarsRover();
        rover.setCoordinate(3, 4);
        assertThat(rover.coordinate()).isEqualTo("3 4");
    }

    @Test
    public void shouldDefaultLowerLeft00() {
        assertThat(MarsRover.DEFAULT_LOWER_LEFT_COORDINATE.position()).isEqualTo("0 0");
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenSet00Coordinate() {
        MarsRover rover = new MarsRover();
        IllegalArgumentException illegalArgumentException =
                catchThrowableOfType(() -> rover.setCoordinate(0, 0), IllegalArgumentException.class);
        assertThat(illegalArgumentException).hasMessage("Coordinate must greater than (%s, %s)",
                MarsRover.DEFAULT_LOWER_LEFT_COORDINATE.getX(), MarsRover.DEFAULT_LOWER_LEFT_COORDINATE.getY());
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenExecCommandIfNotSetPosition() {
        MarsRover rover = new MarsRover();
        IllegalArgumentException exception =
                catchThrowableOfType(() -> rover.exec(new MoveCommand()), IllegalArgumentException.class);
        assertThat(exception).hasMessage("Position must be set before execute command");

        IllegalArgumentException turnException =
                catchThrowableOfType(() -> rover.exec(new LeftPositionCommand()), IllegalArgumentException.class);
        assertThat(turnException).hasMessage("Position must be set before execute command");
    }

    @Test
    public void shouldThrowPositionOutOfBoundsExceptionWhenEastMoveOutOfRange() {
        testThrowPositionOutOfBoundsExceptionWhenMoveOutRange(E);
    }

    @Test
    public void shouldThrowPositionOutOfBoundsExceptionWhenSouthMoveOutOfRange() {
        testThrowPositionOutOfBoundsExceptionWhenMoveOutRange(S);
    }

    @Test
    public void shouldThrowPositionOutOfBoundsExceptionWhenWestMoveOutOfRange() {
        testThrowPositionOutOfBoundsExceptionWhenMoveOutRange(W);
    }

    @Test
    public void shouldThrowPositionOutOfBoundsExceptionWhenNorthMoveOutOfRange() {
        testThrowPositionOutOfBoundsExceptionWhenMoveOutRange(N);
    }

    private void testThrowPositionOutOfBoundsExceptionWhenMoveOutRange(Direction direction) {
        MarsRover rover = new MarsRover(direction);
        rover.setCoordinate(1, 1);
        Throwable throwable = catchThrowable(() -> {
            rover.exec(new MoveCommand());
            rover.exec(new MoveCommand());
        });
        assertThat(throwable).isExactlyInstanceOf(PositionOutOfBoundsException.class);
    }

    @Test
    public void should13NWhen55Coordinate12NPositionLMLMLMLMMCommand() {
        MarsRover rover = new MarsRover();
        rover.setCoordinate(5, 5);
        rover.setDirectionPosition(1, 2, N);
        rover.exec(new LeftPositionCommand());
        rover.exec(new MoveCommand());
        rover.exec(new LeftPositionCommand());
        rover.exec(new MoveCommand());
        rover.exec(new LeftPositionCommand());
        rover.exec(new MoveCommand());
        rover.exec(new LeftPositionCommand());
        rover.exec(new MoveCommand());
        rover.exec(new MoveCommand());

        assertThat(rover.position()).isEqualTo("1 3 N");
    }
}
