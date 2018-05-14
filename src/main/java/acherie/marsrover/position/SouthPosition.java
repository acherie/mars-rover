package acherie.marsrover.position;

import acherie.marsrover.Direction;

/**
 * @author wangjie
 * @date 2018/5/13
 */
public class SouthPosition extends DirectionPosition {

    public SouthPosition(int x, int y) {
        super(x, y, Direction.S);
    }

    @Override
    public DirectionPosition turnLeft() {
        return PositionFactory.east(getX(), getY());
    }

    @Override
    public DirectionPosition turnRight() {
        return PositionFactory.west(getX(), getY());
    }

    @Override
    public DirectionPosition move() {
        return PositionFactory.south(getX(), getY() - 1);
    }
}
