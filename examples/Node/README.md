# **NodeJS Example**

This document will describe how to get started with Lightrun using a simple NodeJS application.

This application fills an array with 10 random numbers, and then uses a bubble sort algorithm to sort the array.

### Prerequisites

To get started with this tutorial, you will need Node v10 or higher, and NPM installed in your environment, and will need to ensure you meet the other system requirements listed. You will also need a compatible IDE, currently IntelliJ IDEA, Webstorm, VSCode, or VSCode.dev. For more detailed information, please see this link: [https://docs.lightrun.com/node/system-requirements/](https://docs.lightrun.com/node/system-requirements/)

You will also need to sign up for an account with Lightrun at [lightrun.com](http://lightrun.com/)

### Install the IDE Plugin

The first step is to install the Lightrun plugin to your IDE. The instructions for this will vary based on the IDE you are using. Please see this link for instructions: [https://docs.lightrun.com/introduction/plugins/](https://docs.lightrun.com/introduction/plugins/)

You will then need to log in with the plugin.

### Install the Lightrun Agent

The Lightrun agent can easily be added to your project using NPM.

To add it to this example, in your terminal, navigate to the folder which contains the sortArray.js file. Then execute the following command:

npm install lightrun

### Add Lightrun to the Source Code

In a normal NodeJS project, you will need to import Lightrun into your source code, and start it. In this example, that has already been done for you, but you will still need to add your Lightrun secret to the sample code.

To get your Lightrun secret, log in to your Lightrun account, click the Lightrun logo in the top left corner of the screen, go into the 'Set up an agent' section, choose Node.js, scroll down to step 3, and copy just the string value that follows "lightrunSecret"

You will then need to open the sortArray.js file in your IDE, and replace the X's on line 2 with the string you just copied, and save the file

### Starting the Program

To run the program, simply open a terminal and navigate to the folder which contains the sortArray.js file, and execute the following command:

node sortArray.js

### Adding Actions

You can now begin adding actions, such as Dynamic Logs, Snapshots, and Metrics. Specific instructions on these can be found on [https://docs.lightrun.com/](https://docs.lightrun.com/) under the Plugins section, and by selecting your specific IDE.

One thing you can try is logging the 'swaps' variable to view the efficiency of the sort algorithm.
