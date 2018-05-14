package acherie.marsrover.command;

import acherie.marsrover.position.DirectionPosition;

/**
 * @author wangjie
 * @date 2018/5/12
 */
public class MoveCommand extends AbstractPositionCommand {

    @Override
    protected DirectionPosition onPosition(DirectionPosition position) {
        return position.move();
    }
}
