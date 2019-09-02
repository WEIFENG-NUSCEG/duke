import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Duke {

    public static void checkDukeInput(String input, Integer length) throws DukeExceptionThrow {

        String ic[] = input.split(" ",2);

        if (!(ic[0].equals("done") || ic[0].equals("todo") || ic[0].equals("deadline") || ic[0].equals("event")||
                ic[0].equals("list"))) {
            throw new DukeExceptionThrow(" \u2639  OOPS!!! I'm sorry, but I don't know what that means :-(");
        }

        if ((ic[0].equals("todo") || ic[0].equals("deadline") || ic[0].equals("event")) && ic.length < 2) {
            throw new DukeExceptionThrow(" \u2639  OOPS!!! The description of a " + ic[0] + " cannot be empty.");
        }
        if (ic[0].equals("deadline"))
        {
            String ik[] = ic[1].split("/by", 2);
            if (ik.length < 2)
            {
                throw new DukeExceptionThrow(" \u2639  OOPS!!! The time of a " + ic[0] + " cannot be empty.");
            }
        }
        if (ic[0].equals("event"))
        {
            String ik[] = ic[1].split("/at", 2);
            if (ik.length < 2)
            {
                throw new DukeExceptionThrow(" \u2639  OOPS!!! The time of a " + ic[0] + " cannot be empty.");
            }
        }
        if (ic[0].equals("done") && ic.length < 2) {
            throw new DukeExceptionThrow(" \u2639  OOPS!!! The task number of a " + ic[0] + " cannot be empty.");
        }

        if (ic[0].equals("done"))
        {
            Integer nt = Integer.parseInt(ic[1]);
            if( nt <= 0 || nt > length )
            {
                throw new DukeExceptionThrow(" \u2639  OOPS!!! The task number of a " + ic[0] + " does not exist.");
            }
        }
    }

    public static void readDukeTask(List<Task> tasks)
    {
        try {
            File newDuke = new File("./data/duke.txt");
            Scanner ss = new Scanner(newDuke);
            while (ss.hasNext()) {
                String[] newTask = ss.nextLine().split(" \\| ");
                if (newTask[0].equals("T"))
                {
                    Task x = new ToDos(newTask[2]);
                    if (newTask[1].equals("1"))
                    {
                        x.markAsDone();
                    }
                    tasks.add(x);
                }
                if (newTask[0].equals("D"))
                {
                    Task t = new Deadline(newTask[2], newTask[3]);
                    if (newTask[1].equals("1"))
                    {
                        t.markAsDone();
                    }
                    tasks.add(t);
                }
                if (newTask[0].equals("E"))
                {
                    Task t = new Events(newTask[2], newTask[3]);
                    if (newTask[1].equals("1"))
                    {
                        t.markAsDone();
                    }
                    tasks.add(t);
                }
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws DukeExceptionThrow {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("Hello! I'm Duke\n What can I do for you?");
        Scanner ss = new Scanner(System.in);
        String input;
        List<Task> a = new ArrayList<Task>();
        readDukeTask(a);

        while(!(input = ss.nextLine()).equals("bye"))
        {
            try
            {
                checkDukeInput(input, a.size());
                String[] w = input.split(" ", 2);

                if (w[0].equals("list"))
                {
                    System.out.println("Here are the tasks in your list: ");
                    for (int c = 0; c < a.size(); c++)
                    {
                        System.out.println( c+1 + "." + a.get(c).toString());
                    }
                }
                else if (w[0].equals("done"))
                {
                    int i = Integer.parseInt(w[1]);
                    Task newT = a.get(i - 1);
                    newT.markAsDone();
                    System.out.println("Nice! I've marked this task as done: \n  " + newT.printStatus());
                }
                else if (w[0].equals("todo"))
                {
                    ToDos t = new ToDos(w[1]);
                    a.add(t);
                    System.out.println("Got it. I've added this task: \n  " + t.toString() + "\n" + "Now you have " +
                            a.size() + " tasks in the list \n");
                }
                else if (w[0].equals("deadline"))
                {
                    String[] temp = w[1].split("/by");
                    Deadline d = new Deadline(temp[0],temp[1]);
                    a.add(d);
                    System.out.println("Got it. I've added this task: \n  " + d.toString() + "\n" + "Now you have " +
                            a.size() + " tasks in the list \n");
                }
                else if (w[0].equals("event"))
                {
                    String[] temp = w[1].split("/at");
                    Events e = new Events(temp[0],temp[1]);
                    a.add(e);
                    System.out.println("Got it. I've added this task: \n  " + e.toString() + "\n" + "Now you have " +
                            a.size() + " tasks in the list \n");
                }
            }
            catch (DukeExceptionThrow e)
            {
                System.out.println(e.getMessage());
            }

        }

        System.out.println("Bye. Hope to see you again soon!");



    }
}
