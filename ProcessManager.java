import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.Arrays;
import java.util.Comparator;
public class ProcessManager {
    public static void main(String[] args) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        long[] threadIds = threadMXBean.getAllThreadIds();
        ThreadInfo[] threadInfos = Arrays.stream(threadIds)
                .mapToObj(threadMXBean::getThreadInfo)
                .toArray(ThreadInfo[]::new);
        Arrays.sort(threadInfos, Comparator.comparingInt(ThreadInfo::getPriority));
        for (ThreadInfo threadInfo : threadInfos) {
            String threadName = threadInfo.getThreadName();
            System.out.println("Название процесса: " + threadName);
        }
    }
}