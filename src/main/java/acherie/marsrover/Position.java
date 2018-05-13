package acherie.marsrover;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * @author wangjie
 * @date 2018/5/12
 */
@ToString
@EqualsAndHashCode
public class Position {

    @Getter
    private final int x;
    @Getter
    private final int y;
    @Getter
    private final Direction direction;

    public Position(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public String position() {
        return String.format("%d %d %s", this.x, this.y, this.direction);
    }

    public Position turn(Direction direction) {
        return new Position(this.x, this.y, direction);
    }

    public Position moveX(int i) {
        return new Position(this.x + i, this.y, this.direction);
    }

    public Position moveY(int i) {
        return new Position(this.x, this.y + i, this.direction);
    }
}
