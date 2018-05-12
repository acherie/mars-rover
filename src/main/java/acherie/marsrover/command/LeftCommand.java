package acherie.marsrover.command;

import acherie.marsrover.Direction;

/**
 * @author wangjie
 * @date 2018/5/12
 */
public class LeftCommand extends AbstractDirectionCommand {

    @Override
    protected Direction turnDirection(Direction direction) {
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
        return newDirection;
    }
}
