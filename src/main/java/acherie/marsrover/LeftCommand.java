package acherie.marsrover;

import lombok.Setter;

/**
 * @author wangjie
 * @date 2018/5/12
 */
public class LeftCommand implements Command {

    @Setter
    private MarsRover rover;

    @Override
    public void exec() {
        Position position = rover.getPosition();
        Direction direction = position.getDirection();

        Direction newDirection;
        switch (direction) {
            case N:
                newDirection = Direction.W;
                break;
            case W:
                newDirection = Direction.S;
                break;
            case S:
                newDirection = Direction.E;
                break;
            case E:
                newDirection = Direction.N;
                break;
            default:
                newDirection = direction;
        }

        Position newPosition = new Position(position.getX(), position.getY(), newDirection);
        rover.setPosition(newPosition);
    }
}
