# @param {String} s
# @param {String} t
# @return {Boolean}
def is_anagram(s, t)
    return s.split('').sort() == t.split('').sort()
end
