package acherie.marsrover.position;

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

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String position() {
        return String.format("%d %d", this.x, this.y);
    }

}
