package acherie.marsrover;

/**
 * @author wangjie
 * @date 2018/5/12
 */
@FunctionalInterface
public interface Command {

    /**
     * 执行
     */
    void exec();
}
