package acherie.marsrover;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * @author wangjie
 * @date 2018/5/14
 */
@EqualsAndHashCode(callSuper = true)
public abstract class DirectionPosition extends Position {

    @Getter
    private final Direction direction;

    public DirectionPosition(int x, int y, Direction direction) {
        super(x, y);
        this.direction = direction;
    }

    @Override
    public String position() {
        return String.format("%d %d %s", getX(), getY(), getDirection());
    }

    /**
     * 左转
     * @return
     */
    public abstract DirectionPosition turnLeft();

    /**
     * 右转
     * @return
     */
    public abstract DirectionPosition turnRight();

    /**
     * 移动
     * @return
     */
    public abstract DirectionPosition move();
}
