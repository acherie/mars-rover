package acherie.marsrover.command;

import acherie.marsrover.DirectionPosition;
import acherie.marsrover.MarsRover;
import lombok.Setter;

/**
 * @author wangjie
 * @date 2018/5/12
 */
public abstract class AbstractPositionCommand implements Command {

    @Setter
    private MarsRover rover;

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
