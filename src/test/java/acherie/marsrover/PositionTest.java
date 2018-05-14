package acherie.marsrover;

import acherie.marsrover.position.DirectionPosition;
import org.junit.Test;

import static acherie.marsrover.position.PositionFactory.*;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author wangjie
 * @date 2018/5/12
 */
public class PositionTest extends BaseTest {

    @Test
    public void Position_ShouldConcat_WhenInit() {
        // given
        DirectionPosition position = north(0, 0);
        // when
        String positionStr = position.position();
        // then
        assertThat(positionStr).isEqualTo("0 0 " + NORTH);
    }

    @Test
    public void shouldYPlus1WhenNorthMove() {
        DirectionPosition position = north(0, 0);
        DirectionPosition newPosition = position.move();
        assertThat(newPosition.position()).isEqualTo("0 1 " + NORTH);
    }

    @Test
    public void shouldXPlus1WhenEastMove() {
        DirectionPosition position = east(0, 0);
        DirectionPosition newPosition = position.move();
        assertThat(newPosition.position()).isEqualTo("1 0 " + EAST);
    }

    @Test
    public void shouldYMinus1WhenSouthMove() {
        DirectionPosition position = south(0, 0);
        DirectionPosition newPosition = position.move();
        assertThat(newPosition.position()).isEqualTo("0 -1 " + SOUTH);
    }

    @Test
    public void shouldXMinus1WhenWestMove() {
        DirectionPosition position = west(0, 0);
        DirectionPosition newPosition = position.move();
        assertThat(newPosition.position()).isEqualTo("-1 0 " + WEST);
    }
}
