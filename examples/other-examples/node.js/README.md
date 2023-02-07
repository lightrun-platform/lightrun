# Sample Node.js App

This is a sample Node.js application for running Lightrun, that consumes metadata from an `agent.metadata.js` JSON file.
The app is a sleep loop, that prints a message every 5 seconds.

To run Lightrun with an app you need your configuration details. To find these, log into the [Lightrun Management Portal](https://app.lightrun.com/) and look inside the **Download the Agent** section. Fill your params for `company` and `lightrunSecret` in the JSON object that is provided to the `start` method.

**Note:** Use `npm install lightrun` to install the Lightrun agent for Node.js.
