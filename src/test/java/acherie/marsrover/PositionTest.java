package acherie.marsrover;

import org.junit.Test;

import static acherie.marsrover.Direction.N;
import static acherie.marsrover.Direction.W;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author wangjie
 * @date 2018/5/12
 */
public class PositionTest {

    @Test
    public void Position_ShouldConcat_WhenInit() {
        // given
        Position position = new Position(0, 0, N);
        // when
        String positionStr = position.position();
        // then
        assertThat(positionStr).isEqualTo("0 0 " + N);
    }

    @Test
    public void shouldNorthWhenWestTurnNorth() {
        // given
        Position position = new Position(0, 0, W);
        // when
        Position newPosition = position.turn(N);
        // then
        assertThat(newPosition.position()).isEqualTo("0 0 " + N);
    }

    @Test
    public void shouldNorthWhenNorthTurnNorth() {
        // given
        Position position = new Position(0, 0, N);
        // when
        Position newPosition = position.turn(N);
        // then
        assertThat(newPosition.position()).isEqualTo("0 0 " + N);
    }

    @Test
    public void shouldXPlus1WhenXMove1() {
        Position position = new Position(0, 0, N);
        Position newPosition = position.moveX(1);
        assertThat(newPosition)
                .extracting(Position::getX, Position::getY, Position::getDirection)
                .contains(position.getX() + 1, position.getY(), position.getDirection());
    }

    @Test
    public void shouldXPlus9WhenMove9() {
        Position position = new Position(0, 0, N);
        Position newPosition = position.moveX(9);
        assertThat(newPosition)
                .extracting(Position::getX, Position::getY, Position::getDirection)
                .contains(position.getX() + 9, position.getY(), position.getDirection());
    }

    @Test
    public void shouldXMinus2WhenMoveN2() {
        Position position = new Position(0, 0, N);
        Position newPosition = position.moveX(-2);
        assertThat(newPosition)
                .extracting(Position::getX, Position::getY, Position::getDirection)
                .contains(position.getX() - 2, position.getY(), position.getDirection());
    }

    @Test
    public void shouldYPlus1WhenMove1() {
        Position position = new Position(0, 0, N);
        Position newPosition = position.moveY(1);
        assertThat(newPosition)
                .extracting(Position::getX, Position::getY, Position::getDirection)
                .containsExactly(position.getX(), position.getY() + 1, position.getDirection());
    }

    @Test
    public void shouldYPlus0WhenMove0() {
        Position position = new Position(0, 0, N);
        Position newPosition = position.moveY(0);
        assertThat(newPosition)
                .extracting(Position::getX, Position::getY, Position::getDirection)
                .containsExactly(position.getX(), position.getY(), position.getDirection());
    }

    @Test
    public void shouldYPlus2WhenMove2() {
        Position position = new Position(0, 0, N);
        Position newPosition = position.moveY(2);
        assertThat(newPosition)
                .extracting(Position::getX, Position::getY, Position::getDirection)
                .containsExactly(position.getX(), position.getY() + 2, position.getDirection());
    }

    @Test
    public void shouldYMinus2WhenMoveN2() {
        Position position = new Position(0, 0, N);
        Position newPosition = position.moveY(-2);
        assertThat(newPosition)
                .extracting(Position::getX, Position::getY, Position::getDirection)
                .containsExactly(position.getX(), position.getY() + (-2), position.getDirection());
    }
}
