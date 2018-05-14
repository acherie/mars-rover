package acherie.marsrover;

import acherie.marsrover.command.LeftPositionCommand;
import acherie.marsrover.command.MoveCommand;
import acherie.marsrover.command.RightPositionCommand;
import acherie.marsrover.position.DirectionPosition;
import acherie.marsrover.position.Position;
import acherie.marsrover.position.PositionFactory;
import lombok.Getter;
import lombok.Setter;

/**
 * @author wangjie
 * @date 2018/5/12
 */
public class MarsRover {

    @Getter
    private Position coordinate;

    @Getter
    @Setter
    private DirectionPosition directionPosition;

    public MarsRover() {

    }

    public MarsRover(int x, int y, Direction direction) {
        this.directionPosition = PositionFactory.directionPosition(x, y, direction);
    }

    public String position() {
        return directionPosition.position();
    }

    public void exec(LeftPositionCommand leftCommand) {
        leftCommand.setRover(this);
        leftCommand.exec();
    }

    public void exec(RightPositionCommand rightCommand) {
        rightCommand.setRover(this);
        rightCommand.exec();
    }

    public void exec(MoveCommand moveCommand) {
        moveCommand.setRover(this);
        moveCommand.exec();
    }

    public void setCoordinate(int x, int y) {
        this.coordinate = new Position(x, y);
    }

    public String coordinate() {
        return this.coordinate.position();
    }
}
