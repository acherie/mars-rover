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
    private int x;
    @Getter
    private int y;
    @Getter
    private Direction p;

    public Position(int x, int y, Direction p) {
        this.x = x;
        this.y = y;
        this.p = p;
    }

    public String position() {
        return String.format("%d %d %s", this.x, this.y, this.p);
    }
}
