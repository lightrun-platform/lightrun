# **Java Example**

This document will describe how to get started with Lightrun using a simple Java application.

This application fills an array with 10 random numbers, and then uses a bubble sort algorithm to sort the array.

### Prerequisites

To get started with this tutorial, you will need Java 7 or higher installed in your environment, and will need to ensure you meet the other system requirements listed. You will also need a compatible IDE, currently VSCode, IntelliJ IDEA, or VSCode.dev. For more detailed information, please see this link: [https://docs.lightrun.com/jvm/system-requirements/](https://docs.lightrun.com/jvm/system-requirements/)

You will also need to sign up for an account with Lightrun at [lightrun.com](http://lightrun.com/)

### Install the IDE Plugin

The first step is to install the Lightrun plugin to your IDE. The instructions for this will vary based on the IDE you are using. Please see this link for instructions: [https://docs.lightrun.com/introduction/plugins/](https://docs.lightrun.com/introduction/plugins/)

You will then need to log in with the plugin.

### Install the Java Agent

Next, you will need to install the Java agent. The process for this will vary based on your operating system, but is generally accomplished through a curl command. To find the exact command you need, log in to the Lightrun website, and click the Lightrun logo in the top left corner. Go to the "Set up an agent" section, choose java, and choose your environment. Your command will automatically be populated with the company ID and secret assigned to you by lightrun.

IMPORTANT: The company ID and secret are used to identify your account - make sure you are logged into the IDE with the same account you are using to access the curl command, otherwise you will not be able to see any actions you set up.

Open a command terminal, change to the directory where your Java file lives, and execute that curl command.

An example for a Mac with Apple silicon is:

LIGHTRUN_KEY=xxxx-xxxxx-xxxx-xxxx zsh -c "$(curl -L "https://app.lightrun.com/public/download/company/xxxx-xxxxx-xxxxx-xxx/install-agent.sh?platform=mac_m1")"

With the X's being replaced by your unique company ID and secret values.

Once the install is complete, you will see a note in your terminal giving you the path of your agent. Be sure to make a note of this.

### Compile the Java Program

Next, you will need to compile the java code. IMPORTANT - you must use the -g flag during compilation, or you will run into errors.

The command for this tutorial is javac -g SortArray.java

### Starting the Program

When starting the sample program, you will need to specify the location of the Lightrun agent. The full command to run the program is:

java -agentpath:/path/to/agent/lightrun_agent.so SortArray

Make sure to replace /path/to/agent/ with the proper path to your agent. This must be a relative path.

### Adding Actions

Next, you will need to open the source code in your IDE - in this case, the SortArray.java file.

You can now begin adding actions, such as Dynamic Logs, Snapshots, and Metrics. Specific instructions on these can be found on [https://docs.lightrun.com/](https://docs.lightrun.com/) under the Plugins section, and by selecting your specific IDE.

One thing you can try is logging the 'swaps' variable to view the efficiency of the sort algorithm.
