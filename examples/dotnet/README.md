This document will describe how to get started with Lightrun using a simple .NET application.

This application simply prints a sequence of the Fibonacci numbers.

**Prerequisites**

To get started with this tutorial, you will need to ensure you have the below listed requirements matched. You will also need a compatible IDE, currently we support Rider IDE, VSCode, or VSCode.dev. For more detailed information, please see this link: https://docs.lightrun.com/dotnet/system-requirements/

You will also need to sign up for an account with Lightrun at https://lightrun.com

**Install the IDE Plugin**

The first step is to install the Lightrun plugin to your IDE from the IDE marketplace extension menu. The instructions for this will vary based on the IDE you are using.

You will then need to log in with the plugin.

Install the .NET package by running the following command from your IDE terminal

`dotnet add package Lightrun`

**Install the Lightrun Agent**

The Lightrun agent (https://docs.lightrun.com/dotnet/agent-configuration/) should be added to your project together with your agent secret key that can be obtained from the Lightrun management portal (https://app.lightrun.com).

In the Program.cs code sample the relevant code lines are already added, you should only specify your secret key.

**Starting the Program**

To run the program, simply open a terminal within your IDE, or access the command line however you would normally, navigate to the folder which contains the Program.cs file, and execute the app.

**Adding Actions**

Now that the application is running you can begin adding Lightrun actions such as Dynamic Logs and Snapshots from your IDE.
By doing so you can observe the run-time state of the application without changing the code!
