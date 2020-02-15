const twoSum = function (nums, target) {
  let map = {};
  for (let i = 0; i < nums.length; i++) {
    if (map[nums[i]] !== undefined && map[nums[i]] !== i) {
      return [map[nums[i]], i];
    }
    map[target - nums[i]] = i;
  }
  return [];
};

console.log(twoSum([2, 7, 11, 15], 9));
