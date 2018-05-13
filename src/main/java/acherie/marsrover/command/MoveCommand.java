package acherie.marsrover.command;

import acherie.marsrover.Direction;
import acherie.marsrover.MarsRover;
import acherie.marsrover.Position;
import lombok.Setter;

/**
 * @author wangjie
 * @date 2018/5/12
 */
public class MoveCommand implements Command {

    @Setter
    private MarsRover rover;

    @Override
    public void exec() {
        Position position = rover.getPosition();
        Direction direction = position.getDirection();
        if (direction == Direction.N) {
            position = position.moveY(1);
        } else if (direction == Direction.S) {
            position = position.moveY(-1);
        } else if (direction == Direction.W) {
            position = position.moveX(-1);
        } else if (direction == Direction.E) {
            position = position.moveX(1);
        }
        rover.setPosition(position);
    }
}
