#2015 Robot Code

##Getting started:

### Pulling the Code

 1. [Set up and configure][1] your Eclipse and FRC tools installation.

 2. Download and install [git][3] for your system.

If you’re comfortable with command prompt, or would like to become comfortable, continue to the next step. Otherwise, see the wiki for your respective OS. It is highly recommended that you become comfortable with your system’s command prompt.
 
 3. On Linux-based systems, open up a terminal; on Windows, find "Git Bash" in
    the Start Menu and open it up.

 4. You'll start out in your home directory. You'll need to switch over to your
    “workspace” directory, which is usually in your "Documents" folder.
    Run the following command inside your console window:

        cd Documents/workspace

 5. Pull down a copy of this repository by running the following commands:

        git clone git@github.com:frc604/FRC-2015.git

NOTE: If you receive errors when trying "git clone git clone git@github.com:frc604/FRC-2015.git" [read this][5]

 6. Go to Eclipse and create a new “Robot Java Project” (File->New->Project->Robot Java Project) project with the
    following settings:

    | Field            | Value                      |
    | ---------------- | -------------------------- |
    | Project Name     | FRC-2015                   |
    | Project Package  | com._604robotics.robot2015 |
    | Project Type      | Iterative Robot              |

    If you get strange errors starting up the code after a deploy, it's because
    you messed these settings up!
 
 7. Delete the Robot.java file in the project that should now appear. It is located in the com._604robotics.robot2015 package. 

 Congrats! You should now be able to sync with github!
 

 For info on contributing, learning java, and anything else, check the wiki! (It's a bit lacking right now but that will change!)
 
 ### Accessing the JavaDocs
 1. Set up your access to the code like above
 2. In Eclipse, slect the FRC-2015 project
 3. Select Project -> Generate JavaDoc
 4. Make sure FRC-2015, private, and Use Standard Doclet are selected
 5. You're now set up. To view the JavaDoc, go to Navigate->Open Attatched JavaDoc to view the JavaDoc

For everything else, talk to [Alan][4]!

[1]: http://wpilib.screenstepslive.com/s/4485/m/13809/l/145002-installing-eclipse-c-java
[2]: http://eclipse.org/egit/download/
[3]: http://git-scm.com/
[4]: mailto:alanpusongli@gmail.com 
[5]: https://help.github.com/articles/generating-ssh-keys/

TODO:
1. Edit wiki   
2. Figure out what else TODO 