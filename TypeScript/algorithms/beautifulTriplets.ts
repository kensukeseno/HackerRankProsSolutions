"use strict";

import { WriteStream, createWriteStream } from "fs";
process.stdin.resume();
process.stdin.setEncoding("utf-8");

let inputString: string = "";
let inputLines: string[] = [];
let currentLine: number = 0;

process.stdin.on("data", function (inputStdin: string): void {
  inputString += inputStdin;
});

process.stdin.on("end", function (): void {
  inputLines = inputString.split("\n");
  inputString = "";

  main();
});

function readLine(): string {
  return inputLines[currentLine++];
}

/*
 * Complete the 'beautifulTriplets' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER d
 *  2. INTEGER_ARRAY arr
 */

function beautifulTriplets(d: number, arr: number[]): number {
  // Write your code here
  let combinations: [number, number][] = [];
  for (let i = 0; i < arr.length - 1; i++) {
    if (arr.find((num) => num === arr[i] + d))
      combinations.push([arr[i], arr[i] + d]);
  }
  console.log(combinations);
  // If the bigger number of the combination is the same as the smaller number of the other combinations, the three numbers can be a beautiful triplet.
  let count = 0;
  for (let i = 0; i < combinations.length - 1; i++) {
    let midNum = combinations[i][1];
    for (let j = i + 1; j < combinations.length; j++) {
      if (combinations[j][0] === midNum) {
        console.log(midNum);
        console.log(combinations[j][0]);
        count++;
        break;
      }
    }
  }
  return count;
}

function main() {
  const ws: WriteStream = createWriteStream(process.env["OUTPUT_PATH"]);

  const firstMultipleInput: string[] = readLine()
    .replace(/\s+$/g, "")
    .split(" ");

  const n: number = parseInt(firstMultipleInput[0], 10);

  const d: number = parseInt(firstMultipleInput[1], 10);

  const arr: number[] = readLine()
    .replace(/\s+$/g, "")
    .split(" ")
    .map((arrTemp) => parseInt(arrTemp, 10));

  const result: number = beautifulTriplets(d, arr);

  ws.write(result + "\n");

  ws.end();
}
