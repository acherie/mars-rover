package acherie.marsrover;

/**
 * @author wangjie
 * @date 2018/5/12
 */
public class MarsRover {

    private Position position;

    public MarsRover(int x, int y, Direction direction) {
        this.position = new Position(x, y, direction);
    }

    public String position() {
        return position.position();
    }
}