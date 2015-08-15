/**
 * @param {string} s
 * @return {string}
 */
var shortestPalindrome = function(s) {
    var j = 0;
    for (var i = s.length - 1; i >= 0; i--) {
        if (s[i] == s[j]) {
            j++;
        }
    }
    if (j == s.length) {
        return s;
    }
    var suffix = s.substring(j);
    return suffix.split('').reverse().join('') + shortestPalindrome(s.substring(0, j)) + suffix;
};
