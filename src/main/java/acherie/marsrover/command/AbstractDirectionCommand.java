package acherie.marsrover.command;

import acherie.marsrover.Direction;
import acherie.marsrover.MarsRover;
import acherie.marsrover.Position;
import lombok.Setter;

/**
 * @author wangjie
 * @date 2018/5/12
 */
public abstract class AbstractDirectionCommand implements Command {

    @Setter
    private MarsRover rover;

    @Override
    public void exec() {

        Position position = rover.getPosition();
        Direction direction = position.getDirection();

        Direction newDirection = turnDirection(direction);

        Position newPosition = new Position(position.getX(), position.getY(), newDirection);
        rover.setPosition(newPosition);
    }

    /**
     * Turn direction according current direction
     * @param direction
     * @return
     */
    protected abstract Direction turnDirection(Direction direction);
}
