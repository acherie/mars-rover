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

    public static final Position DEFAULT_LOWER_LEFT_COORDINATE = PositionFactory.position(0, 0);

    @Getter
    private Position coordinate;

    private Position lowerLeftCoordinate = DEFAULT_LOWER_LEFT_COORDINATE;

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

        Position position = new Position(x, y);
        validateCoordinate(position);
        this.coordinate = position;
    }

    private void validateCoordinate(Position position) {
        int x = lowerLeftCoordinate.getX();
        int y = lowerLeftCoordinate.getY();
        if (position.getX() <= x || position.getY() <= y) {
            throw new IllegalArgumentException(String.format("Coordinate must greater than (%s, %s)",
                    x, y));
        }
    }

    public String coordinate() {
        return this.coordinate.position();
    }
}
