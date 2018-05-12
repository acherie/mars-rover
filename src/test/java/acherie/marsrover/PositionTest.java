package acherie.marsrover;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author wangjie
 * @date 2018/5/12
 */
public class PositionTest {

    @Test
    public void Position_ShouldConcat_WhenInit() {
        // given
        Position position = new Position(0, 0, Direction.N);
        // when
        String positionStr = position.position();
        // then
        Assert.assertEquals(positionStr, "0 0 N");
    }
}
