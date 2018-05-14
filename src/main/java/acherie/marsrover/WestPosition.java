package acherie.marsrover;

/**
 * @author wangjie
 * @date 2018/5/13
 */
public class WestPosition extends DirectionPosition {

    public WestPosition(int x, int y) {
        super(x, y, Direction.W);
    }

    @Override
    public DirectionPosition turnLeft() {
        return PositionFactory.south(getX(), getY());
    }

    @Override
    public DirectionPosition turnRight() {
        return PositionFactory.north(getX(), getY());
    }

    @Override
    public DirectionPosition move() {
        return PositionFactory.west(getX() - 1, getY());
    }
}
