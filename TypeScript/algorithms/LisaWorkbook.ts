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
 * Complete the 'workbook' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER n
 *  2. INTEGER k
 *  3. INTEGER_ARRAY arr
 */

function workbook(n: number, k: number, arr: number[]): number {
  // Write your code here
  let page = 0;
  let count = 0;
  for (let i = 0; i < arr.length; i++) {
    let chapter = i + 1;
    let pageInChapter = 0;

    while (true) {
      page++;
      pageInChapter++;
      let fProbInpage = 1 + k * (pageInChapter - 1);
      let lProbInpage =
        arr[i] < fProbInpage + k - 1 ? arr[i] : fProbInpage + k - 1;
      if (page >= fProbInpage && page <= lProbInpage) {
        count++;
      }

      if (arr[i] - fProbInpage < k) {
        break;
      }
    }
  }

  return count;
}

function main() {
  const ws: WriteStream = createWriteStream(process.env["OUTPUT_PATH"] || "");

  const firstMultipleInput: string[] = readLine()
    .replace(/\s+$/g, "")
    .split(" ");

  const n: number = parseInt(firstMultipleInput[0], 10);

  const k: number = parseInt(firstMultipleInput[1], 10);

  const arr: number[] = readLine()
    .replace(/\s+$/g, "")
    .split(" ")
    .map((arrTemp) => parseInt(arrTemp, 10));

  const result: number = workbook(n, k, arr);

  ws.write(result + "\n");

  ws.end();
}
