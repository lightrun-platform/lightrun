require('lightrun').start({
  lightrunSecret: 'xxxxx-xxxxx-xxxx-xxxxx-xxxx',
  metadata: {
      filename: './agent.metadata.json'
  }
});

const { randomInt } = require('crypto');

function fillArray() {
  const arr = [];
  for (let i = 0; i < 10; i++) {
    arr.push(randomInt(1, 100));
  }
  return arr;
}

function sortArray(arr) {
  var swaps = 0;
  for (let i = 0; i < arr.length; i++) {
    for (let j = 0; j < arr.length - 1; j++) {
      if (arr[j] > arr[j + 1]) {
        [arr[j], arr[j + 1]] = [arr[j + 1], arr[j]];
        swaps++;
      }
    }
  }
  return arr;
}

async function main(){
  while (true) {
    const arr = fillArray();
    console.log('Original array:', arr);
    const sortedArr = sortArray(arr);
    console.log('Sorted array:', sortedArr);
    await new Promise(r => setTimeout(r, 1000));
    }
  }


setTimeout(() => main());


