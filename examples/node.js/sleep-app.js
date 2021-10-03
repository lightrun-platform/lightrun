// ---------- Import Lightrun Agent ----------
require('lightrun').start({
    company: 'COMPANY-NAME',
    lightrunSecret: 'YOUR-LIGHTRUN-KEY',
    metadata: {
        filename: './agent.metadata.json'
    }
});
// -------------------------------------------

async function sleepLoop() {
    console.log("Start sleeping in loop");
    for (let i = 0; i < 10000; i++) {
        await new Promise(r => setTimeout(r, 5000));
        console.log("tick");
    }
}

setTimeout(() => sleepLoop());