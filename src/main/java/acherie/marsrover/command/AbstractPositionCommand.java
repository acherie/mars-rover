package acherie.marsrover.command;

import acherie.marsrover.MarsRover;
import acherie.marsrover.position.DirectionPosition;

/**
 * @author wangjie
 * @date 2018/5/12
 */
public abstract class AbstractPositionCommand implements Command {

    private MarsRover rover;

    public void setRover(MarsRover rover) {
        rover.checkInit();
        this.rover = rover;
    }

    @Override
    public void exec() {

        DirectionPosition position = rover.getDirectionPosition();
        DirectionPosition newPosition = onPosition(position);
        rover.setDirectionPosition(newPosition);
    }

    /**
     * Turn direction according current direction
     * @param position
     * @return
     */
    protected abstract DirectionPosition onPosition(DirectionPosition position);
}
