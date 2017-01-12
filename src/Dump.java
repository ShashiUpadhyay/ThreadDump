import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @author shashiupadhyay
 *
 */
public class Dump {

	   /**
	 * @return String
	 */
	public static String GenerateThreadDump() {
	        final StringBuilder dump = new StringBuilder();
	        final ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
	        final ThreadInfo[] threadInfos = threadMXBean.getThreadInfo(threadMXBean.getAllThreadIds(), 100);
	        for (ThreadInfo threadInfo : threadInfos) {
	            dump.append('"');
	            dump.append(threadInfo.getThreadName());
	            dump.append("\" ");
	            final Thread.State state = threadInfo.getThreadState();
	            dump.append("\n   java.lang.Thread.State: ");
	            dump.append(state);
	            final StackTraceElement[] stackTraceElements = threadInfo.getStackTrace();
	            for (final StackTraceElement stackTraceElement : stackTraceElements) {
	                dump.append("\n        at ");
	                dump.append(stackTraceElement);
	            }
	            dump.append("\n\n");
	        }
	        System.out.println(dump.toString());
	        return dump.toString();
	    }
	   
	 /**
	 * @param args
	 */
	public static void main(String[] args) {
		 GenerateThreadDump();
	}
}
