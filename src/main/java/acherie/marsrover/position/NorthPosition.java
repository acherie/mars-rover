package acherie.marsrover.position;

import acherie.marsrover.Direction;

/**
 * @author wangjie
 * @date 2018/5/13
 */
public class NorthPosition extends DirectionPosition {

    public NorthPosition(int x, int y) {
        super(x, y, Direction.N);
    }

    @Override
    public DirectionPosition turnLeft() {
        return PositionFactory.west(getX(), getY());
    }

    @Override
    public DirectionPosition turnRight() {
        return PositionFactory.east(getX(), getY());
    }

    @Override
    public DirectionPosition move() {
        return PositionFactory.north(getX(), getY() + 1);
    }
}
