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
