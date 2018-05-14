package acherie.marsrover.command;

import acherie.marsrover.DirectionPosition;

/**
 * @author wangjie
 * @date 2018/5/12
 */
public class LeftPositionCommand extends AbstractPositionCommand {

    @Override
    protected DirectionPosition onPosition(DirectionPosition position) {
        return position.turnLeft();
    }
}
