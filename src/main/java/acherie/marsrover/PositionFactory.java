package acherie.marsrover;

import acherie.marsrover.exception.UnsupportedDirectionException;

/**
 * @author wangjie
 * @date 2018/5/13
 */
public class PositionFactory {

    private PositionFactory() {}

    public static DirectionPosition north(int x, int y) {
        return new NorthPosition(x, y);
    }

    public static DirectionPosition west(int x, int y) {
        return new WestPosition(x, y);
    }

    public static DirectionPosition east(int x, int y) {
        return new EastPosition(x, y);
    }

    public static DirectionPosition south(int x, int y) {
        return new SouthPosition(x, y);
    }

    public static DirectionPosition directionPosition(int x, int y, Direction direction) {

        switch (direction) {
            case E:
                return east(x, y);
            case S:
                return south(x, y);
            case W:
                return west(x, y);
            case N:
                return north(x, y);
            default:
                throw new UnsupportedDirectionException();
        }
    }
}
