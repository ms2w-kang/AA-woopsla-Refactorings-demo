package dip03.replace.conditional.dispatcher.to.command;

import java.util.*;

/**
 * <h3>SMELL: Switch Statement</h3>
 * <ul>
 *   <li> Conditional logic is used to dispatch requests and execute actions.
 * </ul>
 * <h3>TREATMENT: Replace Conditional Dispatcher with Command</h3>
 * <ul>
 *   <li> Create a Command for each action.
 *   <li> Store the Commands in a collection and replace the conditional
 *      logic with code to fetch and execute Commands.
 * </ul>
 */

public class CommandLineUI {

    private Library lib;

    public CommandLineUI(Library lib) {
        this.lib = lib;
    }

    public void printHeader() {
        System.out.println("COMMANDS:");
        System.out.println("addUser name, address, phone");
        System.out.println("addBook title, authors, ISBN");
        /*
         * Add commands later
         */
        System.out.println("exit");
    }

    public static String[] getArgs(String cmd) {
        String args[] = new String[0];
        String s = cmd.trim();
        if (s.indexOf(" ") != -1) {
            s = s.substring(s.indexOf(" "));
            args = s.trim().split(",");
            for (int i = 0; i < args.length; i++)
                args[i] = args[i].trim();
        }
        return args;
    }

    /*
     * Conditional-dispatcher
     */
    public void dispatchCommand(String cmd) {
        String args[] = getArgs(cmd);
        if (cmd.startsWith("addUser")) {
            if (args.length < 3) return;
            lib.addUser(args[0], args[1], args[2]);
            System.out.println("Added user: " + args[0] + " - " + args[1] + " - " + args[2]);
        } else if (cmd.startsWith("addBook")) {
            if (args.length < 3) return;
            lib.addBook(args[0], args[1], args[2]);
            System.out.println("Added user: " + args[0] + " - " + args[1] + " - " + args[2]);
        }
        /*
         * else if .........
         */
    }

    public void process() {
        printHeader();

        String s = "";
        Scanner scanner = new Scanner(System.in);

        s = scanner.nextLine();
        while (!s.equals("exit")) {
            dispatchCommand(s);
            s = scanner.nextLine();
        }

        scanner.close();
    }

}
