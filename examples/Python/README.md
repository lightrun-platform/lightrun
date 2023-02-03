# **Python Example**

This document will describe how to get started with Lightrun using a simple Python application.

This application fills an array with 10 random numbers, and then uses a bubble sort algorithm to sort the array.

### Prerequisites

To get started with this tutorial, you will need Python v2.7 (only in certain environments - check detailed link below) or Python v3.6 - v3.10, and pip installed in your environment, and will need to ensure you meet the other system requirements listed. You will also need a compatible IDE, currently VSCode, IntelliJ PyCharm, or VSCode.dev. For more detailed information, please see this link: [https://docs.lightrun.com/python/system-requirements/](https://docs.lightrun.com/python/system-requirements/)

You will also need to sign up for an account with Lightrun at [lightrun.com](http://lightrun.com/)

### Install the IDE Plugin

The first step is to install the Lightrun plugin to your IDE. The instructions for this will vary based on the IDE you are using. Please see this link for instructions: [https://docs.lightrun.com/introduction/plugins/](https://docs.lightrun.com/introduction/plugins/)

You will then need to log in with the plugin.

### Install the Lightrun Agent

The Lightrun agent can easily be added to your environment using pip.

To add it, in your terminal, navigate to the folder which contains the sortArray.py file. Then execute the following command:

python -m pip install lightrun

### Add Lightrun to the Source Code

In a normal Python project, you will need to import Lightrun into your source code, and enable it. In this example, that has already been done for you, but you will still need to add your Lightrun key to the sample code.

To get your Lightrun key, log in to your Lightrun account, click the Lightrun logo in the top left corner of the screen, go into the 'Set up an agent' section, choose Python, scroll down to step 2, and copy just the string value that follows "company\_key"

You will then need to open the sortArray.py file in your IDE, and replace the X's on line 24 with the string you just copied, and save the file

### Starting the Program

To run the program, simply open a terminal and navigate to the folder which contains the sortArray.py file, and execute one of the following commands (depending on your setup):

python sortArray.py 

-OR- 

python3 sortArray.py

### Adding Actions

You can now begin adding actions, such as Dynamic Logs, Snapshots, and Metrics. Specific instructions on these can be found on [https://docs.lightrun.com/](https://docs.lightrun.com/) under the Plugins section, and by selecting your specific IDE.

One thing you can try is logging the 'swaps' variable to view the efficiency of the sort algorithm.

Please note that it is not possible to debug the function in which Lightrun was enabled. In this case, that means you cannot add any actions to the 'main' function.
