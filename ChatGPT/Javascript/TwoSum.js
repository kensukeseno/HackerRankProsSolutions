// Problem
// Given an array of integers nums and an integer target, return the indices of the two numbers such that they add up to target.

// Rules
// Exactly one solution
// Don’t use the same element twice
// Return indices in any order

/* Take away: Map.has() / Set.has() are O(1) !!!! */

// My answer: O(n²) and wrong answer when twoSum([3, 3], 6)
// function twoSum(nums, target) {
//   const answer = [];

//   for (let i = 0; i < nums.length - 1; i++) {
//     let diff = target - nums[i];
//     let index = nums.indexOf(diff);
//     if (index != -1) {
//       answer.push(i);
//       answer.push(nums.indexOf(diff));
//       break;
//     }
//   }

//   return answer;
// }

function twoSum(nums, target) {
  const map = new Map(); // value -> index

  for (let i = 0; i < nums.length; i++) {
    const diff = target - nums[i];

    if (map.has(diff)) {
      return [map.get(diff), i];
    }

    map.set(nums[i], i);
  }
}

console.log(twoSum([2, 7, 11, 15], 9));

// Problem 2 — Longest Substring Without Repeating Characters
// Problem
// Given a string s, find the length of the longest substring without repeating characters.

// Interview expectations
// Time: O(n)
// Technique: Sliding Window
// Data structure: Set or Map

/* Take away: Use two pointers !!!! */

// First attempt: wrong
// function lengthOfLongestSubstring(s) {
//   let maxLen = 0;

//   let map = new Map();

//   for (let i = 0; i < s.length; i++) {
//     if (!map.has(s[i])) {
//       map.set(s[i], i);
//       if (map.size > maxLen) maxLen = map.size;
//     } else {
//       map.clear();
//     }
//   }

//   return maxLen;
// }

// Answer
function lengthOfLongestSubstring(s) {
  const map = new Map(); // char -> last index
  let left = 0;
  let maxLen = 0;

  for (let right = 0; right < s.length; right++) {
    const char = s[right];

    if (map.has(char) && map.get(char) >= left) {
      left = map.get(char) + 1;
    }

    map.set(char, right);
    maxLen = Math.max(maxLen, right - left + 1);
  }

  return maxLen;
}

console.log(lengthOfLongestSubstring("abcabcbb")); // 3 ("abc")
console.log(lengthOfLongestSubstring("bbbbb")); // 1 ("b")
console.log(lengthOfLongestSubstring("pwwkew")); // 3 ("wke")

// Problem: isValidSudoku

// Description:

// Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to these rules:
//  Each row must contain the digits 1-9 without repetition.
//  Each column must contain the digits 1-9 without repetition.
//  Each of the nine 3x3 sub-boxes must contain the digits 1-9 without repetition.
// The board is represented as a 2D array of characters, where '.' indicates an empty cell.

/* Take away: "Set": Stores unique values only. Fast membership testing (O(1) average) !!!! */

function isValidSudoku(board) {
  const rows = Array.from({ length: 9 }, () => new Set());
  const cols = Array.from({ length: 9 }, () => new Set());
  const boxes = Array.from({ length: 9 }, () => new Set());

  for (let r = 0; r < 9; r++) {
    for (let c = 0; c < 9; c++) {
      const val = board[r][c];
      if (val === ".") continue;

      const boxIndex = Math.floor(r / 3) * 3 + Math.floor(c / 3);

      if (rows[r].has(val) || cols[c].has(val) || boxes[boxIndex].has(val)) {
        return false;
      }

      rows[r].add(val);
      cols[c].add(val);
      boxes[boxIndex].add(val);
    }
  }

  return true;
}

const board = [
  ["5", "3", ".", ".", "7", ".", ".", ".", "."],
  ["6", ".", ".", "1", "9", "5", ".", ".", "."],
  [".", "9", "8", ".", ".", ".", ".", "6", "."],
  ["8", ".", ".", ".", "6", ".", ".", ".", "3"],
  ["4", ".", ".", "8", ".", "3", ".", ".", "1"],
  ["7", ".", ".", ".", "2", ".", ".", ".", "6"],
  [".", "6", ".", ".", ".", ".", "2", "8", "."],
  [".", ".", ".", "4", "1", "9", ".", ".", "5"],
  [".", ".", ".", ".", "8", ".", ".", "7", "9"],
];

console.log(isValidSudoku(board)); // true
