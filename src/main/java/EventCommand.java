import java.io.IOException;

/**
 * This is a class for command dealing with additions of new event tasks.
 * @author Choong Yong Xin
 */

public class EventCommand extends Command {

    EventCommand(String commandDesc) {
        super(commandDesc);
    }

    /**
     * Returns a boolean to indicate whether the command is an exit command.
     *
     * @return false as command is not an exit command.
     */
    boolean isExit() {
        return false;
    }

    /**
     * Returns a string response by Quack when the command is executed.
     *
     * @param tasks TaskList containing the tasks.
     * @param storage Storage to save the tasks.
     * @return string to be displayed
     */
    @Override
    String execute(TaskList tasks, Storage storage) throws IOException, EmptyDescDukeException {
        try {
            String[] commandLine = commandDesc.substring(6).split(" /at ");
            Event newEvent = new Event(commandLine[0], commandLine[1]);
            storage.appendToFile(System.getProperty("user.dir") + "/data/tasks.txt", newEvent.stringForAppend());
            tasks.addEvent(newEvent);
            String output = "Got it. I've added this task: \n";
            output += newEvent + "\n";
            output += "Now you have " + tasks.taskList.size() + " tasks in the list.\n";
            return output;
        } catch (IndexOutOfBoundsException err) {
            throw new EmptyDescDukeException("event");
        }
    }
}