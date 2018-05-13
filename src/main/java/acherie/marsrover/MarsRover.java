package acherie.marsrover;

import acherie.marsrover.command.LeftCommand;
import acherie.marsrover.command.MoveCommand;
import acherie.marsrover.command.RightCommand;
import lombok.Getter;
import lombok.Setter;

/**
 * @author wangjie
 * @date 2018/5/12
 */
public class MarsRover {

    @Getter
    @Setter
    private Position position;

    public MarsRover(int x, int y, Direction direction) {
        this.position = new Position(x, y, direction);
    }

    public String position() {
        return position.position();
    }

    public void exec(LeftCommand leftCommand) {
        leftCommand.setRover(this);
        leftCommand.exec();
    }

    public void exec(RightCommand rightCommand) {
        rightCommand.setRover(this);
        rightCommand.exec();
    }

    public void exec(MoveCommand moveCommand) {
        moveCommand.setRover(this);
        moveCommand.exec();
    }
}
