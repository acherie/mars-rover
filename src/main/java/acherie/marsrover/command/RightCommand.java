package acherie.marsrover.command;

import acherie.marsrover.Direction;

import static acherie.marsrover.Direction.*;

/**
 * @author wangjie
 * @date 2018/5/12
 */
public class RightCommand extends AbstractDirectionCommand {

    @Override
    protected Direction turnDirection(Direction direction) {
        Direction newDirection;
        switch (direction) {
            case N:
                newDirection = E;
                break;
            case E:
                newDirection = S;
                break;
            case S:
                newDirection = W;
                break;
            case W:
                newDirection = N;
                break;
            default:
                newDirection = direction;
        }
        return newDirection;
    }
}
