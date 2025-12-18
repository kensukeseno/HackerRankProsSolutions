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
