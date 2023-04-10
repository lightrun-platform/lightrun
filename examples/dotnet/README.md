This document will describe how to get started with Lightrun using a simple .NET application.

This application simply prints a sequence of the Fibonacci numbers.

**Prerequisites**

To get started with this tutorial, you will need to ensure you have the below listed requirements matched. You will also need a compatible IDE, currently we support Rider IDE, VSCode, or VSCode.dev. For more detailed information, please see this link: https://docs.lightrun.com/dotnet/system-requirements/

You will also need to sign up for an account with Lightrun at https://lightrun.com

**Install the IDE Plugin**

The first step is to install the Lightrun plugin to your IDE from the IDE marketplace extension menu. The instructions for this will vary based on the IDE you are using.

You will then need to log in with the plugin.

Install the .NET package by running the following command from your IDE terminal

**dotnet add package Lightrun**

**Install the Lightrun Agent**

The Lightrun agent (https://docs.lightrun.com/dotnet/agent-configuration/) should be added to your project together with your agent secret key that can be obtained from the Lightrun management portal (https://app.lightrun.com).

In the Program.cs code sample the relevant code lines are already added, you should only specify your secret key.

**Starting the Program**

To run the program, simply open a terminal within your IDE, or command-lineand navigate to the folder which contains the Program.cs file, and execute the app.

**Adding Actions**

You can now begin adding actions, such as Dynamic Logs (including conditional), and Snapshots (including conditional). 
Specific instructions on these can be found on https://docs.lightrun.com/ under the Plugins section, and by selecting your specific IDE.

One thing you can try is logging the 'swaps' variable to view the efficiency of the sort algorithm.
