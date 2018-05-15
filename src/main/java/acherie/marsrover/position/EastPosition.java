package acherie.marsrover.position;

/**
 * @author wangjie
 * @date 2018/5/13
 */
public class EastPosition extends DirectionPosition {

    public EastPosition(int x, int y) {
        super(x, y, Direction.E);
    }

    @Override
    public DirectionPosition turnLeft() {
        return PositionFactory.north(getX(), getY());
    }

    @Override
    public DirectionPosition turnRight() {
        return PositionFactory.south(getX(), getY());
    }

    @Override
    public DirectionPosition move() {
        return PositionFactory.east(getX() + 1, getY());
    }
}
