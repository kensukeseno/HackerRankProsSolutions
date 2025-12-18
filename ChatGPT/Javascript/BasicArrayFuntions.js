// Problem:
// Given an array of numbers, return a new array that contains all elements except
// the first and last.

// Rules
// Use slice()
// Do NOT modify the original array
// Assume the array has at least 2 elements

function removeFirstAndLast(arr) {
  return arr.slice(1, arr.length - 1);
}

// Problem:
// Given an array, remove 2 elements starting from index 1,
// mutate the original array, and return the removed elements.

/* Takeaway: The second parameter in splice() is a length !!! */
function SpliceAndSlicePractice(arr) {
  return arr.splice(1, 2);
}

// Problem:
// Given an array of numbers, return a new array that:
//  Removes the first element
//  Doubles every remaining number

function RemoveFirstDoubleRemaining(arr) {
  return arr.slice(1, arr.length).map((num) => num * 2);
}

// Problem:
// Given an array of numbers, return a new array that contains only unique values (no duplicates).
// Rules
//  Use filter()
//  Use indexOf() or includes()
//  Do NOT use Set

function RemoveDuplicate(arr) {
  // This workd because indexOf() returns the first occurance.
  return arr.filter((value, index) => arr.indexOf(value) === index);
}

// Write a function removeFalsyValues(arr) that takes an array
// and returns a new array with all falsy values removed.

function removeFalsyValues(arr) {
  return arr.filter((val) => val);
}

// Write a function getLastNElements(arr, n) that returns the last n elements of an array.
function getLastNElements(arr, n) {
  return arr.slice(arr.length - n, arr.length);
}

// Question 3:
// Write a function insertAt(arr, index, value) that inserts value into the array at the given index.
// The original array should be modified.

// My answer
function insertAt(arr, index, value) {
  const removed = arr.splice(index, arr.length - index);
  arr.push(value);
  for (let i = 0; i < removed.length; i++) {
    arr.push(removed[i]);
  }
  return arr;
}

// Clean answer
function insertAt(arr, index, value) {
  arr.splice(index, 0, value);
  return arr;
}

// console.log(insertAt([1, 2, 3], 2, 3));

// Write a function flattenArray(arr) that flattens a 2D array into a 1D array.
function flattenArray(arr) {
  const flatArray = [];
  arr.forEach((row) => row.forEach((element) => flatArray.push(element)));
  return flatArray;
}

// Other options
// arr.flat();
// arr.reduce((acc, curr) => acc.concat(curr), []);

// console.log(flattenArray([[1, 2], [3, 4], [5]]));

// Write a function sumBy(arr, key) that takes:
//  an array of objects
//  a key name
// and returns the sum of the values for that key.

function sumBy(arr, key) {
  return arr.reduce((acc, obj) => acc + obj[key], 0);
}

const items = [{ price: 10 }, { price: 20 }, { price: 5 }];

// console.log(sumBy(items, "price"));

// Write a function findFirstEven(arr) that returns the first even number in an array.
// If none exists, return undefined.
function findFirstEven(arr) {
  let even;
  arr.forEach((num) => {
    if (even === undefined && num % 2 === 0) even = num;
  });
  return even;
}

// Better solition: arr.find(num => num % 2 === 0);

// console.log(findFirstEven([1, 3, 7, 4, 6]));

// Write a function hasNegative(arr) that returns true
// if the array contains any negative number, otherwise false.

// Solution 1
// function hasNegative(arr) {
//   let result = false;
//   if (arr.find((num) => num < 0)) {
//     result = true;
//   }
//   return result;
// }

// Solution 2
function hasNegative(arr) {
  return arr.some((num) => num < 0);
}

// console.log(hasNegative([1, 2, -3, 4])); // true
// console.log(hasNegative([1, 2, 3])); // false

// Write a function allPositive(arr) that returns true
// if all numbers are positive, otherwise false.
function allPositive(arr) {
  return arr.every((num) => num > 0);
}

// Write a function sortByAge(users) that sorts an array of objects by age in ascending order.
function sortByAge(users) {
  return users.sort((user1, user2) => user1.age - user2.age);
}
// const users = [
//   { name: "A", age: 30 },
//   { name: "B", age: 20 },
//   { name: "C", age: 25 },
// ];

// console.log(sortByAge(users));

// Write a function countBy(arr) that takes an array of strings and
// returns an object counting how many times each string appears.
// Rules
//  Use reduce()
//  Return an object

// My answer
function countBy(arr) {
  const result = [];
  // Remove duplicates
  const uniqueArr = arr.filter((s, index) => arr.indexOf(s) === index);
  uniqueArr.forEach((s) => {
    let count = arr.reduce((acc, st) => {
      if (st === s) return acc + 1;
      else return acc;
    }, 0);
    result.push({ [s]: count });
  });
  return result;
}

// Better solution
function countBy(arr) {
  const counts = {};
  arr.forEach((item) => {
    counts[item] = (counts[item] || 0) + 1;
  });
  return Object.entries(counts).map(([key, value]) => ({ [key]: value }));
}

console.log(countBy(["a", "b", "a", "c", "b", "a"]));
