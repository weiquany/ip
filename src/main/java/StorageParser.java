public class StorageParser {
    public static Task parseTaskString(String taskString) throws DukeException {
        Character taskType = taskString.charAt(0);
        String[] arguments = taskString.substring(taskString.indexOf(" | ") + 3).split(" \\| ");
        switch (taskType) {
        case 'T':
            return parseToDo(arguments);
        case 'D':
            return parseDeadline(arguments);
        case 'E':
            return parseEvent(arguments);
        }
        throw new DukeException("Failed to parse task from storage");
    }

    private static Todo parseToDo(String[] arguments) throws DukeException {
        String parseErrorMessage = "Failed to parse todo from storage";
        if (arguments.length != 2) {
            throw new DukeException(parseErrorMessage);
        }
        try {
            boolean isDone = Integer.parseInt(arguments[0]) == 1 ? true : false;
            String description = arguments[1];
            return new Todo(description, isDone);
        } catch (NumberFormatException e) {
            throw new DukeException(parseErrorMessage);
        }
    }

    private static Event parseEvent(String[] arguments) throws DukeException {
        String parseErrorMessage = "Failed to parse event from storage";
        if (arguments.length != 3) {
            throw new DukeException(parseErrorMessage);
        }
        try {
            boolean isDone = Integer.parseInt(arguments[0]) == 1 ? true : false;
            String description = arguments[1];
            String time = arguments[2];
            return new Event(description, isDone, time);
        } catch (NumberFormatException e) {
            throw new DukeException(parseErrorMessage);
        }
    }

    private static Deadline parseDeadline(String[] arguments) throws DukeException {
        String parseErrorMessage = "Failed to parse deadline from storage";
        if (arguments.length != 3) {
            throw new DukeException(parseErrorMessage);
        }
        try {
            boolean isDone = Integer.parseInt(arguments[0]) == 1 ? true : false;
            String description = arguments[1];
            String time = arguments[2];
            return new Deadline(description, isDone, time);
        } catch (NumberFormatException e) {
            throw new DukeException(parseErrorMessage);
        }
    }
}