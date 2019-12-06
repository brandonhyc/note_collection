There are 3 possiblities to satisify one edit distance apart:

    Insert a character into s to get t
    Delete a character from s to get t
    Replace a character of s to get t
class Solution:
    def isOneEditDistance(self, s: str, t: str) -> bool:
        "long" "lon"
        "lon"  "long"
        